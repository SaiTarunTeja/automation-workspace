package _8_JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _8_1_ClickAndSendKeysUsingJavaScriptExecutor {

	static WebDriver webDriver;
	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		webDriver.manage().window().maximize();
		
		webDriver.get("https://testautomationpractice.blogspot.com/");
		WebElement nameWebElement = webDriver.findElement(By.id("name"));
		
		sendKeysUsingJS(nameWebElement, "Ravi");

		WebElement rad_male = webDriver.findElement(By.id("male"));
		clickUsingJs(rad_male);
		
		//webDriver.quit();
	}
	
	public static void sendKeysUsingJS(WebElement webElement, String textToBeEnter) {
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		//executor.executeScript("arguments[0].setAttribute('value', arguments[1])", webElement, textToBeEnter);
		executor.executeScript("arguments[0].value=arguments[1]", webElement, textToBeEnter);
	}
	
	public static void clickUsingJs(WebElement webElement) {
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		executor.executeScript("arguments[0].click()", webElement);
	}
}
