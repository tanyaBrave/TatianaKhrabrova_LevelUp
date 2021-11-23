package calculator.functional;

import calculator.constant.GroupNameConstant;
import calculator.data.provider.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorCtgTest extends AbstractBaseCalculatorTest {

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Ctg Data Provider",
            groups = {GroupNameConstant.TRIGONOMETRY_GROUP})
    public void ctgTest(double argument, double expectedResult) {
        double actualResult = calculator.ctg(argument);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
