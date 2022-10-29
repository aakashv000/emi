package org.example;

import org.example.structures.EmiLoanRationale;
import org.example.structures.MaxEmiBasedOnLeverageAttributeATenure;
import org.example.structures.PolicyParams;
import org.example.structures.Result;
import org.example.structures.User;
import org.example.utils.ArrayUtil;
import java.util.Map;

/**
 * Checks all options of tenures & emi that can be proposed to the user
 */
public class PolicyFilter {
    /**
     * @param policyParams
     * @param result
     * @return valid/allowed tenure options, for the given user
     */
    public Result validateLoanAmountRange(PolicyParams policyParams, Result result) {
        float roi = result.getRoi();

        int[] allTenures = policyParams.getAllTenures();
        Map<String, Integer> minAmountTenureMap = policyParams.getMinAmountTenure();
        Map<String, Integer> maxAmountTenureMap = policyParams.getMaxAmountTenure();

        for (int tenure: allTenures) {
            float emiForTenure = result.getTenureEmiLoanRationaleMap().get(tenure).getEmi();

            double loanAmount = new Calculate().calLoanAmount(emiForTenure, roi, tenure);
//            System.out.println(loanAmount);

            Integer minAmount = minAmountTenureMap.get(String.valueOf(tenure));
            Integer maxAmount = maxAmountTenureMap.get(String.valueOf(tenure));

            if (loanAmount < minAmount) {
                result.getTenureEmiLoanRationaleMap().get(tenure).setOffered(false);
                result.getTenureEmiLoanRationaleMap().get(tenure).setLoanRationale(String.format("Calculated max loan amount (%f) user can pay < minimum required (%d)", loanAmount, minAmount));

//                System.out.println(String.format("For tenure of %d months, calculated loan amount (%f) < minimum allowed (%d)!", tenure, loanAmount, minAmount));
            }
            else if (loanAmount > maxAmount) {
                result.getTenureEmiLoanRationaleMap().get(tenure).setLoan(maxAmount);
                result.getTenureEmiLoanRationaleMap().get(tenure).setLoanRationale(String.format("Calculated max loan amount (%f) user can pay > maximum offered (%d)", loanAmount, maxAmount));

//                System.out.println(String.format("For tenure of %d months, calculated loan amount (%f) > maximum allowed (%d)!", tenure, loanAmount, maxAmount));
            }
            else {
                result.getTenureEmiLoanRationaleMap().get(tenure).setLoan((int) loanAmount);
            }
        }

        return result;
    }

    /**
     * Upper bound EMI based on leverageAttributeA
     */
    public Result capEmi(User user, MaxEmiBasedOnLeverageAttributeATenure maxEmiBasedOnLeverageAttributeATenure, Result result) {
        float emi = result.getEmiSelectedPAMap().keySet().toArray(new Float[1])[0];

        float leverageAttributeA = user.getLeverageAttributeA();
        int j = ArrayUtil.getBucketIndexOfValue(maxEmiBasedOnLeverageAttributeATenure.getLeverageAttributeABucket(), leverageAttributeA);

        int[] allTenures = maxEmiBasedOnLeverageAttributeATenure.getTenure();
        for (int i = 0; i < allTenures.length; i++) {
            int tenure = allTenures[i];

            int maxEmi = maxEmiBasedOnLeverageAttributeATenure.getValues()[i][j];

            EmiLoanRationale emiLoanRationale = new EmiLoanRationale();
            if (emi > maxEmi) {
                emiLoanRationale.setEmi((float) maxEmi);
                emiLoanRationale.setEmiRationale(String.format("Calculated EMI (%f) > maximum allowed (%d)", emi, maxEmi));

//                System.out.printf("Calculated EMI (%f) is greater than maximum allowed (%d), for given tenure (%d) and user's leverageAttributeA (%f).\n", emi, maxEmi, tenure, leverageAttributeA);
//                System.out.printf("Hence, EMI granted for tenure (%d) is %f\n", tenure, (float) maxEmi);
            }
            else {
                emiLoanRationale.setEmi(emi);

//                System.out.printf("EMI granted for tenure (%d) is %f\n", tenure, emi);
            }

            result.putTenureEmiLoanRationaleMap(tenure, emiLoanRationale);
        }

        return result;
    }
}
