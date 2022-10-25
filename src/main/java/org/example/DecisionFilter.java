package org.example;

import org.example.structures.Decisioning;
import org.example.structures.User;

/**
 * Validates eligibility of user for being processed for loan
 */
public class DecisionFilter {
    public boolean checkUserEligibility (User user, Decisioning decisioning) {
        if (decisioning.isRejectNegativeTrigger1()) {
            if (user.isNegativeTrigger1()) {
                System.out.println("Current user is rejected, due to its negativeTrigger1 being " + user.isNegativeTrigger1());
                return false;
            }
        }

        if (user.getLeverageAttributeA() < decisioning.getMinimumLeverageAttributeA()) {
            System.out.printf("Current user is rejected, due to its leverageAttributeA (%f) < minimum required (%d)\n",
                    user.getLeverageAttributeA(), decisioning.getMinimumLeverageAttributeA());
            return false;
        }

        return true;
    }
}
