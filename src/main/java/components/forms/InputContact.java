package components.forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InputContact extends AbstractComponent {

    private static final String CONTACT_INPUT_LOCATOR_PATTERN = "//label[contains(text(),'%s')]/ancestor::lightning-input//input";
    private String label;
    private By inputLocator;

    public InputContact(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.inputLocator = By.xpath(String.format(CONTACT_INPUT_LOCATOR_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(inputLocator));
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }

    public void insertContact(String text) {
        driver.findElement(inputLocator).sendKeys(text);
    }
}
