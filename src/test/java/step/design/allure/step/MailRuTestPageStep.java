package step.design.allure.step;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import step.design.allure.MailRuTestPage;

public class MailRuTestPageStep extends MailRuBaseStep {

    MailRuTestPage testPage;

    public MailRuTestPageStep(WebDriver driver) {
        super(driver);
        this.testPage = new MailRuTestPage(driver);
    }

    @Step("Отправитель должен совпадать совпадать с '{receiver}', тема должна совпадать '{subject}', " +
            "содержание письма должно совпадать с '{content}'")
    public void checkLetterData(final String receiver, final String subject, final String content) {
        Assert.assertEquals(testPage.checkReceiverField(), receiver);
        Assert.assertTrue(testPage.checkSubjectField().contains(subject));
        Assert.assertEquals(testPage.checkContentField(), content);
    }

    @Step("Проверяем что в списке писем есть письмо")
    public void isLetterListNonEmpty() {
        Assert.assertTrue(testPage.isLetterListNonEmpty());
    }

    @Step("Выходим из почты")
    public void logOut() {
        testPage.logOut();
    }
}
