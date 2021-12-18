package page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.object.locators.XpathLocators;

public class MailRuIndexPage extends MailRuBasePage {

    private static final String PAGE_RELATIVE_URL = "/";

    @FindBy(xpath = XpathLocators.PASSWORD_BUTTON)
    private WebElement passwordButton;

    @FindBy(xpath = XpathLocators.SIGN_IN_BUTTON)
    private WebElement signInButton;

    @FindBy(xpath = XpathLocators.LOGIN_FIELD)
    private WebElement loginField;

    @FindBy(xpath = XpathLocators.PASSWORD_FIELD)
    private WebElement passwordField;

    @FindBy(xpath = XpathLocators.REMEMBER_ME_CHECKBOX)
    private WebElement rememberMeCheckbox;

    public MailRuIndexPage(WebDriver driver) {
        super(driver);
    }

    public MailRuIndexPage open() {
        open(PAGE_RELATIVE_URL);
        return new MailRuIndexPage(driver);
    }

    public MailRuIndexPage inputTextIntoLoginTextField(String login) {
        sendKeysToWebElement(loginField, login);
        return new MailRuIndexPage(driver);
    }

    public MailRuIndexPage inputTextIntoPasswordTextField(String password) {
        sendKeysToWebElement(passwordField, password);
        return new MailRuIndexPage(driver);
    }

    public MailRuIndexPage clickToRememberMeCheckbox() {
        clickToWebElement(rememberMeCheckbox);
        return new MailRuIndexPage(driver);
    }

    public MailRuIndexPage clickToSignInButton() {
        clickToWebElement(signInButton);
        return new MailRuIndexPage(driver);
    }

    public MailRuIndexPage clickToPasswordButton() {
        clickToWebElement(passwordButton);
        return new MailRuIndexPage(driver);
    }
}
