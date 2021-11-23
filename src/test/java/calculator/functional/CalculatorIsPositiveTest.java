package calculator.functional;

import calculator.constant.GroupNameConstant;
import calculator.data.provider.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorIsPositiveTest extends AbstractBaseCalculatorTest {

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Is Positive Data Provider",
            groups = {GroupNameConstant.OTHER_GROUP})
    public void isPositiveTest(long argument, boolean expectedResult) {
        boolean actualResult = calculator.isPositive(argument);
        Assert.assertEquals(actualResult, expectedResult);
    }

}
