package org.example.structures;

import com.google.gson.annotations.SerializedName;

public class Offers {
    // TODO: confirm that max of emi from PA1 and PA2 is taken
    @SerializedName("PAYMENT_ABILITY_2_MULTIPLIER")
    private PaymentAbility2Multiplier paymentAbility2Multiplier;
    @SerializedName("PAYMENT_ABILITY_1_MULTIPLIER")
    private PaymentAbility1Multiplier paymentAbility1Multiplier;
    @SerializedName("LENDING_RATE")
    private LendingRate lendingRate;

    // getters and setters
    public PaymentAbility2Multiplier getPaymentAbility2Multiplier() {
        return paymentAbility2Multiplier;
    }

    public void setPaymentAbility2Multiplier(PaymentAbility2Multiplier paymentAbility2Multiplier) {
        this.paymentAbility2Multiplier = paymentAbility2Multiplier;
    }

    public PaymentAbility1Multiplier getPaymentAbility1Multiplier() {
        return paymentAbility1Multiplier;
    }

    public void setPaymentAbility1Multiplier(PaymentAbility1Multiplier paymentAbility1Multiplier) {
        this.paymentAbility1Multiplier = paymentAbility1Multiplier;
    }

    public LendingRate getLendingRate() {
        return lendingRate;
    }

    public void setLendingRate(LendingRate lendingRate) {
        this.lendingRate = lendingRate;
    }

    // toString
    @Override
    public String toString() {
        return "Offers{" +
                "payment_ability_2_multiplier=" + paymentAbility2Multiplier +
                ", payment_ability_1_multiplier=" + paymentAbility1Multiplier +
                ", lending_rate=" + lendingRate +
                '}';
    }
}
