package day3;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssertionsPractice {

    private final Random random = new Random(); // Reuse Random instance

    //@Test
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

    //@Test
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

    //@Test
    public void booleanAssertionOverloads() {

    	Reporter.log("========= BooleanAssertions Test Started ============", true);
        boolean isUserLoggedIn = true;
        boolean isAdmin = false;

        // Overload 1: without message
        Assert.assertTrue(isUserLoggedIn);
        Assert.assertFalse(isAdmin);

        // Overload 2: with custom message
        Assert.assertTrue(isUserLoggedIn, "User should be logged in");
        Assert.assertFalse(isAdmin, "User should not have admin access");
        Reporter.log("============= Boolean Assertions Ended ===============", true);
    }
    
   // @Test
    public void nullAssertionOverloads() {

    	Reporter.log("========= nullnAssertions Test Started ============", true);

        // Overload 1: without message
        Assert.assertNull(null);
        Assert.assertNotNull("");

        // Overload 2: with custom message
        Assert.assertNull(null, "assert is null");
        Assert.assertNotNull("", "Assert is not null");
        Reporter.log("============= null Assertions Ended ===============", true);
    }
    
    @Test
    public void assertSameOverloads() {
        Reporter.log("========= assertSame Test Started ============", true);
        Reporter.log("========= assertSame compares object reference, not content ============", true);

        String actual = new String("Tarun");
        String expected = actual;
        String expectedForNotSame = new String("Tarun");

        // Without message
        Assert.assertSame(actual, expected);              // Pass
        Assert.assertNotSame(actual, expectedForNotSame); // Pass

        // With custom message (optional try-catch to continue execution) but try catch are not recomended in real time
		
        /*
		 * Do NOT use try-catch for normal assertions.
		 * Use assertSame, assertNotSame, or assertEquals directly.
		 * Let TestNG handle failures and report them properly.
		 */
        
        try {
            Assert.assertSame(actual, expectedForNotSame, "Fail: actual and expected should point to the same object");
        } catch (AssertionError e) {
            e.printStackTrace();
        }

        try {
            Assert.assertNotSame(actual, expected, "Fail: actual and expectedForNotSame should point to different objects");
        } catch (AssertionError e) {
            e.printStackTrace();
        }

        // Value check
        Assert.assertEquals(actual, expectedForNotSame, "Content is same, so assertEquals passes");

        Reporter.log("============= assertSame Test Ended ===============", true);
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
    
    public String generatePalindrome(int numberOfCharacters) {
    	if(numberOfCharacters<=0) {
    		return "Please enter valid Number greater than 0";
    	}
    	
    	String alphabets="abcdefghijklmnopqrstuvwxyz";
    	char[] palindrome = new char[numberOfCharacters];
    	ThreadLocalRandom random = ThreadLocalRandom.current();
    	
    	for(int i=0;i<numberOfCharacters/2;i++) {
    		char ch= alphabets.charAt(random.nextInt(alphabets.length()));
    		palindrome[i]=ch;
    		palindrome[numberOfCharacters-i-1]=ch;
    	}
    	
    	//to handle the odd numberOfCharacters
    	if(numberOfCharacters%2!=0) {
    		palindrome[numberOfCharacters/2]=alphabets.charAt(random.nextInt(alphabets.length()));
    	}
    	return new String(palindrome);
    }
    
    public String generatePalindrome() {
    	return generatePalindrome(ThreadLocalRandom.current().nextInt(3, 10));
    }
    
}
