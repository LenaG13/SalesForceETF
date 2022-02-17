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

    public AccountsSteps createNewAccount() {
        accountPage = new AccountPage(driver);
        accountPage.openNewAccountForm();
        CreateAccountFormComponent form = new CreateAccountFormComponent(driver);
        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not displayed")
        );
        Input accountNameInput = new Input(driver, "Account Name");
        accountNameInput.insert("USER2");

        Input phoneInput = new Input(driver, "Phone");
        phoneInput.insert("375295340651");

        new Input(driver, "Fax").insert("375292780448");
        new Input(driver, "Website").insert("teachmeskills.by");
        new Dropdown(driver, "Type").selectOption("Customer");
        new Input(driver, "Employees").insert("10");
        new Dropdown(driver, "Industry").selectOption("Banking");
        new Input(driver, "Annual Revenue").insert("1200");
        new TextArea(driver, "Description").write("Мы используем файлы cookie, " +
                "чтобы иметь возможность предлагать Вам полезные функции");
        new TextArea(driver, "Billing Street").write("Kosmonawtow");
        new Input(driver, "Billing City").insert("Minsk");
        new Input(driver, "Billing Zip/Postal Code").insert("220107");
        new Input(driver, "Billing Country").insert("Belarus");
        new Checkbox(driver).clickCheckBox();
        form.save();
        validatePageIsLoaded(accountPage);
        return this;
    }

    public void validateAccountCreated() {
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

    /*public void validateAccountCreated_DEL() {
        accountPage.openDetails();
        Assert.assertEquals(
                new AccountDetailsComponent(driver, "Account Name", "text").getValue(),
                "USERNAME"
        );
        Assert.assertEquals(
                new AccountDetailsComponent(driver, "Phone", "phone").getValue(),
                "+37529123123"
        );
        Assert.assertEquals(
                new AccountDetailsComponent(driver, "Website", "url").getValue(),
                "teachmeskills.by"
        );
        Assert.assertEquals(
                new AccountDetailsComponent(driver, "Employees", "number").getValue(),
                "10"
        );
        Assert.assertEquals(
                new AccountDetailsComponent(driver, "Type").getValue(),
                "Customer"
        );
        Assert.assertEquals(
                new AccountDetailsComponent(driver, "Industry").getValue(),
                "Banking"
        );
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
        form.save();
        validatePageIsLoaded(accountPage);
        return this;
    }*/

    private void fillAccountForm(AccountModel accountModel) {
        Input accountNameInput = new Input(driver, "Account Name");
        accountNameInput.insert(accountModel.getAccountName());
        Input phoneInput = new Input(driver, "Phone");
        phoneInput.insert(accountModel.getPhone());
        new Input(driver, "Website").insert(accountModel.getWebsite());
        new Input(driver, "Employees").insert(String.valueOf(accountModel.getEmployees()));
        new Dropdown(driver, "Type").selectOption(accountModel.getType());
        new Dropdown(driver, "Industry").selectOption(accountModel.getIndustry());
    }

    public void validateAccountCreated(AccountModel expectedModel) {
        accountPage.openDetails();
        AccountModel actualModel = getActualAccount();
        Assert.assertEquals(
                actualModel,
                expectedModel,
                String.format("Account is not valid: %s", actualModel)
        );
    }

    private AccountModel getActualAccount( ) {
        AccountModel actualModel = new AccountModel();
        actualModel.setAccountName(new AccountDetailsComponent(driver, "Account Name", "text").getValue());
        actualModel.setPhone(new AccountDetailsComponent(driver, "Phone", "phone").getValue());
        actualModel.setWebsite(new AccountDetailsComponent(driver, "Website", "url").getValue());
        actualModel.setEmployees(Integer.parseInt(new AccountDetailsComponent(driver, "Employees", "number").getValue()));
        actualModel.setType(new AccountDetailsComponent(driver, "Type", "text").getValue());
        actualModel.setIndustry(new AccountDetailsComponent(driver, "Industry", "text").getValue());
        return actualModel;
    }

}
