package step.design.allure;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailRuBasePage {

    public static final String BASE_URL = "https://mail.ru";

    WebDriver driver;
    WebDriverWait wait;

    MailRuBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        PageFactory.initElements(this.driver, this);
    }

    protected void open(String relativeUrl) {
        driver.navigate().to(BASE_URL + relativeUrl);
    }

    void clickToWebElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    void sendKeysToWebElement(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    String getTextFromWebElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    boolean findWebElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    void checkTitle(String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }
}
