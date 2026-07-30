package _7_ActionsClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _7_3_HandlingMultipleWindows {

	static WebDriver webDriver;
	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		webDriver.manage().window().maximize();
		
		openLonginPageInNewTab();
	}
	
	public static void openLonginPageInNewTab() {
		webDriver.get("https://www.flipkart.com/");

		
		WebElement loginLink = webDriver.findElement(
			    By.xpath("//a[.//span[text()='Login']]")
			);

			loginLink.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
		
		List<String> windowHandles = new ArrayList<String>(webDriver.getWindowHandles());
		
		
		
		webDriver.switchTo().window(windowHandles.get(1));
		sleep(5000);
		webDriver.findElement(By.xpath("//span[contains(text(), 'Mobile number')]/parent::label/preceding-sibling::input")).sendKeys("5464747");
		
		webDriver.switchTo().window(windowHandles.get(0));
	}
	
	public static void sleep(long waitMills) {
		try {
			Thread.sleep(waitMills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
