package locators._1_basicLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLocators {
	public static void main(String[] args) {
		seleniumBasicLocator();
	}
	
	public static void seleniumBasicLocator() {
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://github.com/login");
		
		sleep(3000);
		highlight(webDriver, webDriver.findElement(By.xpath("//span[text()='Sign in with a passkey']")));
		
		//id
		sleep(3000);
		highlight(webDriver, webDriver.findElement(By.id("add_account")));
		
		//name
		sleep(3000);
		highlight(webDriver, webDriver.findElement(By.name("password")));
		
		//className
		sleep(3000);
		highlight(webDriver, webDriver.findElement(By.className("authentication-login-footer-links")));
		
		//webDriver.findElement(By.)
		//linkText
		sleep(3000);
		highlight(webDriver, webDriver.findElement(By.linkText("Forgot password?")));
		
		//PartialLinkText
		sleep(3000);
		highlight(webDriver, webDriver.findElement(By.partialLinkText("Create an acc")));
		
		//tagName
		sleep(3000);
		highlight(webDriver, webDriver.findElement(By.tagName("h1")));
		
		//xpath
		sleep(3000);
		highlight(webDriver, webDriver.findElement(By.xpath("//label[contains(text(), 'Username or email address')]")));
		
		//css selector
		sleep(3000);
		highlight(webDriver, webDriver.findElement(By.cssSelector("input[name='commit']")));
	}
	
	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}
	
	public static void sleep(long sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
