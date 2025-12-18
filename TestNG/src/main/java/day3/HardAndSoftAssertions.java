package day3;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAndSoftAssertions {
	
	@AfterMethod
	public void afterTest() {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$");
	}
	
	@Test
	public void hardAssertionsTest() {
		try {
			WebDriver webDriver = new ChromeDriver();
			webDriver.manage().window().maximize();
			webDriver.get("https://www.facebook.com/");
			webDriver.findElement(By.name("email")).sendKeys("123##321", Keys.ENTER);
			Thread.sleep(3000);
			
			//Title Assertion
			String actualTitle = webDriver.getTitle();
			String expectedTitle = "Log in to Facebook";
			assertEquals(actualTitle, expectedTitle, "Title is Mismatched");
			
			//url Assertion
			String actualUrl = webDriver.getCurrentUrl();
			String expectedUrl = "https://www.facebook.com/123";
			assertEquals(actualUrl, expectedUrl, "Url is Mismatched");
			
			//url Assertion
			String actualText = webDriver.findElement(By.name("email")).getAttribute("value");
			String expectedText = "";
			assertEquals(actualText, expectedText, "userName text is Mismatched");
			
			//border Assertion
			String actualBorderColour = webDriver.findElement(By.name("email")).getCssValue("border");
			String expectedBorderColour = "1px solid rgb(240, 40, 73)";
			assertEquals(actualBorderColour, expectedBorderColour, "Border is Mismatched");
			
			//error Message Assertion
			String actualErrorMsg = webDriver.findElement(By.xpath("(//div[@id='email_container']/div)[last()]")).getText();
			String expectedErrorMsg = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
			assertEquals(actualErrorMsg, expectedErrorMsg, "ErrorMsg is Mismatched");
			
			webDriver.quit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void softAssertionsTest() {
		try {
			WebDriver webDriver = new ChromeDriver();
			webDriver.manage().window().maximize();
			webDriver.get("https://www.facebook.com/");
			webDriver.findElement(By.name("email")).sendKeys("123##321", Keys.ENTER);
			Thread.sleep(3000);
			
			SoftAssert softAssert = new SoftAssert();
			//Title Assertion
			String actualTitle = webDriver.getTitle();
			String expectedTitle = "Log in to Facebook";
			softAssert.assertEquals(actualTitle, expectedTitle, "Title is Mismatched");
			
			//url Assertion
			String actualUrl = webDriver.getCurrentUrl();
			String expectedUrl = "https://www.facebook.com/123";
			softAssert.assertEquals(actualUrl, expectedUrl, "Url is Mismatched");
			
			//url Assertion
			String actualText = webDriver.findElement(By.name("email")).getAttribute("value");
			String expectedText = "";
			softAssert.assertEquals(actualText, expectedText, "userName text is Mismatched");
			
			//border Assertion
			String actualBorderColour = webDriver.findElement(By.name("email")).getCssValue("border");
			String expectedBorderColour = "1px solid rgb(240, 40, 73)";
			softAssert.assertEquals(actualBorderColour, expectedBorderColour, "Border is Mismatched");
			
			//error Message Assertion
			String actualErrorMsg = webDriver.findElement(By.xpath("(//div[@id='email_container']/div)[last()]")).getText();
			String expectedErrorMsg = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
			softAssert.assertEquals(actualErrorMsg, expectedErrorMsg, "ErrorMsg is Mismatched");
			
			
			webDriver.quit();
			
			softAssert.assertAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
