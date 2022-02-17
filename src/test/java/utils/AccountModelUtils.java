package utils;

import model.AccountModel;

public class AccountModelUtils {

    public static AccountModel getDefaultAccountModel() {
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName("USER1");
        accountModel.setPhone("+48534032897");
        accountModel.setFax("+48534033654");
        accountModel.setWebsite("teachmeskills.by");
        accountModel.setType("Integrator");
        accountModel.setEmployees(13);
        accountModel.setIndustry("Energy");
        //accountModel.setAnnualRevenue(13000);
        accountModel.setDescription("Identifying and working with element objects in the DOM");
        //accountModel.setBillingStreet("Magiczna");
        //accountModel.setBillingCity("Warszawa");
        //accountModel.setBillingCode("12-345");
        //accountModel.setBillingCountry("Polska");
        return accountModel;
    }

}
