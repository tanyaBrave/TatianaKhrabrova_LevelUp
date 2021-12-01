package calculator.functional;

import calculator.constant.GroupNameConstant;
import calculator.data.provider.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSinTest extends AbstractBaseCalculatorTest {

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Sin Data Provider",
            groups = {GroupNameConstant.TRIGONOMETRY_GROUP})
    public void sinTest(double argument, double expectedResult) {
        double actualResult = calculator.sin(argument);
        Assert.assertEquals(actualResult, expectedResult, 0.1);
    }
}
