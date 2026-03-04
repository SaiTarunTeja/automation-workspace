package day7_timeoutAndExpectedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TimeOutAttribute_ExpectedCondition_Test {

	@Test(timeOut = 2000)
	public void m1() {
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://google.com/");
		webDriver.quit();

	}
	
	@Test()
	public void m2() {
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://google.com/");
		webDriver.quit();

	}
	
	@Test(expectedExceptions = {ArrayIndexOutOfBoundsException.class})
	public void m3() {
		//test fails because we must expect ArithmeticException when some number divisible by zero
		//or you can expect Exception.class to pass this test
		System.out.println(1/0);

	}
}
