package org.example;

import org.example.structures.Decisioning;
import org.example.structures.EmiLoanRationale;
import org.example.structures.Result;
import org.example.structures.User;

/**
 * Validates eligibility of user for being processed for loan
 */
public class DecisionFilter {
    public Result checkUserEligibility (User user, Decisioning decisioning, Result result) {
        result.setAccepted(true);

        if (decisioning.isRejectNegativeTrigger1()) {
            if (user.isNegativeTrigger1()) {
                System.out.println("Current user is rejected, due to its negativeTrigger1 being " + user.isNegativeTrigger1());

                result.setAccepted(false);
                result.setReasonForRejection("User's negativeTrigger1 = true");
            }
        }

        if (user.getLeverageAttributeA() < decisioning.getMinimumLeverageAttributeA()) {
            System.out.printf("Current user is rejected, due to its leverageAttributeA (%f) < minimum required (%d)\n",

                    user.getLeverageAttributeA(), decisioning.getMinimumLeverageAttributeA());
            result.setAccepted(false);
            result.setReasonForRejection(String.format("User's leverageAttributeA (%f) < minimum required (%d)",
                    user.getLeverageAttributeA(), decisioning.getMinimumLeverageAttributeA()));
        }

        return result;
    }

    public Result checkIfAnyTenureOffered (Result result) {
        for (EmiLoanRationale emiLoanRationale : result.getTenureEmiLoanRationaleMap().values()) {
            boolean isCurrTenureOffered = emiLoanRationale.getOffered();
            if (isCurrTenureOffered) {
                return result;
            }
        }

        result.setAccepted(false);
        result.setReasonForRejection("No tenure option is valid");
        return result;
    }
}
