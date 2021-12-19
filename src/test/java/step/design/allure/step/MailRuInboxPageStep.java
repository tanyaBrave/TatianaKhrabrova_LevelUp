package step.design.allure.step;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import step.design.allure.MailRuInboxPage;

public class MailRuInboxPageStep extends MailRuBaseStep {

    MailRuInboxPage inboxPage;

    public MailRuInboxPageStep(WebDriver driver) {
        super(driver);
        this.inboxPage = new MailRuInboxPage(driver);
    }

    @Step("Заголовок страницы должен сопадать с '{expectedTitle}'")
    public void checkPageTitle(final String expectedTitle) {

        inboxPage.checkInboxPageTitle(expectedTitle);
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }

    @Step("Нажимаем кнопку написать письмо и вносим тестовые данные")
    public void writeLetter(final String receiver, final String subject, final String content) {
        inboxPage.clickToWriteLetterButton();
        inboxPage.inputTextIntoReceiverField(receiver);
        inboxPage.inputTextIntoSubjectField(subject);
        inboxPage.inputTextIntoContentField(content);
    }

    @Step("Сохраняем черновик")
    public void saveDraft() {
        inboxPage.clickToSaveButton();
    }

    @Step("Отправлем письмо")
    public void sendLetter() {
        inboxPage.clickToSendButton();
    }

    @Step("Закрываем окно с письмом")
    public void closeLetter() {
        inboxPage.closeWindow();
    }

    @Step("Закрываем всплывающее окно")
    public void closeBlockWindow() {
        inboxPage.closeBlockWindow();
    }

    @Step("Открываем папку Письма себе")
    public void openToMyselfFolder() {
        inboxPage.clickToMyselfFolder();
    }

    @Step("Открываем папку Отправленные")
    public void openOutboxFolder() {
        inboxPage.clickToOutboxFolder();
    }

    @Step("Открываем папку Черновики")
    public void openDraftsFolder() {
        inboxPage.clickToDraftsFolder();
    }
}
