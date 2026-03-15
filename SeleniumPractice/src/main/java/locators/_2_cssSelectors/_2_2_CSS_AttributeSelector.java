package locators._2_cssSelectors;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_2_CSS_AttributeSelector {

	public static void main(String[] args) {
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://www.hyrtutorials.com/p/css-selectors-practice.html");
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//AttributeName
		System.out.println(webDriver.findElements(By.cssSelector("input[placeholder]")).size());
		
		//AttributeValue
		webDriver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("Tarun");
		
		//AttributeValue-PartialText-Text-WholeWord 
		webDriver.findElement(By.cssSelector("input[placeholder~='question']")).sendKeys("what is your best friend Name?");
		
		//AttributeValue-PartialText-Text-text 
		webDriver.findElement(By.cssSelector("input[placeholder*='ans']")).sendKeys("Mahesh");

		//AttributeValue-StartsWith-WholeWord
		System.out.println(webDriver.findElements(By.cssSelector("p[class|='my']")).size());
		
		//AttributeValue-StartsWith-Text
		System.out.println(webDriver.findElements(By.cssSelector("p[class^='my']")).size());
		
		//AttributeValue-EndsWith-Text
		System.out.println(webDriver.findElements(By.cssSelector("p[class$='lass']")).size());
		
		webDriver.quit();
	}

}
