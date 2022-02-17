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
                                    .setPhone("123")
                                    .build();

    @Test
    public void addNewAccountTest() {
        mainSteps
                .openSaleforceLoginPage()
                .loginWithValidCreds()
                .openAccountPage()
                .createNewAccount(testAccount)
                .validateAccountCreated(testAccount);
    }

    private AccountModel buildTestAccount() {
        return AccountBuilder.newValues()
                .setAccountName("USER1")
                .setPhone("+48534032897")
                .setFax("+48534033654")
                .setWebsite("teachmeskills.by")
                .setType("Integrator")
                .setEmployees(13)
                .setIndustry("Energy")
                .setAnnualRevenue(13000)
                .setDescription("Identifying and working with element objects in the DOM")
                //.setBillingStreet("Magiczna")
                //.setBillingCity("Warszawa")
                //.setBillingCode("12-345")
                //.setBillingCountry("Polska")
                .build();
    }

    private AccountModel getTestAccount() {
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
        //accountModel.setBillingStreet("Magiczna");
        //accountModel.setBillingCity("Warszawa");
        //accountModel.setBillingCode("12-345");
        //accountModel.setBillingCountry("Polska");
        return accountModel;
    }

}
