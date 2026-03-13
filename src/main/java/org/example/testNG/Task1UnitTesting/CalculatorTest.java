package org.example.testNG.Task1UnitTesting;

import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(CustomListener.class)
public class CalculatorTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeMethod running in thread: " + Thread.currentThread().getName());
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }

    @Test(groups = "positive")
    public void testAddPositive() {
        Assert.assertEquals(calculator.add(2, 3), 5);
    }

    @Test(groups = "positive")
    public void testSubtractPositive() {
        Assert.assertEquals(calculator.subtract(5, 3), 2);
    }

    @Test(groups = "positive")
    public void testMultiplyPositive() {
        Assert.assertEquals(calculator.multiply(2, 3), 6);
    }

    @Test(groups = "positive")
    public void testDividePositive() {
        Assert.assertEquals(calculator.divide(6, 3), 2);
    }

    @Test(groups = "positive")
    public void testPowerPositive() {
        Assert.assertEquals(calculator.power(2, 3), 8);
    }

    // Negative tests
    @Test(groups = "negative", expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(5, 0);
    }

    @Test(groups = "negative")
    public void testAddNegative() {
        Assert.assertNotEquals(calculator.add(2, 2), 5);
    }

    @Test(groups = "negative")
    public void testSubtractNegative() {
        Assert.assertNotEquals(calculator.subtract(5, 3), 1);
    }

    @Test(groups = "negative")
    public void testMultiplyNegative() {
        Assert.assertNotEquals(calculator.multiply(2, 3), 5);
    }

    @Test(groups = "negative")
    public void testPowerNegative() {
        Assert.assertNotEquals(calculator.power(2, 3), 7);
    }

    // Parameterized test
    @Test(dataProvider = "addDataProvider")
    public void testAddParameterized(int a, int b, int expected) {
        Assert.assertEquals(calculator.add(a, b), expected);
    }

    @DataProvider(name = "addDataProvider")
    public Object[][] addDataProvider() {
        return new Object[][] {
                {1, 2, 3},
                {0, 0, 0},
                {-1, 1, 0},
                {100, 200, 300}
        };
    }
}
