package step.design.allure.step;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import step.design.allure.MailRuIndexPage;

public class MailRuIndexPageStep extends MailRuBaseStep {

    private MailRuIndexPage indexPage;

    public MailRuIndexPageStep(WebDriver driver) {
        super(driver);
        this.indexPage = new MailRuIndexPage(driver);
    }

    @Step("Открываем стартовую страницу")
    public void openMailRuIndexPage() {
        indexPage.open();
    }

    @Step("Заходим в почту")
    public void signIn(final String login, final String password) {
        indexPage.clickToRememberMeCheckbox();
        indexPage.inputTextIntoLoginTextField(login);
        indexPage.clickToPasswordButton();
        indexPage.inputTextIntoPasswordTextField(password);
        indexPage.clickToSignInButton();
    }
}
