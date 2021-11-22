package calculator.functional;

import calculator.functional.constant.GroupNameConstant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSubTest extends AbstractBaseCalculatorTest {

    @Test
    public void subLongTest() {
        long actualResult = calculator.sub(10, 2);
        long expectedResult = 8;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void subDoubleTest() {
        double actualResult = calculator.sub(5.5, 10);
        double expectedResult = -4.5;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
