package testng.calculator.functional;

import org.testng.Assert;
import org.testng.annotations.Test;
import testng.calculator.functional.constant.GroupNameConstant;

public class CalculatorIsNegativeTest extends AbstractBaseCalculatorTest {

    @Test(groups = {GroupNameConstant.OTHER_GROUP})
    public void isNegativeTest() {
        Assert.assertTrue(calculator.isNegative(-6));
    }
}
