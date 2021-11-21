package calculator.functional;

import calculator.functional.constant.GroupNameConstant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSumTest extends AbstractBaseCalculatorTest {

    @Test
    public void sumLongTest() {
        long actualResult = calculator.sum(1, 1);
        long expectedResult = 2;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void sumDoubleTest() {
        double actualResult = calculator.sum(1.5, 0.5);
        double expectedResult = 2.0;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
