package step.design.allure.exercise2;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import step.design.allure.StepBaseTest;
import step.design.allure.step.MailRuInboxPageStep;
import step.design.allure.step.MailRuIndexPageStep;
import step.design.allure.step.MailRuOutboxPageStep;
import step.design.allure.step.MailRuTestPageStep;
import step.design.allure.user.data.UserData;

@Feature("Позитивная отправка письма с опредленной темой")
@Story("Отправленные письма с определенной темой сохраняются в отдельную папку")
public class Exercise2 extends StepBaseTest {

    public static final String LETTER_SUBJECT = "Тест";
    public static final String LETTER_CONTENT = "Exercise 2";

    private MailRuIndexPageStep indexPageStep;
    private MailRuInboxPageStep inboxPageStep;
    private MailRuOutboxPageStep outboxPageStep;
    private MailRuTestPageStep testPageStep;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(MAIL_RU_URL);
        indexPageStep = new MailRuIndexPageStep(driver);
        inboxPageStep = new MailRuInboxPageStep(driver);
        outboxPageStep = new MailRuOutboxPageStep(driver);
        testPageStep = new MailRuTestPageStep(driver);
    }

    @Test
    public void sendLetterAndCheckFolder() {
        String title = "Входящие";

        indexPageStep.openMailRuIndexPage();
        indexPageStep.signIn(UserData.LOGIN, UserData.PASSWORD);

        inboxPageStep.checkPageTitle(title);
        inboxPageStep.writeLetter(UserData.RECEIVER2, LETTER_SUBJECT, LETTER_CONTENT);
        inboxPageStep.sendLetter();
        inboxPageStep.closeBlockWindow();
        inboxPageStep.openOutboxFolder();

        outboxPageStep.checkSubject(LETTER_SUBJECT);
        outboxPageStep.openTestFolder();

        testPageStep.isLetterListNonEmpty();
        testPageStep.checkLetterData(UserData.USER_NAME, LETTER_SUBJECT, LETTER_CONTENT);
        testPageStep.logOut();
    }
}
