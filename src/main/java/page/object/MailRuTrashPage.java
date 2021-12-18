package page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.object.locators.XpathLocators;

public class MailRuTrashPage extends MailRuBasePage {

    @FindBy(xpath = XpathLocators.PROFILE_BUTTON)
    private WebElement profile;

    @FindBy(xpath = XpathLocators.LOG_OUT_BUTTON)
    private WebElement logOut;

    @FindBy(xpath = XpathLocators.SUBJECT)
    private WebElement subject;

    @FindBy(xpath = XpathLocators.NON_EMPTY_LETTER_LIST)
    private WebElement letterList;

    public MailRuTrashPage(WebDriver driver) {
        super(driver);
    }

    public String checkSubjectField() {
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
