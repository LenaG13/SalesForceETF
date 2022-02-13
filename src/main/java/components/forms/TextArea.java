package components.forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea extends AbstractComponent {

    private static final String TEXTAREA_LOCATOR_PATTERN =
            "//div[contains(@class,'isModal')]//span[contains(text(),'%s')]/../..//textarea";
    private String label;
    private By textAreaLocator;

    public TextArea(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.textAreaLocator = By.xpath(String.format(TEXTAREA_LOCATOR_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(textAreaLocator).isDisplayed();
    }

    public void write(String text) {
        driver.findElement(textAreaLocator).sendKeys(text);
    }

}
