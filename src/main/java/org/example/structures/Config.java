package org.example.structures;

import com.google.gson.annotations.SerializedName;

public class Config {
    // todo: make this singleton?
    @SerializedName("DECISIONING")
    private Decisioning decisioning;

    @SerializedName("OFFERS")
    private Offers offers;

    @SerializedName("POLICY_PARAMS")
    private PolicyParams policyParams;

    // getters and setters
    public Decisioning getDecisioning() {
        return decisioning;
    }

    public void setDecisioning(Decisioning decisioning) {
        this.decisioning = decisioning;
    }

    public Offers getOffers() {
        return offers;
    }

    public void setOffers(Offers offers) {
        this.offers = offers;
    }

    public PolicyParams getPolicyParams() {
        return policyParams;
    }

    public void setPolicyParams(PolicyParams policyParams) {
        this.policyParams = policyParams;
    }

    // toString
    @Override
    public String toString() {
        return "Config{" +
                "decisioning=" + decisioning +
                ", offers=" + offers +
                ", policyParams=" + policyParams +
                '}';
    }
}
