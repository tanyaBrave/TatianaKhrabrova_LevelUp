package calculator.functional;

import calculator.data.provider.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorMultTest extends AbstractBaseCalculatorTest {

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Mult Data Provider Long")
    public void multLongTest(long[] arguments, long expectedResult) {

        long actualResult = calculator.mult(arguments[0], arguments[1]);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Mult Data Provider Double")
    public void multDoubleTest(double[] arguments, double expectedResult) {

        double actualResult = calculator.mult(arguments[0], arguments[1]);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
