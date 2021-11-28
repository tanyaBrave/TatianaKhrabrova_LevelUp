package selenium.exercise2;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.AbstractBaseSeleniumTest;
import selenium.locators.XpathLocators;
import selenium.user.data.UserData;

public class Exercise2 extends AbstractBaseSeleniumTest {

    public static final String LETTER_SUBJECT = "Тест";
    public static final String LETTER_CONTENT = "Exercise 2";

    @Test
    public void signInTest() {
        String title = "Входящие - Почта Mail.ru";

        wait.until(ExpectedConditions.titleIs(title));

        Assert.assertEquals(driver.getTitle(), title);
    }

    @Test(priority = 1)
    public void sendLetterTest() {

        WebElement writeLetter = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath(XpathLocators.WRITE_LETTER_BUTTON)));
        writeLetter.click();

        WebElement receiver = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath(XpathLocators.RECEIVER_FIELD)));
        receiver.sendKeys(UserData.RECEIVER2);

        WebElement subject = driver.findElement(By.xpath(XpathLocators.SUBJECT_FIELD));
        subject.sendKeys(LETTER_SUBJECT);

        WebElement content = driver.findElement(By.xpath(XpathLocators.LETTER_CONTENT_FIELD));
        content.sendKeys(LETTER_CONTENT);

        WebElement sendLetter = driver.findElement(By.xpath(XpathLocators.SEND_LETTER_BUTTON));
        sendLetter.click();

        WebElement block = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@__mediators='layout-manager']//*[@title='Закрыть']")));
        block.click();
    }

    @Test(priority = 2)
    public void checkOutboxTest() {
        WebElement outboxFolder = driver.findElement(By.xpath(XpathLocators.OUTBOX_FOLDER_BUTTON));
        outboxFolder.click();

        WebElement sentLetter = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-sp__normal']")));

        Assert.assertEquals(sentLetter.getText(), LETTER_CONTENT);
    }

    @Test(priority = 3)
    public void checkTestFolderTest() {
        WebElement testFolder = driver.findElement(By.xpath(XpathLocators.TEST_FOLDER_BUTTON));
        testFolder.click();

        WebElement letter = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-sp__normal']")));

        Assert.assertEquals(letter.getText(), LETTER_CONTENT);
    }

    @Test(priority = 4)
    public void verifyReceiverTest() {
        WebElement receiver = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-crpt']")));
        Assert.assertEquals(receiver.getText(), UserData.USER);

    }

    @Test(priority = 4)
    public void verifySubjectTest() {
        WebElement subject = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-sj__normal']")));
        Assert.assertEquals(subject.getText(), LETTER_SUBJECT);

    }

    @Test(priority = 4)
    public void verifyContentTest() {
        WebElement content = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-sp__normal']")));

        Assert.assertEquals(content.getText(), LETTER_CONTENT);

    }
}
