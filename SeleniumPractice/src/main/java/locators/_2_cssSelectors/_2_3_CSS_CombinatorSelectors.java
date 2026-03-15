package locators._2_cssSelectors;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_3_CSS_CombinatorSelectors {

	public static void main(String[] args) {
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://www.hyrtutorials.com/p/css-selectors-practice.html");
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//DecendentSelector
		System.out.println(webDriver.findElements(By.cssSelector(".container select")).size());
		
		//Child Selector
		System.out.println(webDriver.findElements(By.cssSelector(".container>select")).size());
		System.out.println(webDriver.findElements(By.cssSelector(".container>div>select")).size());
		
		/*
		 <div>
		 	<label>
		 	<input name='userName'/>
		 	<input name='fatherName'/>
		 <div>
		 
		 */
		
		//Adjacemt sibling selector
		//userName is adjacent sibling for label  
		System.out.println(webDriver.findElements(By.cssSelector("input[placeholder='Verify your personal details']+select")).size());
		
		//General Sibling
		//  both input tags are siblings for label tag which is called General Sibling
		System.out.println(webDriver.findElements(By.cssSelector("input[placeholder='Verify your personal details']~a")).size());
		
		webDriver.quit();
	}

}
