package org.example;

import org.example.structures.LendingRate;
import org.example.structures.Offers;
import org.example.structures.Result;
import org.example.structures.User;
import org.example.utils.ArrayUtil;
import java.util.Map;

public class Calculate {
    public Result calculateEmi (User user, Offers offers, Result result) {
        // for paymentAbility1
        float paymentAbility1 = user.getPaymentAbility1();

        int mulIdx1 = ArrayUtil.getBucketIndexOfValue(
                offers.getPaymentAbility1Multiplier().getPaymentAbility1Bucket(),
                user.getPaymentAbility1()
        );
        float multiplier1 = offers.getPaymentAbility1Multiplier().getValues()[mulIdx1];

        float emi1 = paymentAbility1 * multiplier1;

        // for paymentAbility2
        float derivedPaymentAbility2 = user.getPaymentAbility2() - user.getObligationAttribute1();

        int mulIdx2 = ArrayUtil.getBucketIndexOfValue(
                offers.getPaymentAbility2Multiplier().getUserRiskAttribute1(),
                user.getPaymentAbility2()
        );
        float multiplier2 = offers.getPaymentAbility2Multiplier().getValues()[mulIdx2];

        float emi2 = derivedPaymentAbility2 * multiplier2;

        // finalize emi
        if (emi1 >= emi2) {
            result.setEmiSelectedPAMap(Map.of(emi1, String.format("paymentAbility1 (since, EMI from PA1 (%f) >= EMI from PA2 (%f))", emi1, emi2)));

//            System.out.println(String.format("EMI = %f, is decided from paymentAbility1, since EMI from PA1 (%f) >= EMI from PA2 (%f)",emi1, emi1, emi2));
        }
        else {
            result.setEmiSelectedPAMap(Map.of(emi2, String.format("paymentAbility2 (since, EMI from PA1 (%f) < EMI from PA2 (%f))", emi1, emi2)));

//            System.out.println(String.format("EMI = %f, is decided from paymentAbility2, since EMI from PA1 (%f) < EMI from PA2 (%f)",emi2, emi1, emi2));
        }

        return result;
    }

    public Result calculateRoi (User user, LendingRate lendingRate, Result result) {
        String userAttribute2 = user.getUserAttribute2();
        int userRiskAttribute2 = user.getUserRiskAttribute2();

        int i = lendingRate.getUserAttribute2().indexOf(userAttribute2);
        int j = ArrayUtil.getBucketIndexOfValue(lendingRate.getUserRiskAttribute2(), userRiskAttribute2);

        int roi = lendingRate.getValues()[i][j];

        result.setRoi((float) roi);
        return result;
    }

    /**
     * @param emi EMI amount
     * @param roi Rate of Interest, in per annum
     * @param tenure Tenure for payment of EMI, in months
     */
    public double calLoanAmount (double emi, double roi, int tenure) {
        // formula:
        // E = P x r x ( 1 + r )^n / ( ( 1 + r )^n - 1 )
        // P = (E * ((1+r)^n - 1)) / (r * (1+r)^n)

        // interest percent per month
        double rpm = roi / (12*100);

        double principalAmount = (emi * (Math.pow(1+rpm, tenure) - 1)) / (rpm * Math.pow(1+rpm, tenure));

        return principalAmount;
    }
}
