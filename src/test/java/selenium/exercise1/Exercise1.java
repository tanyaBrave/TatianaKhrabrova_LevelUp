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
    public void createDraftAndSendLetter() {
        String title = "Входящие";

        wait.until(ExpectedConditions.titleContains(title));

        Assert.assertTrue(driver.getTitle().contains(title));

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

        WebElement draftReceiver = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-crpt']")));
        Assert.assertEquals(draftReceiver.getText(), UserData.RECEIVER1);

        WebElement draftSubject = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-sj__normal']")));
        Assert.assertEquals(draftSubject.getText(), LETTER_SUBJECT);

        WebElement draftContent = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-sp__normal']")));

        Assert.assertEquals(draftContent.getText(), LETTER_CONTENT);

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

        WebElement outboxFolder = driver.findElement(By.xpath(XpathLocators.OUTBOX_FOLDER_BUTTON));
        outboxFolder.click();

        WebElement sentLetter = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-sj__normal']")));

        Assert.assertEquals(sentLetter.getText(), LETTER_SUBJECT);
    }
}
