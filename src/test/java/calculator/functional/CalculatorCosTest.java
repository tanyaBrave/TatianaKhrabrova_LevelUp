package calculator.functional;

import calculator.constant.GroupNameConstant;
import calculator.data.provider.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorCosTest extends AbstractBaseCalculatorTest {

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Cos Data Provider",
            groups = {GroupNameConstant.TRIGONOMETRY_GROUP})
    public void cosTest(double argument, double expectedResult) {
        double actualResult = calculator.cos(argument);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
