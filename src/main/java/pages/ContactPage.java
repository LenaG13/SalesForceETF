package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BasePage {

    private static final String BASE_URN = "https://sentrium.lightning.force.com/lightning/o/Contact/list?filterName=Recent";

    private static final By HEADER = By.xpath("//h1[contains(.,'Contacts')]");
    private static final By NEW_BUTTON = By.cssSelector("[title='New']");
    private static final By DETAILS_BUTTON = By.xpath("//a[@data-label='Details']");
    private static final By DETAILS_TAB_PANEL = By.xpath("//div/slot/records-record-layout-row//records-record-layout-item");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URN);
        return this;
    }

    public void openNewContactForm() {
        driver.findElement(NEW_BUTTON).click();
    }

    public void openDetails() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DETAILS_BUTTON));
        driver.findElement(DETAILS_BUTTON).click();
        explicitlyWait.until(ExpectedConditions.attributeContains(DETAILS_BUTTON, "aria-selected", "true"));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DETAILS_TAB_PANEL));
    }

}
