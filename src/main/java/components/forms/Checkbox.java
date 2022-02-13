package components.forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox extends AbstractComponent {

    private static final String CHECKBOX_LOCATOR_PATTERN =
            "div[contains(@class,'isModal')]//*[@type=\"checkbox\"]";
    private By checkBox;

    public Checkbox(WebDriver driver) {
        super(driver);
        this.checkBox = By.xpath(String.format(CHECKBOX_LOCATOR_PATTERN));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(checkBox).isDisplayed();
    }

    public void clickCheckBox() {
        driver.findElement(checkBox).click();
    }

}
