package testng.calculator.functional;

import org.testng.Assert;
import org.testng.annotations.Test;
import testng.calculator.functional.constant.GroupNameConstant;

public class CalculatorSqrtTest extends AbstractBaseCalculatorTest {

    @Test(groups = {GroupNameConstant.OTHER_GROUP})
    public void sqrtTest() {
        double actualResult = calculator.sqrt(9.0);
        double expectedResult = 3.0;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
