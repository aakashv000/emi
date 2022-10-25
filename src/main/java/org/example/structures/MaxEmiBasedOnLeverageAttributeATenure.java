package org.example.structures;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class MaxEmiBasedOnLeverageAttributeATenure {
    @SerializedName("TENURE")
    private int[] tenure;
    @SerializedName("LEVERAGE_ATTRIBUTE_A_BUCKET")
    private int[] leverageAttributeABucket;
    @SerializedName("VALUES")
    private int[][] values;

    // getters and setters
    public int[] getTenure() {
        return tenure;
    }

    public void setTenure(int[] tenure) {
        this.tenure = tenure;
    }

    public int[] getLeverageAttributeABucket() {
        return leverageAttributeABucket;
    }

    public void setLeverageAttributeABucket(int[] leverageAttributeABucket) {
        this.leverageAttributeABucket = leverageAttributeABucket;
    }

    public int[][] getValues() {
        return values;
    }

    public void setValues(int[][] values) {
        this.values = values;
    }

    // toString
    @Override
    public String toString() {
        return "MaxEmiBasedOnLeverageAttributeATenure{" +
                "tenure=" + Arrays.toString(tenure) +
                ", leverage_attribute_a_bucket=" + Arrays.toString(leverageAttributeABucket) +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}
