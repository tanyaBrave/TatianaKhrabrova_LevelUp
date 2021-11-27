package calculator.functional;

import calculator.data.provider.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSumTest extends AbstractBaseCalculatorTest {

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Sum Data Provider Long")
    public void sumLongTest(long[] arguments, long expectedResult) {

        long actualResult = calculator.sum(arguments[0], arguments[1]);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Sum Data Provider Double")
    public void sumDoubleTest(double[] arguments, double expectedResult) {

        double actualResult = calculator.sum(arguments[0], arguments[1]);
        Assert.assertEquals(actualResult, expectedResult, 0.1);
    }
}
