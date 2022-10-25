package org.example.structures;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class PaymentAbility2Multiplier {
    @SerializedName("USER_RISK_ATTRIBUTE_1")
    private int[] userRiskAttribute1;
    @SerializedName("VALUES")
    private float[] values;

    // getters and setters
    public int[] getUserRiskAttribute1() {
        return userRiskAttribute1;
    }

    public void setUserRiskAttribute1(int[] userRiskAttribute1) {
        this.userRiskAttribute1 = userRiskAttribute1;
    }

    public float[] getValues() {
        return values;
    }

    public void setValues(float[] values) {
        this.values = values;
    }

    // toString
    @Override
    public String toString() {
        return "PaymentAbility2Multiplier{" +
                "user_risk_attribute_1=" + Arrays.toString(userRiskAttribute1) +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}
