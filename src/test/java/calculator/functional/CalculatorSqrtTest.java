package calculator.functional;

import calculator.functional.constant.GroupNameConstant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSqrtTest extends AbstractBaseCalculatorTest {

    @Test(groups = {GroupNameConstant.OTHER_GROUP})
    public void sqrtTest() {
        double actualResult = calculator.sqrt(9.0);
        double expectedResult = 3.0;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
