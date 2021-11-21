package calculator.functional;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.levelup.qa.at.calculator.Calculator;

public class AbstractBaseCalculatorTest {
    protected Calculator calculator;

    @BeforeMethod (alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }


}
