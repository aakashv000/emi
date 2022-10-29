package org.example.structures;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private Boolean isAccepted;
    private String reasonForRejection;
    private Map<Integer, EmiLoanRationale> tenureEmiLoanRationaleMap = new HashMap<>();
    private Float roi;
    private Map<Float, String> emiSelectedPAMap;

    // getters and setters
    public Boolean getAccepted() {
        return isAccepted;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }

    public String getReasonForRejection() {
        return reasonForRejection;
    }

    public void setReasonForRejection(String reasonForRejection) {
        this.reasonForRejection = reasonForRejection;
    }

    public Map<Integer, EmiLoanRationale> getTenureEmiLoanRationaleMap() {
        return tenureEmiLoanRationaleMap;
    }

    public void putTenureEmiLoanRationaleMap(Integer tenure, EmiLoanRationale emiLoanRationale) {
        this.tenureEmiLoanRationaleMap.put(tenure, emiLoanRationale);
    }

    public Float getRoi() {
        return roi;
    }

    public void setRoi(Float roi) {
        this.roi = roi;
    }

    public Map<Float, String> getEmiSelectedPAMap() {
        return emiSelectedPAMap;
    }

    public void setEmiSelectedPAMap(Map<Float, String> emiSelectedPAMap) {
        this.emiSelectedPAMap = emiSelectedPAMap;
    }

    // toString
    @Override
    public String toString() {
        return "Result{" +
                "\n\tisAccepted=" + isAccepted +
                ", \n\treasonForRejection='" + reasonForRejection + '\'' +
                ", \n\ttenureEmiLoanRationaleMap=\n" + tenureEmiLoanRationaleMap +
                ", \n\troi=" + roi +
                ", \n\temiSelectedPAMap=" + emiSelectedPAMap +
                "\n}";
    }
}
