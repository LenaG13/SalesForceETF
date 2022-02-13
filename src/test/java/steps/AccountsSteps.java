package steps;

import components.forms.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;

public class AccountsSteps extends AbstractStep {

    private AccountPage accountPage;

    public AccountsSteps(WebDriver driver) {
        super(driver);
    }

    public void createNewAccount() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.openNewAccountForm();
        CreateAccountFormComponent form = new CreateAccountFormComponent(driver);
        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not displayed")
        );
        Input accountNameInput = new Input(driver, "Account Name");
        accountNameInput.insert("USER2");
        Input phoneInput = new Input(driver, "Phone");
        phoneInput.insert("+375295340651");
        new Input(driver, "Fax").insert("+375292780448");
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
    }

}
