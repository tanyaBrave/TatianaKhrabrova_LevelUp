package calculator.functional;

import calculator.functional.constant.GroupNameConstant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorIsNegativeTest extends AbstractBaseCalculatorTest {

    @Test(groups = {GroupNameConstant.OTHER_GROUP})
    public void isNegativeTest() {
        Assert.assertTrue(calculator.isNegative(-6));
    }
}
