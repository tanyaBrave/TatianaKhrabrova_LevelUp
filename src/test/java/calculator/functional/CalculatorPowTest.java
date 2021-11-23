package calculator.functional;

import calculator.constant.GroupNameConstant;
import calculator.data.provider.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorPowTest extends AbstractBaseCalculatorTest {

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Pow Data Provider",
            groups = {GroupNameConstant.OTHER_GROUP})
    public void powTest(double[] arguments, double expectedResult) {

        double actualResult = calculator.pow(arguments[0], arguments[1]);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
