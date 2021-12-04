package page.object.exercise3;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.MailRuInboxPage;
import page.object.MailRuIndexPage;
import page.object.MailRuToMyselfPage;
import page.object.MailRuTrashPage;
import page.object.PageObjectBaseTest;
import page.object.user.data.UserData;

public class Exercise3 extends PageObjectBaseTest {

    public static final String LETTER_SUBJECT = "Homework test Exercise 3";
    public static final String LETTER_CONTENT = "Exercise 3";

    @Test
    public void sendLetterAndDelete() {
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

        MailRuToMyselfPage toMyselfPage = inboxPage.clickToMyselfFolder();

        Assert.assertTrue(toMyselfPage.isLetterListNonEmpty());
        Assert.assertEquals(toMyselfPage.checkReceiverField(), UserData.USER_NAME);
        Assert.assertEquals(toMyselfPage.checkSubjectField(), LETTER_SUBJECT);
        Assert.assertEquals(toMyselfPage.checkContentField(), LETTER_CONTENT);

        toMyselfPage
                .clickToLetter()
                .clickToDeleteButton();

        MailRuTrashPage trashPage = toMyselfPage.clickToTrashFolder();

        Assert.assertTrue(trashPage.isLetterListNonEmpty());
        Assert.assertEquals(trashPage.checkSubjectField(), LETTER_SUBJECT);

        trashPage.logOut();
    }
}
