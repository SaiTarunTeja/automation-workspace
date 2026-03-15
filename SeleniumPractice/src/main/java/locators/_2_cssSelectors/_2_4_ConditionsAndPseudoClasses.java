package locators._2_cssSelectors;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_4_ConditionsAndPseudoClasses {

	static WebDriver webDriver;

	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		webDriver.get("https://www.hyrtutorials.com/p/css-selectors-practice.html");
		
		cssSelectors_Condition();
		System.out.println("=========");
		cssSelectors_PsudoClasses();
		
		webDriver.quit();

	}

	public static void cssSelectors_Condition() {
		

		// and condition
		System.out.println(webDriver.findElements(By.cssSelector("input[class='button'][type='submit'")).size());

		// or condition
		System.out.println(
				webDriver.findElements(By.cssSelector("button,input[type='button'],input[type='submit']")).size());

		// not condition
		System.out.println(webDriver.findElements(By.cssSelector("input.button:not([type='submit'])")).size());
	}
	
	public static void cssSelectors_PsudoClasses() {
		webDriver.get("https://www.hyrtutorials.com/p/css-selectors-practice.html");

		// first child
		System.out.println(webDriver.findElements(By.cssSelector(".container>:first-child")).size());

		// last child
		System.out.println(
				webDriver.findElements(By.cssSelector(".container>:last-child")).size());

		// nth child
		System.out.println(webDriver.findElements(By.cssSelector(".container>:nth-child(7)")).size());
		
		//first-of-type
		System.out.println(webDriver.findElements(By.cssSelector(".container>br:first-of-type")).size());
		
		//last-of-type
				System.out.println(webDriver.findElements(By.cssSelector(".container>br:last-of-type")).size());
				
				//nth-of-type
				System.out.println(webDriver.findElements(By.cssSelector(".container>br:nth-of-type(3)")).size());
		
	}

	
}
