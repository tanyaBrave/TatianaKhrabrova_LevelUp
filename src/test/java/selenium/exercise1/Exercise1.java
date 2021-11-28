package selenium.exercise1;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.AbstractBaseSeleniumTest;
import selenium.locators.XpathLocators;
import selenium.user.data.UserData;

public class Exercise1 extends AbstractBaseSeleniumTest {

    public static final String LETTER_SUBJECT = "Homework test Exercise 1";
    public static final String LETTER_CONTENT = "Exercise 1";

    @Test
    public void signInTest() {
        String title = "Входящие - Почта Mail.ru";

        wait.until(ExpectedConditions.titleIs(title));

        Assert.assertEquals(driver.getTitle(), title);
    }

    @Test(priority = 1)
    public void saveDraftTest() {
        WebElement writeLetter = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath(XpathLocators.WRITE_LETTER_BUTTON)));
        writeLetter.click();

        WebElement receiver = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath(XpathLocators.RECEIVER_FIELD)));
        receiver.sendKeys(UserData.RECEIVER1);

        WebElement subject = driver.findElement(By.xpath(XpathLocators.SUBJECT_FIELD));
        subject.sendKeys(LETTER_SUBJECT);

        WebElement content = driver.findElement(By.xpath(XpathLocators.LETTER_CONTENT_FIELD));
        content.sendKeys(LETTER_CONTENT);

        WebElement saveDraft = driver.findElement(By.xpath(XpathLocators.SAVE_DAFT_BUTTON));
        saveDraft.click();

        WebElement close = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//button[@title='Закрыть']")));
        close.click();

        WebElement draftFolder = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath(XpathLocators.DRAFT_FOLDER_BUTTON)));
        draftFolder.click();

        WebElement draftLetter = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-sj__normal']")));

        Assert.assertEquals(draftLetter.getText(), LETTER_SUBJECT);
    }

    @Test(priority = 2)
    public void verifyReceiverTest() {
        WebElement draftReceiver = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-crpt']")));
        Assert.assertEquals(draftReceiver.getText(), UserData.RECEIVER1);

    }

    @Test(priority = 2)
    public void verifySubjectTest() {
        WebElement draftSubject = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-sj__normal']")));
        Assert.assertEquals(draftSubject.getText(), LETTER_SUBJECT);

    }

    @Test(priority = 2)
    public void verifyContentTest() {
        WebElement draftContent = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-sp__normal']")));

        Assert.assertEquals(draftContent.getText(), LETTER_CONTENT);

    }

    @Test(priority = 3)
    public void sendAndCheckDraftTest() {
        WebElement draft = driver.findElement(By.xpath("//a[contains(@class, 'llc')]"));
        draft.click();

        WebElement sendLetter = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath(XpathLocators.SEND_LETTER_BUTTON)));
        sendLetter.click();

        WebElement block = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@__mediators='layout-manager']//*[@title='Закрыть']")));
        block.click();

        WebElement draftList = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class ='dataset__empty']")));

        Assert.assertTrue(draftList.isDisplayed());
    }

    @Test(priority = 4)
    public void checkOutboxTest() {
        WebElement outboxFolder = driver.findElement(By.xpath(XpathLocators.OUTBOX_FOLDER_BUTTON));
        outboxFolder.click();

        WebElement sentLetter = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-sj__normal']")));

        Assert.assertEquals(sentLetter.getText(), LETTER_SUBJECT);
    }
}
