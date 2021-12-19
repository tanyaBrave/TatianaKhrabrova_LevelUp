package step.design.allure.step;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import step.design.allure.MailRuTrashPage;

public class MailRuTrashPageStep extends MailRuBaseStep {

    MailRuTrashPage trashPage;

    public MailRuTrashPageStep(WebDriver driver) {
        super(driver);
        this.trashPage = new MailRuTrashPage(driver);
    }

    @Step("Отправитель должен совпадать совпадать с '{receiver}'")
    public void checkSubject(final String subject) {
        Assert.assertEquals(trashPage.checkSubjectField(), subject);
    }

    @Step("Проверяем что в списке писем есть письмо")
    public void isLetterListNonEmpty() {
        Assert.assertTrue(trashPage.isLetterListNonEmpty());
    }

    @Step("Выходим из почты")
    public void logOut() {
        trashPage.logOut();
    }
}
