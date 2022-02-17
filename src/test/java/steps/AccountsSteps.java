package steps;

import components.account.AccountDetailsComponent;
import components.forms.*;
import model.AccountModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;

public class AccountsSteps extends AbstractStep {

    private AccountPage accountPage;

    public AccountsSteps(WebDriver driver) {
        super(driver);
    }

    public AccountsSteps createNewAccount(AccountModel accountModel) {
        accountPage = new AccountPage(driver);
        accountPage.openNewAccountForm();
        CreateAccountFormComponent form = new CreateAccountFormComponent(driver);
        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not displayed")
        );
        fillAccountForm(accountModel);
        //new Checkbox(driver).clickCheckBox();
        form.save();
        validatePageIsLoaded(accountPage);
        return this;
    }

    private void fillAccountForm(AccountModel accountModel) {
        new Input(driver, "Account Name").insert(accountModel.getAccountName());
        new Input(driver, "Phone").insert(accountModel.getPhone());
        new Input(driver, "Fax").insert(accountModel.getFax());
        new Input(driver, "Website").insert(accountModel.getWebsite());
        new Dropdown(driver, "Type").selectOption(accountModel.getType());
        new Input(driver, "Employees").insert(String.valueOf(accountModel.getEmployees()));
        new Dropdown(driver, "Industry").selectOption(accountModel.getIndustry());
        //new Input(driver, "Annual Revenue").insert(String.valueOf(accountModel.getAnnualRevenue()));
        new TextArea(driver, "Description").write(accountModel.getDescription());
        //new TextArea(driver, "Billing Street").write(accountModel.getBillingStreet());
        //new Input(driver, "Billing City").insert(accountModel.getBillingCity());
        //new Input(driver, "Billing Zip/Postal Code").insert(accountModel.getBillingCode());
        //new Input(driver, "Billing Country").insert(accountModel.getBillingCountry());
    }

    public void validateAccountCreated(AccountModel expectedModel) {
        accountPage.openDetails();
        AccountModel actualModel = getActualAccount();
        Assert.assertEquals(actualModel, expectedModel,
                String.format("Account is not valid: %s", actualModel));
    }

    private AccountModel getActualAccount() {
        AccountModel actualModel = new AccountModel();
        actualModel.setAccountName(new AccountDetailsComponent(driver, "Account Name", "text").getValue());
        actualModel.setPhone(new AccountDetailsComponent(driver, "Phone", "phone").getValue());
        actualModel.setFax(new AccountDetailsComponent(driver, "Fax", "phone").getValue());
        actualModel.setWebsite(new AccountDetailsComponent(driver, "Website", "url").getValue());
        actualModel.setType(new AccountDetailsComponent(driver, "Type", "text").getValue());
        actualModel.setEmployees(Integer.parseInt(new AccountDetailsComponent(driver, "Employees", "number").getValue()));
        actualModel.setIndustry(new AccountDetailsComponent(driver, "Industry", "text").getValue());
        //actualModel.setAnnualRevenue(new AccountDetailsComponent(driver, "Annual Revenue", "text").getValue());
        actualModel.setDescription(new AccountDetailsComponent(driver, "Description", "text").getValue());
        //actualModel.setBillingAddress(new AccountDetailsComponent(driver, "Billing Address", "address").getValue());
        //actualModel.setShippingAddress(new AccountDetailsComponent(driver, "Shipping Address", "address").getValue());
        return actualModel;
    }

    public void validateAccountCreated_DEL() {
        accountPage.openDetails();
        Assert.assertEquals(new AccountDetailsComponent(driver,
                "Account Name", "text").getValue(), "USER2");
        Assert.assertEquals(new AccountDetailsComponent(driver,
                "Phone", "phone").getValue(), "375295340651");
        Assert.assertEquals(new AccountDetailsComponent(driver,
                "Fax", "phone").getValue(), "375292780448");
        Assert.assertEquals(new AccountDetailsComponent(driver,
                "Website", "url").getValue(), "teachmeskills.by");
        Assert.assertEquals(new AccountDetailsComponent(driver,
                "Type", "text").getValue(), "Customer");
        Assert.assertEquals(new AccountDetailsComponent(driver,
                "Employees", "number").getValue(), "10");
        Assert.assertEquals(new AccountDetailsComponent(driver,
                "Industry", "text").getValue(), "Banking");
        Assert.assertEquals(new AccountDetailsComponent(driver,
                "Annual Revenue", "text").getValue(), "$1,200");
        Assert.assertEquals(new AccountDetailsComponent(driver,
                "Description", "text").getValue(), "Мы используем файлы cookie, " +
                "чтобы иметь возможность предлагать Вам полезные функции");
        Assert.assertEquals(new AccountDetailsComponent(driver,
                "Billing Address", "address").getValue(), "Kosmonawtow\nMinsk, 220107\nBelarus");
        Assert.assertEquals(new AccountDetailsComponent(driver,
                "Shipping Address", "address").getValue(), "Kosmonawtow\nMinsk, 220107\nBelarus");
    }

}
