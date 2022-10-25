package org.example.structures;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;

public class LendingRate {
    @SerializedName("USER_ATTRIBUTE_2")
    private ArrayList<String> userAttribute2;
    @SerializedName("USER_RISK_ATTRIBUTE_2")
    private int[] userRiskAttribute2;
    @SerializedName("VALUES")
    private int[][] values;

    // getters and setters
    public ArrayList<String> getUserAttribute2() {
        return userAttribute2;
    }

    public void setUserAttribute2(ArrayList<String> userAttribute2) {
        this.userAttribute2 = userAttribute2;
    }

    public int[] getUserRiskAttribute2() {
        return userRiskAttribute2;
    }

    public void setUserRiskAttribute2(int[] userRiskAttribute2) {
        this.userRiskAttribute2 = userRiskAttribute2;
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
        return "LendingRate{" +
                "user_attribute_2=" + userAttribute2 +
                ", user_risk_attribute_2=" + Arrays.toString(userRiskAttribute2) +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}
