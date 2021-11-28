package testng.calculator.functional;

import org.testng.Assert;
import org.testng.annotations.Test;
import testng.calculator.functional.constant.GroupNameConstant;

public class CalculatorSinTest extends AbstractBaseCalculatorTest {

    @Test(groups = {GroupNameConstant.TRIGONOMETRY_GROUP})
    public void sinTest() {
        double actualResult = calculator.sin(90 * Math.PI / 180);
        double expectedResult = 1.0;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
