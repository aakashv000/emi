package org.example.structures;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class PaymentAbility1Multiplier {
    @SerializedName("PAYMENT_ABILITY_1_BUCKET")
    private int[] paymentAbility1Bucket;
    @SerializedName("VALUES")
    private float[] values;

    // getters and setters
    public int[] getPaymentAbility1Bucket() {
        return paymentAbility1Bucket;
    }

    public void setPaymentAbility1Bucket(int[] paymentAbility1Bucket) {
        this.paymentAbility1Bucket = paymentAbility1Bucket;
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
        return "PaymentAbility1Multiplier{" +
                "payment_ability_1_bucket=" + Arrays.toString(paymentAbility1Bucket) +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}
