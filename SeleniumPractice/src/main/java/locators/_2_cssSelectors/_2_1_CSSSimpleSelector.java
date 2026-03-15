package locators._2_cssSelectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_1_CSSSimpleSelector {

	public static void main(String[] args) {
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://www.hyrtutorials.com/p/css-selectors-practice.html");
		webDriver.manage().window().maximize();
		
		//css simple element selector
		System.out.println(webDriver.findElement(By.cssSelector("button")).getAttribute("id"));
		
		//css id selector
		webDriver.findElement(By.cssSelector("#firstName")).sendKeys("Tarun");
		
		//css class selector
		webDriver.findElement(By.cssSelector(".gender")).sendKeys("male");
		
		//css universal selector
		System.out.println(webDriver.findElements(By.cssSelector("*")).size());
		
		webDriver.quit();
	}
	
	
}
