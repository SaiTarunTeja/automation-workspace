package _8_JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _8_2_ScrollUsingJavascriptExecutor {

	static WebDriver webDriver;
	static JavascriptExecutor executor;
	public static void main(String[] args) {
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		webDriver.manage().window().maximize();
		
		executor = (JavascriptExecutor) webDriver;
		
		webDriver.get("https://testautomationpractice.blogspot.com/");
		//scrollToPixels();
		
		//WebElement shadowDomWebElement = webDriver.findElement(By.xpath("//h2[.='ShadowDOM']"));
		//scrollTillElementVisible(shadowDomWebElement);
		
		scrollTillEndOfPage();
		sleep(5000);
		scrollTillStartOfPage();
		System.out.println(executor.executeScript("return window.pageYOffset;"));
	}
	
	public static void scrollToPixels() {
		executor.executeScript("window.scrollBy(0, 3000)", "");
	}
	
	public static void scrollTillElementVisible(WebElement webElement) {
		executor.executeScript("arguments[0].scrollIntoView()", webElement);		
	}
	
	public static void scrollTillEndOfPage() {
		executor.executeScript("window.scrollBy(0, document.body.scrollHeight)");		
	}
	
	public static void scrollTillStartOfPage() {
		executor.executeScript("window.scrollBy(0, -document.body.scrollHeight)");		
	}
	
	public static void sleep(long waitTimeSeconds) {
		try {
			Thread.sleep(waitTimeSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
