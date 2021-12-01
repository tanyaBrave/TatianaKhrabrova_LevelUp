package calculator.data.provider;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {

    @DataProvider(name = "Sum Data Provider Long")
    public Object[][] sumDataProviderLong() {
        return new Object[][] {
                {new long[]{1, 1}, 2},
                {new long[]{-5, 2}, -3},
                {new long[]{3, -4}, -1},
                {new long[]{0, 10}, 10}
        };
    }

    @DataProvider(name = "Sum Data Provider Double")
    public Object[][] sumDataProviderDouble() {
        return new Object[][] {
                {new double[]{3.5, 0.0}, 3.5},
                {new double[]{-1.3, 2.4}, 1.1},
                {new double[]{3.6, -4.5}, -0.9},
                {new double[]{7.6, 12.4}, 20.0}
        };
    }

    @DataProvider(name = "Sub Data Provider Long")
    public Object[][] subDataProviderLong() {
        return new Object[][] {
                {new long[]{1, 1}, 0},
                {new long[]{-5, 2}, -7},
                {new long[]{3, -4}, 7},
                {new long[]{0, 10}, -10}
        };
    }

    @DataProvider(name = "Sub Data Provider Double")
    public Object[][] subDataProviderDouble() {
        return new Object[][] {
                {new double[]{3.5, 0.0}, 3.5},
                {new double[]{-1.3, 2.4}, -3.7},
                {new double[]{3.6, -4.5}, 8.1}
        };
    }

    @DataProvider(name = "Mult Data Provider Long")
    public Object[][] multDataProviderLong() {
        return new Object[][] {
                {new long[]{2, 2}, 4},
                {new long[]{0, 100}, 0},
                {new long[]{53, 0}, 0},
                {new long[]{-6, 7}, -42}
        };
    }

    @DataProvider(name = "Mult Data Provider Double")
    public Object[][] multDataProviderDouble() {
        return new Object[][] {
                {new double[]{1.5, 2.5}, Math.floor(3.75)},
                {new double[]{3.5, 0.0}, 0.0},
                {new double[]{0.0, 6.9}, 0.0},
                {new double[]{-3.1, 4.1}, Math.floor(-12.71)}
        };
    }

    @DataProvider(name = "Div Data Provider Long")
    public Object[][] divDataProviderLong() {
        return new Object[][] {
                {new long[]{2, 2}, 1},
                {new long[]{0, 100}, 0},
                {new long[]{53, 0}, 0},
                {new long[]{-9, 3}, -3}
        };
    }

    @DataProvider(name = "Div Data Provider Double")
    public Object[][] divDataProviderDouble() {
        return new Object[][] {
                {new double[]{9.9, 3.3}, 3.0},
                {new double[]{0.0, 6.9}, 0.0},
                {new double[]{3.5, 0.0}, 0},
                {new double[]{-4.5, 4.5}, -1}
        };
    }

    @DataProvider(name = "Pow Data Provider")
    public Object[][] powDataProvider() {
        return new Object[][] {
                {new double[]{2.1, 1.0}, 2.1},
                {new double[]{9.3, 0.0}, 1.0},
                {new double[]{4.0, 2.0}, 16.0},
                {new double[]{2.0, -2.0}, 0.25}
        };
    }

    @DataProvider(name = "Sqrt Data Provider")
    public Object[][] sqrtDataProvider() {
        return new Object[][] {
                {9.0, 3.0},
                {0.0, 0.0},
                {-1.0, 1.0}
        };
    }

    @DataProvider(name = "Tg Data Provider")
    public Object[][] tgDataProvider() {
        return new Object[][] {
                {0.0, 0.0},
                {45 * Math.PI / 180, 1.0},
                {Math.PI, 0.0},
                {135 * Math.PI / 180, -1.0},
                {2 * Math.PI, 0.0}
        };
    }

    @DataProvider(name = "Ctg Data Provider")
    public Object[][] ctgDataProvider() {
        return new Object[][] {
                {45 * Math.PI / 180, 1.0},
                {Math.PI / 2, 0.0},
                {135 * Math.PI / 180, -1.0}
        };
    }

    @DataProvider(name = "Cos Data Provider")
    public Object[][] cosDataProvider() {
        return new Object[][] {
                {0.0, 1.0},
                {Math.PI / 3, 0.5},
                {Math.PI, -1.0}
        };
    }

    @DataProvider(name = "Sin Data Provider")
    public Object[][] sinDataProvider() {
        return new Object[][] {
                {0.0, 0.0},
                {Math.PI / 2, 1.0},
                {Math.PI / 6, 0.5}
        };
    }

    @DataProvider(name = "Is Positive Data Provider")
    public Object[][] isPositiveDataProvider() {
        return new Object[][] {
                {0, false},
                {1, true},
                {-1, false}
        };
    }

    @DataProvider(name = "Is Negative Data Provider")
    public Object[][] isNegativeDataProvider() {
        return new Object[][] {
                {0, false},
                {1, false},
                {-1, true}
        };
    }
}
