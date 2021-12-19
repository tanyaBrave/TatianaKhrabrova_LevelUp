package step.design.allure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import step.design.allure.locators.XpathLocators;

public class MailRuTestPage extends MailRuBasePage {

    @FindBy(xpath = XpathLocators.PROFILE_BUTTON)
    private WebElement profile;

    @FindBy(xpath = XpathLocators.LOG_OUT_BUTTON)
    private WebElement logOut;

    @FindBy(xpath = XpathLocators.RECEIVER)
    private WebElement receiver;

    @FindBy(xpath = XpathLocators.SUBJECT)
    private WebElement subject;

    @FindBy(xpath = XpathLocators.CONTENT)
    private WebElement content;

    @FindBy(xpath = XpathLocators.NON_EMPTY_LETTER_LIST)
    private WebElement letterList;

    public MailRuTestPage(WebDriver driver) {
        super(driver);
    }

    public String checkReceiverField() {
        return getTextFromWebElement(receiver);
    }

    public String checkSubjectField() {
        return getTextFromWebElement(subject);
    }

    public String checkContentField() {
        return getTextFromWebElement(content);
    }

    public boolean isLetterListNonEmpty() {
        return findWebElement(letterList);
    }

    public void logOut() {
        clickToWebElement(profile);
        clickToWebElement(logOut);
    }


}
