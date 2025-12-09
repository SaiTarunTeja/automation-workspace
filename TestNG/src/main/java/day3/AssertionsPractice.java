package day3;

import java.util.Arrays;
import java.util.Random;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssertionsPractice {

    private final Random random = new Random(); // Reuse Random instance

    @Test
    public void equalityAssertions() {
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);
        int expected = num1 + num2;
        int actual = add(num1, num2);

        logAndAssertEquals("assertEquals(actual, expected)", actual, expected);
        logAndAssertEquals("assertEquals(actual, expected, message)", actual, expected,
                "actual and expected both are equal");

        String[] actualArr = { "b", "a", "c" };
        String[] expectedArr = { "a", "b", "c" };

        logAndAssertEqualsNoOrder("assertEqualsNoOrder(actualArray, expectedArray)", actualArr, expectedArr);
        logAndAssertEqualsNoOrder("assertEqualsNoOrder(actualArray, expectedArray, msg)", actualArr, expectedArr,
                "Both actual and expected are Equal");

        System.out.println("====================================");
    }

    @Test
    public void notEqualityAssertions() {
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);
        int expected = num1 + num2 + 1; // intentionally different
        int actual = add(num1, num2);

        logAndAssertNotEquals("assertNotEquals(actual, expected)", actual, expected);
        logAndAssertNotEquals("assertNotEquals(actual, expected, message)", actual, expected,
                "actual and expected both are not equal");

        String[] actualArr = { "b", "a", "c" };
        String[] expectedArr = { "a", "b", "c" };

        // Case: arrays expected to be different
        assertArraysNotEqual(actualArr, expectedArr);
    }

    // ----------------- Helper Methods -----------------

    private void logAndAssertEquals(String methodType, Object actual, Object expected) {
        Assert.assertEquals(actual, expected);
        Reporter.log(formatter(methodType, actual, expected), true);
    }

    private void logAndAssertEquals(String methodType, Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, message);
        Reporter.log(formatter(methodType, actual, expected, message), true);
    }

    private void logAndAssertNotEquals(String methodType, Object actual, Object expected) {
        Assert.assertNotEquals(actual, expected);
        Reporter.log(formatter(methodType, actual, expected), true);
    }

    private void logAndAssertNotEquals(String methodType, Object actual, Object expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
        Reporter.log(formatter(methodType, actual, expected, message), true);
    }

    private void logAndAssertEqualsNoOrder(String methodType, Object[] actualArr, Object[] expectedArr) {
        Assert.assertEqualsNoOrder(actualArr, expectedArr);
        Reporter.log(formatter(methodType, Arrays.toString(actualArr), Arrays.toString(expectedArr)), true);
    }

    private void logAndAssertEqualsNoOrder(String methodType, Object[] actualArr, Object[] expectedArr, String message) {
        Assert.assertEqualsNoOrder(actualArr, expectedArr, message);
        Reporter.log(formatter(methodType, Arrays.toString(actualArr), Arrays.toString(expectedArr), message), true);
    }

    private void assertArraysNotEqual(String[] actualArr, String[] expectedArr) {
        try {
            Assert.assertEqualsNoOrder(actualArr, expectedArr);
            Reporter.log("Arrays are equal but expected them to be different", true);
            Assert.fail("Arrays are equal but expected them to be different");
        } catch (AssertionError e) {
            Reporter.log("Arrays are NOT equal, as expected. Test passes.", true);
        }
        // Log arrays for reference
        Reporter.log(formatter("assertEqualsNoOrder(actualArray, expectedArray)", Arrays.toString(actualArr),
                Arrays.toString(expectedArr)), true);
    }

    // ----------------- Utility Methods -----------------

    private String formatter(String methodType, Object actual, Object expected) {
        return String.format("%s ==> Actual: %s%n           Expected: %s", methodType, actual, expected);
    }

    private String formatter(String methodType, Object actual, Object expected, String message) {
        return String.format("%s ==> %n%s%nActual: %s%nExpected: %s", methodType, message, actual, expected);
    }

    private int add(int num1, int num2) {
        return num1 + num2;
    }
}
