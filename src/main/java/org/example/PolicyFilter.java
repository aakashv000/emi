package org.example;

import org.example.structures.MaxEmiBasedOnLeverageAttributeATenure;
import org.example.structures.PolicyParams;
import org.example.structures.User;
import org.example.utils.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Checks all options of tenures & emi that can be proposed to the user
 */
public class PolicyFilter {
    // TODO: confirm that first loan amount range is validated and then max emi
    // TODO: confirm if allTenures and MaxEmi.Tenure will always be same

    /**
     * @param emi
     * @param roi
     * @param policyParams
     * @return valid/allowed tenure options, for the given user
     */
    public ArrayList<Integer> validateLoanAmountRange(float emi, int roi, PolicyParams policyParams) {
        ArrayList<Integer> validTenures = new ArrayList<>();

        int[] allTenures = policyParams.getAllTenures();
        Map<String, Integer> minAmountTenureMap = policyParams.getMinAmountTenure();
        Map<String, Integer> maxAmountTenureMap = policyParams.getMaxAmountTenure();

        for (int tenure: allTenures) {
            double loanAmount = new Calculate().calLoanAmount(emi, roi, tenure);
            System.out.println(loanAmount);

            Integer minAmount = minAmountTenureMap.get(String.valueOf(tenure));
            Integer maxAmount = maxAmountTenureMap.get(String.valueOf(tenure));

            if (loanAmount < minAmount) {
                System.out.println(String.format("For tenure of %d months, calculated loan amount (%f) < minimum allowed (%d)!", tenure, loanAmount, minAmount));
                continue;
            }
            else if (loanAmount > maxAmount) {
                System.out.println(String.format("For tenure of %d months, calculated loan amount (%f) > maximum allowed (%d)!", tenure, loanAmount, maxAmount));
                continue;
            }

            validTenures.add(tenure);
        }

        if (validTenures.size() == 0) {
            System.out.println("No tenure option (" + Arrays.toString(allTenures) + ") is feasible for the calculated loan amount for user.\nHence, user is rejected!");
        }

        return validTenures;
    }

    /**
     * Upper bound EMI based on leverageAttributeA
     */
    public Map<Integer, Float> capEmi(float emi, ArrayList<Integer> validTenures, User user, MaxEmiBasedOnLeverageAttributeATenure maxEmiBasedOnLeverageAttributeATenure) {
        HashMap<Integer, Float> grantedEmiForTenureMap = new HashMap<>();

        float leverageAttributeA = user.getLeverageAttributeA();
        int j = ArrayUtil.getBucketIndexOfValue(maxEmiBasedOnLeverageAttributeATenure.getLeverageAttributeABucket(), leverageAttributeA);

        int[] allTenures = maxEmiBasedOnLeverageAttributeATenure.getTenure();
        for (int i = 0; i < allTenures.length; i++) {
            int tenure = allTenures[i];
            if (! validTenures.contains(tenure)) {
                continue;
            }

            int maxEmi = maxEmiBasedOnLeverageAttributeATenure.getValues()[i][j];

            if (emi > maxEmi) {
                System.out.printf("Calculated EMI (%f) is greater than maximum allowed (%d), for given tenure (%d) and user's leverageAttributeA (%f).\n", emi, maxEmi, tenure, leverageAttributeA);
                System.out.printf("Hence, EMI granted for tenure (%d) is %f\n", tenure, (float) maxEmi);
                grantedEmiForTenureMap.put(tenure, (float) maxEmi);
            }
            else {
                System.out.printf("EMI granted for tenure (%d) is %f\n", tenure, emi);
                grantedEmiForTenureMap.put(tenure, (float) emi);
            }
        }

        return grantedEmiForTenureMap;
    }
}
