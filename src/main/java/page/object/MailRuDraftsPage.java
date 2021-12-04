package page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.object.locators.XpathLocators;

public class MailRuDraftsPage extends MailRuBasePage {

    @FindBy(xpath = XpathLocators.OUTBOX_FOLDER_BUTTON)
    private WebElement outbox;

    @FindBy(xpath = XpathLocators.SEND_LETTER_BUTTON)
    private WebElement send;

    @FindBy(xpath = XpathLocators.BLOCK_CLOSE_BUTTON)
    private WebElement block;

    @FindBy(xpath = XpathLocators.RECEIVER)
    private WebElement receiver;

    @FindBy(xpath = XpathLocators.SUBJECT)
    private WebElement subject;

    @FindBy(xpath = XpathLocators.CONTENT)
    private WebElement content;

    @FindBy(xpath = XpathLocators.NON_EMPTY_LETTER_LIST)
    private WebElement letterList;

    @FindBy(xpath = XpathLocators.EMPTY_LETTER_LIST)
    private WebElement emptyLetterList;

    @FindBy(xpath = XpathLocators.LETTER)
    private WebElement draft;

    public MailRuDraftsPage(WebDriver driver) {
        super(driver);
    }

    public MailRuDraftsPage clickToDraft() {
        clickToWebElement(draft);
        return new MailRuDraftsPage(driver);
    }

    public MailRuDraftsPage clickToSendButton() {
        clickToWebElement(send);
        return new MailRuDraftsPage(driver);
    }

    public MailRuDraftsPage closeBlockWindow() {
        clickToWebElement(block);
        return new MailRuDraftsPage(driver);
    }

    public MailRuOutboxPage clickToOutboxFolder() {
        clickToWebElement(outbox);
        return new MailRuOutboxPage(driver);
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

    public boolean isLetterListEmpty() {
        return findWebElement(emptyLetterList);
    }
}
