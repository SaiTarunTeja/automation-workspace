package day11_captureScreenShots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest2_ForDependecyInjection {
	public static WebDriver webDriver;

	@BeforeTest
	public void setUp() {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
	}

	@AfterMethod
	public void screenshotCapture(ITestResult result) {
		System.out.println("Test failed");
		if(result.getStatus() == ITestResult.FAILURE) {
			captureScreenshot(result.getTestContext().getName());
		}
	}

	
	@AfterTest
	public void tearDown() {
		webDriver.quit();
	}
	
	
	public void captureScreenshot(String fileName) {
		try {
			TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./Screenshots/"+fileName+".jpg");
			FileUtils.copyFile(sourceFile, destFile);
			System.out.println("Screenshot saved successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
