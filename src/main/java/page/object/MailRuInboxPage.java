package page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.object.locators.XpathLocators;

public class MailRuInboxPage extends MailRuBasePage {

    @FindBy(xpath = XpathLocators.TOMYSELF_FOLDER_BUTTON)
    private WebElement toMyselfFolder;

    @FindBy(xpath = XpathLocators.OUTBOX_FOLDER_BUTTON)
    private WebElement outbox;

    @FindBy(xpath = XpathLocators.DRAFT_FOLDER_BUTTON)
    private WebElement drafts;

    @FindBy(xpath = XpathLocators.WRITE_LETTER_BUTTON)
    private WebElement writeLetter;

    @FindBy(xpath = XpathLocators.SEND_LETTER_BUTTON)
    private WebElement sendLetter;

    @FindBy(xpath = XpathLocators.SAVE_DAFT_BUTTON)
    private WebElement saveDraft;

    @FindBy(xpath = XpathLocators.BLOCK_CLOSE_BUTTON)
    private WebElement block;

    @FindBy(xpath = XpathLocators.CLOSE_BUTTON)
    private WebElement close;

    @FindBy(xpath = XpathLocators.RECEIVER_FIELD)
    private WebElement receiver;

    @FindBy(xpath = XpathLocators.SUBJECT_FIELD)
    private WebElement subject;

    @FindBy(xpath = XpathLocators.LETTER_CONTENT_FIELD)
    private WebElement content;

    public MailRuInboxPage(WebDriver driver) {
        super(driver);
    }

    public MailRuInboxPage inputTextIntoReceiverField(String text) {
        sendKeysToWebElement(receiver, text);
        return new MailRuInboxPage(driver);
    }

    public MailRuInboxPage inputTextIntoSubjectField(String text) {
        sendKeysToWebElement(subject, text);
        return new MailRuInboxPage(driver);
    }

    public MailRuInboxPage inputTextIntoContentField(String text) {
        sendKeysToWebElement(content, text);
        return new MailRuInboxPage(driver);
    }

    public MailRuInboxPage clickToWriteLetterButton() {
        clickToWebElement(writeLetter);
        return new MailRuInboxPage(driver);
    }

    public MailRuInboxPage clickToSaveButton() {
        clickToWebElement(saveDraft);
        return new MailRuInboxPage(driver);
    }

    public MailRuInboxPage clickToSendButton() {
        clickToWebElement(sendLetter);
        return new MailRuInboxPage(driver);
    }

    public MailRuToMyselfPage clickToMyselfFolder() {
        clickToWebElement(toMyselfFolder);
        return new MailRuToMyselfPage(driver);
    }

    public MailRuOutboxPage clickToOutboxFolder() {
        clickToWebElement(outbox);
        return new MailRuOutboxPage(driver);
    }

    public MailRuDraftsPage clickToDraftsFolder() {
        clickToWebElement(drafts);
        return new MailRuDraftsPage(driver);
    }

    public MailRuInboxPage closeWindow() {
        clickToWebElement(close);
        return new MailRuInboxPage(driver);
    }

    public MailRuInboxPage closeBlockWindow() {
        clickToWebElement(block);
        return new MailRuInboxPage(driver);
    }

    public MailRuInboxPage checkPage(String title) {
        checkTitle(title);
        return new MailRuInboxPage(driver);
    }
}
