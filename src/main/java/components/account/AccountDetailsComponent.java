package components.account;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountDetailsComponent extends AbstractComponent {

    public static final String ACCOUNTS_TEXT_DATA_FIELD = "//div[contains(@class,'slds-tabs_card')]" +
            "//span[text()='%s']/ancestor::div[contains(@class,'test-id__output-root')]//lightning-formatted-%s";

        /*"//div[@class='slds-tabs_card']//span[text()='%s']/ancestor::" +
        "div[@records-recordlayoutitem_recordlayoutitem and contains(@class,'label-inline')]" +
        "//slot[@name='outputField']//lightning-formatted-%s";*/

    //div[@class='slds-tabs_card']//span[text()='Type']/ancestor::div[@records-recordlayoutitem_recordlayoutitem and contains(@class,'label-inline')]//slot[@name='outputField']//lightning-formatted-text
    //div[@class='slds-tabs_card']//span[text()='Fax']/ancestor::div[@records-recordlayoutitem_recordlayoutitem and contains(@class,'label-inline')]//slot[@name='outputField']//lightning-formatted-phone
    //div[@class='slds-tabs_card']//span[text()='Shipping Address']/ancestor::div[@records-recordlayoutitem_recordlayoutitem and contains(@class,'label-inline')]//slot[@name='outputField']//lightning-formatted-address
    //div[@class='slds-tabs_card']//span[text()='Employees']/ancestor::div[@records-recordlayoutitem_recordlayoutitem and contains(@class,'label-inline')]//slot[@name='outputField']//lightning-formatted-number
    //div[@class='slds-tabs_card']//span[text()='Website']/ancestor::div[@records-recordlayoutitem_recordlayoutitem and contains(@class,'label-inline')]//slot[@name='outputField']//lightning-formatted-url

    String value;
    String label;
    By textFieldLocator;

    public AccountDetailsComponent(WebDriver driver, String label, String value) {
        super(driver);
        this.label = label;
        this.value = value;
        this.textFieldLocator = By.xpath(String.format(ACCOUNTS_TEXT_DATA_FIELD, label, value));
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

}
