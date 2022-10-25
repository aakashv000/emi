package org.example.structures;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Map;

public class PolicyParams {
    @SerializedName("ALL_TENURES")
    private int[] allTenures;
    @SerializedName("MAX_AMOUNT_TENURE")
    private Map<String, Integer> maxAmountTenure;
    @SerializedName("MIN_AMOUNT_TENURE")
    private Map<String, Integer> minAmountTenure;
    @SerializedName("MAX_EMI_BASED_ON_LEVERAGE_ATTRIBUTE_A_TENURE")
    private MaxEmiBasedOnLeverageAttributeATenure maxEmiBasedOnLeverageAttributeATenure;

    // getters and setters
    public int[] getAllTenures() {
        return allTenures;
    }

    public void setAllTenures(int[] allTenures) {
        this.allTenures = allTenures;
    }

    public Map<String, Integer> getMaxAmountTenure() {
        return maxAmountTenure;
    }

    public void setMaxAmountTenure(Map<String, Integer> maxAmountTenure) {
        this.maxAmountTenure = maxAmountTenure;
    }

    public Map<String, Integer> getMinAmountTenure() {
        return minAmountTenure;
    }

    public void setMinAmountTenure(Map<String, Integer> minAmountTenure) {
        this.minAmountTenure = minAmountTenure;
    }

    public MaxEmiBasedOnLeverageAttributeATenure getMaxEmiBasedOnLeverageAttributeATenure() {
        return maxEmiBasedOnLeverageAttributeATenure;
    }

    public void setMaxEmiBasedOnLeverageAttributeATenure(MaxEmiBasedOnLeverageAttributeATenure maxEmiBasedOnLeverageAttributeATenure) {
        this.maxEmiBasedOnLeverageAttributeATenure = maxEmiBasedOnLeverageAttributeATenure;
    }

    // toString
    @Override
    public String toString() {
        return "PolicyParams{" +
                "all_tenures=" + Arrays.toString(allTenures) +
                ", max_amount_tenure=" + maxAmountTenure +
                ", min_amount_tenure=" + minAmountTenure +
                ", max_emi_based_on_leverage_attribute_a_tenure=" + maxEmiBasedOnLeverageAttributeATenure +
                '}';
    }
}
