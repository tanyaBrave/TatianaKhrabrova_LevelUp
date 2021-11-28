package testng.calculator.functional;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorMultTest extends AbstractBaseCalculatorTest {

    @Test
    public void multLongTest() {
        long actualResult = calculator.mult(2, 2);
        long expectedResult = 4;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void multDoubleTest() {
        double actualResult = calculator.mult(3.6, 5.8);
        double expectedResult = Math.floor(20.88);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
