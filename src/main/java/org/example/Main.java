package org.example;

import org.example.constants.Constants;
import org.example.structures.Config;
import org.example.structures.Result;
import org.example.structures.User;
import org.example.utils.Json;
import org.example.utils.ReadWrite;

public class Main {
    public static void main(String[] args) {
        // TODO: make another class to be hub of all the below execution, instead of main
        System.out.println(">> Getting EMI options for user ...");

        // config.json
        String configStr = ReadWrite.readFile(Constants.Path.configFile);

        Config config = Json.parseJsonToClass(configStr, Config.class);
//        System.out.println(Arrays.deepToString(config.getPolicyParams().getMaxEmiBasedOnLeverageAttributeATenure().getValues()));

        // user1.json
        String user1Str = ReadWrite.readFile(Constants.Path.user1File);
        User user1 = Json.parseJsonToClass(user1Str, User.class);

        // form result, for given user
        Result result = new Result();

        // check if user passes decisioning filter
        result = new DecisionFilter().checkUserEligibility(user1, config.getDecisioning(), result);

        if (! result.getAccepted()) {
            System.out.println(result);
            return;
        }

        // calculate emi, roi
        result = new Calculate().calculateEmi(user1, config.getOffers(), result);

        result = new Calculate().calculateRoi(user1, config.getOffers().getLendingRate(), result);

        // cap emi, loan amount for each tenure
        result = new PolicyFilter().capEmi(user1, config.getPolicyParams().getMaxEmiBasedOnLeverageAttributeATenure(), result);

        result = new PolicyFilter().validateLoanAmountRange(config.getPolicyParams(), result);

        // check if any tenure option if offered to user
        result = new DecisionFilter().checkIfAnyTenureOffered(result);

        System.out.println(result);
    }
}