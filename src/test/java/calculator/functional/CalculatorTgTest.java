package calculator.functional;

import calculator.functional.constant.GroupNameConstant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTgTest extends AbstractBaseCalculatorTest {

    @Test(groups = {GroupNameConstant.TRIGONOMETRY_GROUP})
    public void tgTest() {
        double actualResult = calculator.tg(45 * Math.PI / 180);
        double expectedResult = Math.tan(45 * Math.PI / 180);
        Assert.assertEquals(actualResult, expectedResult, 0.1);
    }
}
