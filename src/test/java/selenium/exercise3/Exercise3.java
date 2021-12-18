package selenium.exercise3;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.AbstractBaseSeleniumTest;
import selenium.locators.XpathLocators;
import selenium.user.data.UserData;

public class Exercise3 extends AbstractBaseSeleniumTest {

    public static final String LETTER_SUBJECT = "Homework test Exercise 3";
    public static final String LETTER_CONTENT = "Exercise 3";

    @Test
    public void sendLetterAndDelete() {
        String title = "Входящие";

        wait.until(ExpectedConditions.titleContains(title));

        Assert.assertTrue(driver.getTitle().contains(title));

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

        WebElement outboxFolder = driver.findElement(By.xpath(XpathLocators.TOMYSELF_FOLDER_BUTTON));
        outboxFolder.click();

        WebElement letterList = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[contains(@class, 'letter-list_has-letters')]")));

        Assert.assertTrue(letterList.isDisplayed());

        WebElement receiverMyself = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-crpt']")));
        Assert.assertEquals(receiverMyself.getText(), UserData.USER);

        WebElement subjectMyself = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-sj__normal']")));
        Assert.assertEquals(subjectMyself.getText(), LETTER_SUBJECT);

        WebElement contentMyself = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-sp__normal']")));

        Assert.assertEquals(contentMyself.getText(), LETTER_CONTENT);

        WebElement letter = driver.findElement(By.xpath("//a[contains(@class, 'llc')]"));
        letter.click();

        WebElement deleteButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath(XpathLocators.DELETE_LETTER_BUTTON)));
        deleteButton.click();

        WebElement trashFolder = driver.findElement(By.xpath(XpathLocators.TRASH_FOLDER_BUTTON));
        trashFolder.click();

        WebElement deletedLetter = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[@class='ll-sj__normal']")));

        Assert.assertEquals(deletedLetter.getText(), LETTER_SUBJECT);
    }
}
