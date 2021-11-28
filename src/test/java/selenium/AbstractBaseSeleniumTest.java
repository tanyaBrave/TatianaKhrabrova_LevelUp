package selenium;

import static org.openqa.selenium.By.xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import selenium.locators.XpathLocators;
import selenium.user.data.UserData;


public class AbstractBaseSeleniumTest {
    public static final String MAIL_RU_URL = "https://mail.ru";

    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(MAIL_RU_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement login = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath(XpathLocators.LOGIN_FIELD)));
        login.sendKeys(UserData.LOGIN);

        WebElement rememberMe = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath(XpathLocators.REMEMBER_ME_CHECKBOX)));
        rememberMe.click();

        WebElement passwordButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath(XpathLocators.PASSWORD_BUTTON)));
        passwordButton.click();

        WebElement password = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath(XpathLocators.PASSWORD_FIELD)));
        password.sendKeys(UserData.PASSWORD);

        WebElement signInButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath(XpathLocators.SIGN_IN_BUTTON)));
        signInButton.click();
    }

    @AfterClass
    public void tearDown() {
        WebElement profile = driver.findElement(By.xpath(XpathLocators.PROFILE_BUTTON));
        profile.click();

        WebElement logOut = wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//div[text()='Выйти']")));
        logOut.click();

        driver.quit();
    }
}
