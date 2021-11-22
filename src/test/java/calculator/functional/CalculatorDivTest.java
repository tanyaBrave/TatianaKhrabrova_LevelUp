package calculator.functional;

import calculator.functional.constant.GroupNameConstant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorDivTest extends AbstractBaseCalculatorTest {

    @Test
    public void divLongTest() {
        long actualResult = calculator.div(16, 4);
        long expectedResult = 4;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void divByZeroLongTest() {
        Assert.assertThrows(() -> calculator.div(1, 0));
    }

    @Test
    public void divDoubleTest() {
        double actualResult = calculator.div(9.6, 3.0);
        double expectedResult = 3.2;
        Assert.assertEquals(actualResult, expectedResult, 0.01);
    }
}
