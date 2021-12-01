package calculator.functional;

import calculator.data.provider.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSubTest extends AbstractBaseCalculatorTest {

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Sub Data Provider Long")
    public void subLongTest(long[] arguments, long expectedResult) {

        long actualResult = calculator.sub(arguments[0], arguments[1]);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Sub Data Provider Double")
    public void subDoubleTest(double[] arguments, double expectedResult) {

        double actualResult = calculator.sub(arguments[0], arguments[1]);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
