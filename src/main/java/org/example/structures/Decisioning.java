package org.example.structures;

import com.google.gson.annotations.SerializedName;

public class Decisioning {
    @SerializedName("REJECT_NEGATIVE_TRIGGER_1")
    private boolean rejectNegativeTrigger1;

    @SerializedName("MINIMUM_LEVERAGE_ATTRIBUTE_A")
    private int minimumLeverageAttributeA;

    // getters and setters
    public boolean isRejectNegativeTrigger1() {
        return rejectNegativeTrigger1;
    }

    public void setRejectNegativeTrigger1(boolean rejectNegativeTrigger1) {
        this.rejectNegativeTrigger1 = rejectNegativeTrigger1;
    }

    public int getMinimumLeverageAttributeA() {
        return minimumLeverageAttributeA;
    }

    public void setMinimumLeverageAttributeA(int minimumLeverageAttributeA) {
        this.minimumLeverageAttributeA = minimumLeverageAttributeA;
    }

    // toString
    @Override
    public String toString() {
        return "Decisioning{" +
                "reject_negative_trigger_1=" + rejectNegativeTrigger1 +
                ", minimum_leverage_attribute_a=" + minimumLeverageAttributeA +
                '}';
    }
}
