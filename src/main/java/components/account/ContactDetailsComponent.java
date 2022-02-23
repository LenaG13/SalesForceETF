package components.account;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactDetailsComponent extends AbstractComponent {

    public static final String CONTACT_TEXT_FIELD = "//div/slot/records-record-layout-row/slot//div//span[text()='%s']";
//Phone. Mobile, Email, Description
    public static final By ACCOUNT_NAME_FIELD = By.xpath("//span[text()='Account Name']" +
            "/ancestor::div[@records-recordlayoutitem_recordlayoutitem and contains(@class, 'test-id')]" +
            "//slot[@name='outputField']//span[@force-lookup_lookup]");
    public static final By NAME_FIELD = By.xpath("//span[ text()='Name']" +
            "/ancestor::div[@records-recordlayoutitem_recordlayoutitem and contains(@class, 'test-id')]" +
            "//slot[@name='outputField']/lightning-formatted-name");

    String label;
    By textFieldLocator;

    public ContactDetailsComponent(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.textFieldLocator = By.xpath(String.format(CONTACT_TEXT_FIELD, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(textFieldLocator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public String getValue() {
        return driver.findElement(textFieldLocator).getText();
    }

    public String getAccountNameLocator() {
        return driver.findElement(ACCOUNT_NAME_FIELD).getText();
    }

    public String getNameLocator() {
        return driver.findElement(NAME_FIELD).getText();
    }

    public boolean isComponentDisplayed(By element){
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

}
