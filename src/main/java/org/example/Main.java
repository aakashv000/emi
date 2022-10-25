package org.example;

import org.example.constants.Constants;
import org.example.structures.Config;
import org.example.structures.User;
import org.example.utils.Json;
import org.example.utils.ReadWrite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // TODO: make another class to be hub of all the below execution, instead of main
        System.out.println(">> Getting EMI options for user ...");

        // config.json
        // read json file to string
        String configStr = ReadWrite.readFile(Constants.Path.configFile);
//        System.out.println(configStr);

        // convert json string to pojo
        Config config = Json.parseJsonToClass(configStr, Config.class);
        System.out.println(config);
//        System.out.println(Arrays.deepToString(config.getPolicyParams().getMaxEmiBasedOnLeverageAttributeATenure().getValues()));

        // user1.json
        String user1Str = ReadWrite.readFile(Constants.Path.user1File);
        User user1 = Json.parseJsonToClass(user1Str, User.class);
        System.out.println(user1);

        // check if user passes decisioning filter
        boolean isUserEligible = new DecisionFilter().checkUserEligibility(user1, config.getDecisioning());
        System.out.println(isUserEligible);

        if (! isUserEligible) return;

        // calculate emi, roi
        float emi = new Calculate().calculateEmi(user1, config.getOffers());
        System.out.println(emi);

        int roi = new Calculate().calculateRoi(user1, config.getOffers().getLendingRate());
        System.out.println(roi);

        ArrayList<Integer> validTenures = new PolicyFilter().validateLoanAmountRange(emi, roi, config.getPolicyParams());
        System.out.println(validTenures);

        if (validTenures.size() == 0) return;

        Map<Integer, Float> tenureEmiMap = new PolicyFilter().capEmi(emi, validTenures, user1, config.getPolicyParams().getMaxEmiBasedOnLeverageAttributeATenure());
        System.out.println("Finalized EMI options for user:\n" + tenureEmiMap);
    }
}