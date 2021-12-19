package step.design.allure.step;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import step.design.allure.MailRuOutboxPage;

public class MailRuOutboxPageStep extends MailRuBaseStep {

    MailRuOutboxPage outboxPage;

    public MailRuOutboxPageStep(WebDriver driver) {
        super(driver);
        this.outboxPage = new MailRuOutboxPage(driver);
    }

    @Step("Отправитель должен совпадать совпадать с '{receiver}'")
    public void checkSubject(final String subject) {
        Assert.assertTrue(outboxPage.checkSubjectFiled().contains(subject));
    }

    @Step("Проверяем что в списке писем есть письмо")
    public void isLetterListNonEmpty() {
        Assert.assertTrue(outboxPage.isLetterListNonEmpty());
    }

    @Step("Открываем папку Тест")
    public void openTestFolder() {
        outboxPage.clickToTestFolder();
    }

    @Step("Выходим из почты")
    public void logOut() {
        outboxPage.logOut();
    }
}
