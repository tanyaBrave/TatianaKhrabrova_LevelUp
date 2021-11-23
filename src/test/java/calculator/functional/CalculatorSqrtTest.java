package calculator.functional;

import calculator.constant.GroupNameConstant;
import calculator.data.provider.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSqrtTest extends AbstractBaseCalculatorTest {

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Sqrt Data Provider",
            groups = {GroupNameConstant.OTHER_GROUP})
    public void sqrtTest(double argument, double expectedResult) {
        double actualResult = calculator.sqrt(argument);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
