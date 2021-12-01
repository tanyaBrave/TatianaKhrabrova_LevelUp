package calculator.functional;

import calculator.constant.GroupNameConstant;
import calculator.data.provider.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorIsNegativeTest extends AbstractBaseCalculatorTest {

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Is Negative Data Provider",
            groups = {GroupNameConstant.OTHER_GROUP})
    public void isNegativeTest(long argument, boolean expectedResult) {
        boolean actualResult = calculator.isNegative(argument);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
