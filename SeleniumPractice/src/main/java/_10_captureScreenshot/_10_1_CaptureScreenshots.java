package _10_captureScreenshot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _10_1_CaptureScreenshots {

	static WebDriver webDriver;
	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		webDriver.manage().window().maximize();
		
		//captureFullPageScreenshot();
		CaptureSpecificWebElementScreenshot();
		webDriver.quit();

	}
	
	public static void captureFullPageScreenshot() {
		webDriver.get("https://testautomationpractice.blogspot.com/");
		
		TakesScreenshot takesScreenshot = (TakesScreenshot)webDriver;
		File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File trgFile = new File(System.getProperty("user.dir")+"\\screenshots\\fullPageSCR.png");
		srcFile.renameTo(trgFile);
	}
	
	public static void CaptureSpecificWebElementScreenshot() {
		webDriver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement tableWebElement = webDriver.findElement(By.id("HTML8"));
		File srcFile = tableWebElement.getScreenshotAs(OutputType.FILE);
		File trgFile = new File(System.getProperty("user.dir")+"\\screenshots\\webElementSCR.png");
		srcFile.renameTo(trgFile);
	}

}
