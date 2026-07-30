package _11_options;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _11_1_Headless_ChromeOptions {

	public static void main(String[] args) {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless=new");
		WebDriver webDriver = new ChromeDriver(chromeOptions);
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		webDriver.manage().window().maximize();
		
		webDriver.get("https://testautomationpractice.blogspot.com/");
		if(webDriver.getTitle()!=null) {
			System.out.println("Test pass");
		}else {
			System.out.println("Test fail");
		}
		
		WebElement tableWebElement = webDriver.findElement(By.id("HTML8"));
		File srcFile = tableWebElement.getScreenshotAs(OutputType.FILE);
		File trgFile = new File(System.getProperty("user.dir")+"\\screenshots\\webElementSCR.png");
		srcFile.renameTo(trgFile);

		
		webDriver.quit();
	}
	
	

}
