package step.design.allure.step;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import step.design.allure.MailRuDraftsPage;

public class MailRuDraftPageStep extends MailRuBaseStep {

    private MailRuDraftsPage draftsPage;

    public MailRuDraftPageStep(WebDriver driver) {
        super(driver);
        this.draftsPage = new MailRuDraftsPage(driver);
    }

    @Step("Открываем черновик")
    public void openDraft() {
        draftsPage.clickToDraft();
    }

    @Step("Отправляем письмо")
    public void sendLetter() {
        draftsPage.clickToSendButton();
    }

    @Step("Закрываем вплывающее окно")
    public void closeBlockWindow() {
        draftsPage.closeBlockWindow();
    }

    @Step("Отправитель должен совпадать совпадать с '{receiver}', тема должна совпадать '{subject}', " +
            "содержание письма должно совпадать с '{content}'")
    public void checkLetterData(final String receiver, final String subject, final String content) {

        Assert.assertEquals(draftsPage.checkReceiverField(), receiver);
        Assert.assertEquals(draftsPage.checkSubjectField(), subject);
        Assert.assertEquals(draftsPage.checkContentField(), content);
    }

    @Step("Проверям что письмо ушло")
    public void isLetterListEmpty() {
        Assert.assertTrue(draftsPage.isLetterListEmpty());
    }

    @Step("Проверяем что в списке писем есть письмо")
    public void isLetterListNonEmpty() {
        Assert.assertTrue(draftsPage.isLetterListNonEmpty());
    }

    @Step("Открываем папку Отправленные")
    public void openOutboxFolder() {
        draftsPage.clickToOutboxFolder();
    }
}
