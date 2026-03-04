package day11_captureScreenShots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	public static WebDriver webDriver;

	@BeforeTest
	public void setUp() {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
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
