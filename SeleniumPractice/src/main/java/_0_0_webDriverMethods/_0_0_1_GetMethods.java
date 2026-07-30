package _0_0_webDriverMethods;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _0_0_1_GetMethods {
	public static void main(String[] args) {
		WebDriver webDriver = new ChromeDriver();
		
		//get --> to Open Url on broswer
		webDriver.get("https://testautomationpractice.blogspot.com/");
		
		//title of webPage
		String webPageTitle = webDriver.getTitle();
				
		//url of webPage
		String currentUrl = webDriver.getCurrentUrl();
		
		//Window Handles
		String windowHandle = webDriver.getWindowHandle();
		Set<String> windowHandles = webDriver.getWindowHandles();
		
		//PageSource
		String pageSource = webDriver.getPageSource();
		
		System.out.println("webPage Title ==> "+webPageTitle);
		System.out.println("current URL ==> "+currentUrl);
		System.out.println("window Handle ==> "+windowHandle);
		System.out.println("window Handles ==> "+windowHandles);
		System.out.println("PageSource ==> "+pageSource);
		

		webDriver.quit();
	}
}
