package calculator.functional;

import calculator.functional.constant.GroupNameConstant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorCosTest extends AbstractBaseCalculatorTest {

    @Test(groups = {GroupNameConstant.TRIGONOMETRY_GROUP})
    public void cosTest() {
        double actualResult = calculator.cos(0 * Math.PI / 180);
        double expectedResult = 1.0;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
