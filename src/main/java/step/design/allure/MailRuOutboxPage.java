package step.design.allure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import step.design.allure.locators.XpathLocators;

public class MailRuOutboxPage extends MailRuBasePage {

    @FindBy(xpath = XpathLocators.TEST_FOLDER_BUTTON)
    private WebElement testFolder;

    @FindBy(xpath = XpathLocators.PROFILE_BUTTON)
    private WebElement profile;

    @FindBy(xpath = XpathLocators.LOG_OUT_BUTTON)
    private WebElement logOut;

    @FindBy(xpath = XpathLocators.SUBJECT)
    private WebElement subject;

    @FindBy(xpath = XpathLocators.NON_EMPTY_LETTER_LIST)
    private WebElement letterList;

    public MailRuOutboxPage(WebDriver driver) {
        super(driver);
    }

    public MailRuTestPage clickToTestFolder() {
        clickToWebElement(testFolder);
        return new MailRuTestPage(driver);
    }

    public String checkSubjectFiled() {
        return getTextFromWebElement(subject);
    }

    public boolean isLetterListNonEmpty() {
        return findWebElement(letterList);
    }

    public void logOut() {
        clickToWebElement(profile);
        clickToWebElement(logOut);
    }
}
