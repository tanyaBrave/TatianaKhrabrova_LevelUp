package calculator.functional;

import calculator.data.provider.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorDivTest extends AbstractBaseCalculatorTest {

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Div Data Provider Long")
    public void divLongTest(long[] arguments, long expectedResult) {

        if (arguments[1] == 0) {
            Assert.assertThrows(() -> calculator.div(arguments[0], arguments[1]));
        } else {
            long actualResult = calculator.div(arguments[0], arguments[1]);
            Assert.assertEquals(actualResult, expectedResult);
        }

    }

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Div Data Provider Double")
    public void divDoubleTest(double[] arguments, double expectedResult) {

        if (arguments[1] == 0) {
            Assert.assertThrows(() -> calculator.div(arguments[0], arguments[1]));
        } else {
            double actualResult = calculator.div(arguments[0], arguments[1]);
            Assert.assertEquals(actualResult, expectedResult, 0.01);
        }
    }
}
