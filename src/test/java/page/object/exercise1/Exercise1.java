package page.object.exercise1;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.MailRuDraftsPage;
import page.object.MailRuInboxPage;
import page.object.MailRuIndexPage;
import page.object.MailRuOutboxPage;
import page.object.PageObjectBaseTest;
import page.object.user.data.UserData;

public class Exercise1 extends PageObjectBaseTest {

    public static final String LETTER_SUBJECT = "Homework test Exercise 1";
    public static final String LETTER_CONTENT = "Exercise 1";

    @Test
    public void createDraftAndSendLetter() {
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
                .inputTextIntoReceiverField(UserData.RECEIVER1)
                .inputTextIntoSubjectField(LETTER_SUBJECT)
                .inputTextIntoContentField(LETTER_CONTENT)
                .clickToSaveButton()
                .closeWindow();

        MailRuDraftsPage draftsPage = inboxPage.clickToDraftsFolder();

        Assert.assertTrue(draftsPage.isLetterListNonEmpty());

        Assert.assertEquals(draftsPage.checkReceiverField(), UserData.RECEIVER1);
        Assert.assertEquals(draftsPage.checkSubjectField(), LETTER_SUBJECT);
        Assert.assertEquals(draftsPage.checkContentField(), LETTER_CONTENT);

        draftsPage
                .clickToDraft()
                .clickToSendButton()
                .closeBlockWindow();

        Assert.assertTrue(draftsPage.isLetterListEmpty());

        MailRuOutboxPage outboxPage = draftsPage.clickToOutboxFolder();

        Assert.assertTrue(outboxPage.isLetterListNonEmpty());
        Assert.assertEquals(outboxPage.checkSubjectFiled(), LETTER_SUBJECT);

        outboxPage.logOut();
    }
}
