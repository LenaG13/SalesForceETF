package saleforce;

import builders.AccountBuilder;
import components.forms.Checkbox;
import model.AccountModel;
import org.testng.annotations.Test;
import utils.AccountModelUtils;

public class AddAccountTest extends BaseTest {

    AccountModel testAccount = AccountModelUtils.getDefaultAccountModel();
    AccountModel testAccount2 = AccountBuilder
            .defaultAccount()
            .setPhone("232")
            .build();

    @Test
    public void addNewAccountTest() {
        mainSteps
                .openSaleforceLoginPage()
                .loginWithValidCreds()
                .openAccountPage()
                .createNewAccount()
                .validateAccountCreated();
        //.validateAccountCreated(testAccount);
    }

    private AccountModel buildTestAccount() {
        return AccountBuilder.newValues()
                .setAccountName("USERNAME")
                .setPhone("+37529123123")
                .setWebsite("teachmeskills.by")
                .setEmployees(10)
                .setType("Customer")
                .setIndustry("Banking")
                .build();
    }

    /*private AccountModel getTestAccount() {
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName("USER1");
        accountModel.setPhone("+48534032897");
        accountModel.setFax("+48534033654");
        accountModel.setWebsite("teachmeskills.by");
        accountModel.setType("Integrator");
        accountModel.setEmployees(13);
        accountModel.setIndustry("Energy");
        accountModel.setAnnualRevenue(13000);
        accountModel.setDescription("Identifying and working with element objects in the DOM");
        accountModel.setBillingStreet("Magiczna");
        accountModel.setBillingCity("Warszawa");
        accountModel.setBillingCode("12-345");
        accountModel.setBillingCountry("Polska");
        return accountModel;
    }*/

}
