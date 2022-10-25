package org.example.structures;

public class User {
    private float paymentAbility1;
    private float paymentAbility2;
    private int userRiskAttribute1;
    private int userRiskAttribute2;
    private float obligationAttribute1;
    private float leverageAttributeA;
    private float userAttribute1;
    private String userAttribute2;
    private float userAttribute3;
    private boolean negativeTrigger1;

    // getters and setters

    public float getPaymentAbility1() {
        return paymentAbility1;
    }

    public void setPaymentAbility1(float paymentAbility1) {
        this.paymentAbility1 = paymentAbility1;
    }

    public float getPaymentAbility2() {
        return paymentAbility2;
    }

    public void setPaymentAbility2(float paymentAbility2) {
        this.paymentAbility2 = paymentAbility2;
    }

    public int getUserRiskAttribute1() {
        return userRiskAttribute1;
    }

    public void setUserRiskAttribute1(int userRiskAttribute1) {
        this.userRiskAttribute1 = userRiskAttribute1;
    }

    public int getUserRiskAttribute2() {
        return userRiskAttribute2;
    }

    public void setUserRiskAttribute2(int userRiskAttribute2) {
        this.userRiskAttribute2 = userRiskAttribute2;
    }

    public float getObligationAttribute1() {
        return obligationAttribute1;
    }

    public void setObligationAttribute1(float obligationAttribute1) {
        this.obligationAttribute1 = obligationAttribute1;
    }

    public float getLeverageAttributeA() {
        return leverageAttributeA;
    }

    public void setLeverageAttributeA(float leverageAttributeA) {
        this.leverageAttributeA = leverageAttributeA;
    }

    public float getUserAttribute1() {
        return userAttribute1;
    }

    public void setUserAttribute1(float userAttribute1) {
        this.userAttribute1 = userAttribute1;
    }

    public String getUserAttribute2() {
        return userAttribute2;
    }

    public void setUserAttribute2(String userAttribute2) {
        this.userAttribute2 = userAttribute2;
    }

    public float getUserAttribute3() {
        return userAttribute3;
    }

    public void setUserAttribute3(float userAttribute3) {
        this.userAttribute3 = userAttribute3;
    }

    public boolean isNegativeTrigger1() {
        return negativeTrigger1;
    }

    public void setNegativeTrigger1(boolean negativeTrigger1) {
        this.negativeTrigger1 = negativeTrigger1;
    }

    // toString
    @Override
    public String toString() {
        return "User{" +
                "paymentAbility1=" + paymentAbility1 +
                ", paymentAbility2=" + paymentAbility2 +
                ", userRiskAttribute1=" + userRiskAttribute1 +
                ", userRiskAttribute2=" + userRiskAttribute2 +
                ", obligationAttribute1=" + obligationAttribute1 +
                ", leverageAttributeA=" + leverageAttributeA +
                ", userAttribute1=" + userAttribute1 +
                ", userAttribute2='" + userAttribute2 + '\'' +
                ", userAttribute3=" + userAttribute3 +
                ", negativeTrigger1=" + negativeTrigger1 +
                '}';
    }
}
