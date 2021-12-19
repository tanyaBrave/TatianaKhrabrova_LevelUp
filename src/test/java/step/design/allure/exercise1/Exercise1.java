package step.design.allure.exercise1;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import step.design.allure.StepBaseTest;
import step.design.allure.step.MailRuDraftPageStep;
import step.design.allure.step.MailRuInboxPageStep;
import step.design.allure.step.MailRuIndexPageStep;
import step.design.allure.step.MailRuOutboxPageStep;
import step.design.allure.user.data.UserData;

@Feature("Позитивная отправка сохраненного письма")
@Story("Пользователю доступно сохранение и отправка черновика")
public class Exercise1 extends StepBaseTest {

    public static final String LETTER_SUBJECT = "Homework test Exercise 1";
    public static final String LETTER_CONTENT = "Exercise 1";

    private MailRuIndexPageStep indexPageStep;
    private MailRuInboxPageStep inboxPageStep;
    private MailRuDraftPageStep draftPageStep;
    private MailRuOutboxPageStep outboxPageStep;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(MAIL_RU_URL);
        indexPageStep = new MailRuIndexPageStep(driver);
        inboxPageStep = new MailRuInboxPageStep(driver);
        draftPageStep = new MailRuDraftPageStep(driver);
        outboxPageStep = new MailRuOutboxPageStep(driver);
    }

    @Test
    public void createDraftAndSendLetter() {
        String title = "Входящие";

        indexPageStep.openMailRuIndexPage();
        indexPageStep.signIn(UserData.LOGIN, UserData.PASSWORD);

        inboxPageStep.checkPageTitle(title);
        inboxPageStep.writeLetter(UserData.RECEIVER1, LETTER_SUBJECT, LETTER_CONTENT);
        inboxPageStep.saveDraft();
        inboxPageStep.closeLetter();
        inboxPageStep.openDraftsFolder();

        draftPageStep.isLetterListNonEmpty();
        draftPageStep.checkLetterData(UserData.RECEIVER1, LETTER_SUBJECT, LETTER_CONTENT);
        draftPageStep.openDraft();
        draftPageStep.sendLetter();
        draftPageStep.closeBlockWindow();
        draftPageStep.isLetterListEmpty();
        draftPageStep.openOutboxFolder();

        outboxPageStep.isLetterListNonEmpty();
        outboxPageStep.checkSubject(LETTER_SUBJECT);
        outboxPageStep.logOut();
    }
}
