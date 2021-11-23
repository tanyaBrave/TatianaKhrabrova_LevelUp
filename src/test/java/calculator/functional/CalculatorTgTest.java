package calculator.functional;

import calculator.constant.GroupNameConstant;
import calculator.data.provider.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTgTest extends AbstractBaseCalculatorTest {

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Tg Data Provider",
            groups = {GroupNameConstant.TRIGONOMETRY_GROUP})
    public void tgTest(double argument, double expectedResult) {
        double actualResult = calculator.tg(argument);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
