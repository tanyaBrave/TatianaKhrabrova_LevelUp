package calculator.functional;

import calculator.functional.constant.GroupNameConstant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSinTest extends AbstractBaseCalculatorTest {

    @Test(groups = {GroupNameConstant.TRIGONOMETRY_GROUP})
    public void sinTest() {
        double actualResult = calculator.sin(90 * Math.PI / 180);
        double expectedResult = 1.0;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
