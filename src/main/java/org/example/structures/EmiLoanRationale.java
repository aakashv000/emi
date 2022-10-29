package org.example.structures;

public class EmiLoanRationale {
    private Boolean isOffered = true;
    private Float emi;
    private Integer loan;
    private String emiRationale;
    private String loanRationale;

    // getters and setters
    public Boolean getOffered() {
        return isOffered;
    }

    public void setOffered(Boolean offered) {
        isOffered = offered;
    }

    public Float getEmi() {
        return emi;
    }

    public void setEmi(Float emi) {
        this.emi = emi;
    }

    public Integer getLoan() {
        return loan;
    }

    public void setLoan(Integer loan) {
        this.loan = loan;
    }

    public String getEmiRationale() {
        return emiRationale;
    }

    public void setEmiRationale(String emiRationale) {
        this.emiRationale = emiRationale;
    }

    public String getLoanRationale() {
        return loanRationale;
    }

    public void setLoanRationale(String loanRationale) {
        this.loanRationale = loanRationale;
    }

    // toString
    @Override
    public String toString() {
        return "EmiLoanRationale{" +
                "\n\t\tisOffered=" + isOffered +
                ", \n\t\temi=" + emi +
                ", \n\t\tloan=" + loan +
                ", \n\t\temiRationale='" + emiRationale + '\'' +
                ", \n\t\tloanRationale='" + loanRationale + '\'' +
                "\n}";
    }
}