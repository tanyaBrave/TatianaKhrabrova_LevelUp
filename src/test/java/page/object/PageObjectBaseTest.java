package page.object;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class PageObjectBaseTest {

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

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
