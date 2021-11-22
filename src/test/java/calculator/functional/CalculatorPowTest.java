package calculator.functional;

import calculator.functional.constant.GroupNameConstant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorPowTest extends AbstractBaseCalculatorTest {

    @Test(groups = {GroupNameConstant.OTHER_GROUP})
    public void powTest() {
        double actualResult = calculator.pow(2.0, 5.0);
        double expectedResult = 32.0;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
