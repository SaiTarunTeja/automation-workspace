package _11_options;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _11_2_HandlindSSL_ChromeOptions {

	public static void main(String[] args) {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setAcceptInsecureCerts(true);
		WebDriver webDriver = new ChromeDriver(chromeOptions);
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		webDriver.manage().window().maximize();
		
		webDriver.get("https://expired.badssl.com/");
		if(webDriver.getTitle()!=null) {
			System.out.println("Test pass");
		}else {
			System.out.println("Test fail");
		}
		
		
		
		webDriver.quit();
	}
	
	

}
