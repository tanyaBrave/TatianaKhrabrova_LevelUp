package step.design.allure;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

public class StepBaseTest {

    public static final String MAIL_RU_URL = "https://mail.ru";

    protected WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
