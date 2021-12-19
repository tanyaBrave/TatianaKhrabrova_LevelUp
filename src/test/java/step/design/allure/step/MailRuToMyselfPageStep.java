package step.design.allure.step;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import step.design.allure.MailRuToMyselfPage;

public class MailRuToMyselfPageStep extends MailRuBaseStep {

    MailRuToMyselfPage toMyselfPage;

    public MailRuToMyselfPageStep(WebDriver driver) {
        super(driver);
        this.toMyselfPage = new MailRuToMyselfPage(driver);
    }

    @Step("Открываем письмо")
    public void openLetter() {
        toMyselfPage.clickToLetter();
    }

    @Step("Удаляем письмо")
    public void deleteLetter() {
        toMyselfPage.clickToDeleteButton();
    }

    @Step("Отправитель должен совпадать совпадать с '{receiver}', тема должна совпадать '{subject}', "
            + "содержание письма должно совпадать с '{content}'")
    public void checkLetterData(final String receiver, final String subject, final String content) {
        Assert.assertEquals(toMyselfPage.checkReceiverField(), receiver);
        Assert.assertEquals(toMyselfPage.checkSubjectField(), subject);
        Assert.assertEquals(toMyselfPage.checkContentField(), content);
    }

    @Step("Проверяем что в списке писем есть письмо")
    public void isLetterListNonEmpty() {
        Assert.assertTrue(toMyselfPage.isLetterListNonEmpty());
    }

    @Step("Открываем папку Корзина")
    public void openTrashFolder() {
        toMyselfPage.clickToTrashFolder();
    }
}
