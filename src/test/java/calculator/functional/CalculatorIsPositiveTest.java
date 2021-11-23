package calculator.functional;

import calculator.functional.constant.GroupNameConstant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorIsPositiveTest extends AbstractBaseCalculatorTest {

    @Test(groups = {GroupNameConstant.OTHER_GROUP})
    public void isPositiveTest() {
        Assert.assertTrue(calculator.isPositive(1));
    }

    @Test(groups = {GroupNameConstant.OTHER_GROUP})
    public void zeroIsPositiveTest() {
        Assert.assertFalse(calculator.isPositive(0));
    }

}
