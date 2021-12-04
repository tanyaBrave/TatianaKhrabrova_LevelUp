package page.object.exercise2;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.MailRuInboxPage;
import page.object.MailRuIndexPage;
import page.object.MailRuOutboxPage;
import page.object.MailRuTestPage;
import page.object.PageObjectBaseTest;
import page.object.user.data.UserData;

public class Exercise2 extends PageObjectBaseTest {

    public static final String LETTER_SUBJECT = "Тест";
    public static final String LETTER_CONTENT = "Exercise 2";

    @Test
    public void sendLetterAndCheckFolder() {
        String title = "Входящие";

        MailRuIndexPage indexPage = new MailRuIndexPage(driver)
                .open()
                .inputTextIntoLoginTextField(UserData.LOGIN)
                .clickToRememberMeCheckbox()
                .clickToPasswordButton()
                .inputTextIntoPasswordTextField(UserData.PASSWORD)
                .clickToSignInButton();

        MailRuInboxPage inboxPage = new MailRuInboxPage(driver)
                .checkPage(title);

        Assert.assertTrue(driver.getTitle().contains(title));

        inboxPage
                .clickToWriteLetterButton()
                .inputTextIntoReceiverField(UserData.RECEIVER2)
                .inputTextIntoSubjectField(LETTER_SUBJECT)
                .inputTextIntoContentField(LETTER_CONTENT)
                .clickToSendButton()
                .closeBlockWindow();

        MailRuOutboxPage outboxPage = inboxPage.clickToOutboxFolder();

        Assert.assertTrue(outboxPage.checkSubjectFiled().contains(LETTER_SUBJECT));

        MailRuTestPage testPage = outboxPage.clickToTestFolder();

        Assert.assertTrue(testPage.isLetterListNonEmpty());
        Assert.assertEquals(testPage.checkReceiverField(), UserData.RECEIVER2);
        Assert.assertTrue(testPage.checkSubjectField().contains(LETTER_SUBJECT));
        Assert.assertEquals(testPage.checkContentField(), LETTER_CONTENT);

        testPage.logOut();
    }
}
