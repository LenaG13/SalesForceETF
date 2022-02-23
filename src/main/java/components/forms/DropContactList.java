package components.forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DropContactList extends AbstractComponent {

    private static final String DROP_LIST_LOCATOR_PATTERN =
            "//label[contains(text(),'%s')]/ancestor::slot[@name='inputField']//input";
    private static final String OPTION_LIST_PATTERN =
            "//span[contains(@title,'%s')]/ancestor::li[contains(@class,'slds-listbox')]//span[contains(@class,'body')]";

    private String label;
    private By dropListLocator;

    public DropContactList(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.dropListLocator = By.xpath(String.format(DROP_LIST_LOCATOR_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(dropListLocator));
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }

    private void openOptionsPopup() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(dropListLocator));
    }

    public void selectOption(String optionName) {
        openOptionsPopup();
        By optionLocator = By.xpath(String.format(OPTION_LIST_PATTERN, optionName));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        driver.findElement(optionLocator).click();
    }

}
