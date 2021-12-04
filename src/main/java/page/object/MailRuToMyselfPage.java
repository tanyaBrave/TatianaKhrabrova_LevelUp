package page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.object.locators.XpathLocators;

public class MailRuToMyselfPage extends MailRuBasePage {

    @FindBy(xpath = XpathLocators.DELETE_LETTER_BUTTON)
    private WebElement delete;

    @FindBy(xpath = XpathLocators.TRASH_FOLDER_BUTTON)
    private WebElement trash;

    @FindBy(xpath = XpathLocators.RECEIVER)
    private WebElement receiver;

    @FindBy(xpath = XpathLocators.SUBJECT)
    private WebElement subject;

    @FindBy(xpath = XpathLocators.CONTENT)
    private WebElement content;

    @FindBy(xpath = XpathLocators.NON_EMPTY_LETTER_LIST)
    private WebElement letterList;

    @FindBy(xpath = XpathLocators.LETTER)
    private WebElement letter;

    public MailRuToMyselfPage(WebDriver driver) {
        super(driver);
    }

    public MailRuToMyselfPage clickToLetter() {
        clickToWebElement(letter);
        return new MailRuToMyselfPage(driver);
    }

    public MailRuToMyselfPage clickToDeleteButton() {
        clickToWebElement(delete);
        return new MailRuToMyselfPage(driver);
    }

    public MailRuTrashPage clickToTrashFolder() {
        clickToWebElement(trash);
        return new MailRuTrashPage(driver);
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
}
