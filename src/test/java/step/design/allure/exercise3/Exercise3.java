package step.design.allure.exercise3;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import step.design.allure.StepBaseTest;
import step.design.allure.step.MailRuInboxPageStep;
import step.design.allure.step.MailRuIndexPageStep;
import step.design.allure.step.MailRuToMyselfPageStep;
import step.design.allure.step.MailRuTrashPageStep;
import step.design.allure.user.data.UserData;

@Feature("Позитивная проверка удаления письма")
@Story("Пользователю доступно удаление отправленного письма")
public class Exercise3 extends StepBaseTest {

    public static final String LETTER_SUBJECT = "Homework test Exercise 3";
    public static final String LETTER_CONTENT = "Exercise 3";

    private MailRuIndexPageStep indexPageStep;
    private MailRuInboxPageStep inboxPageStep;
    private MailRuToMyselfPageStep toMyselfPageStep;
    private MailRuTrashPageStep trashPageStep;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(MAIL_RU_URL);
        indexPageStep = new MailRuIndexPageStep(driver);
        inboxPageStep = new MailRuInboxPageStep(driver);
        toMyselfPageStep = new MailRuToMyselfPageStep(driver);
        trashPageStep = new MailRuTrashPageStep(driver);
    }

    @Test
    public void sendLetterAndDelete() {
        String title = "Входящие";

        indexPageStep.openMailRuIndexPage();
        indexPageStep.signIn(UserData.LOGIN, UserData.PASSWORD);

        inboxPageStep.checkPageTitle(title);
        inboxPageStep.writeLetter(UserData.RECEIVER2, LETTER_SUBJECT, LETTER_CONTENT);
        inboxPageStep.sendLetter();
        inboxPageStep.closeBlockWindow();
        inboxPageStep.openToMyselfFolder();

        toMyselfPageStep.isLetterListNonEmpty();
        toMyselfPageStep.checkLetterData(UserData.USER_NAME, LETTER_SUBJECT, LETTER_CONTENT);
        toMyselfPageStep.openLetter();
        toMyselfPageStep.deleteLetter();
        toMyselfPageStep.openTrashFolder();

        trashPageStep.isLetterListNonEmpty();
        trashPageStep.checkSubject(LETTER_SUBJECT);
        trashPageStep.logOut();
    }
}
