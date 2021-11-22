package calculator.functional;

import calculator.functional.constant.GroupNameConstant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorCtgTest extends AbstractBaseCalculatorTest {

    @Test(groups = {GroupNameConstant.TRIGONOMETRY_GROUP})
    public void ctgTest() {
        double actualResult = calculator.ctg(45 * Math.PI / 180);
        double expectedResult = Math.cos(45 * Math.PI / 180) / Math.sin(45 * Math.PI / 180);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
