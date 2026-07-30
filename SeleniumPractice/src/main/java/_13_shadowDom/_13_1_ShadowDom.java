package _13_shadowDom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _13_1_ShadowDom {
	static WebDriver webDriver;

	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		webDriver.manage().window().maximize();
		shadowDomExample1();
		webDriver.quit();

	}
	
	public static void shadowDomExample1() {
		webDriver.get("https://dev.automationtesting.in/shadow-dom");
		
		//first shadow element
		SearchContext parentShadowRoot= webDriver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		WebElement firstShadowElement = parentShadowRoot.findElement(By.id("shadow-element"));
		System.out.println("Test of first shadow element: "+firstShadowElement.getText());
		
		//inner shadow element
		
//		SearchContext innerShadowRoot = parentShadowRoot.findElement(By.id("inner-shadow-dom")).getShadowRoot();
//		WebElement innershadowElement = innerShadowRoot.findElement(By.id("nested-shadow-element"));
//		System.out.println("inner shadow text: "+innershadowElement.getText());
		
		WebElement innerShadowHost = parentShadowRoot.findElement(By.cssSelector("inner-shadow-dom"));
		SearchContext innerShadowRoot = innerShadowHost.getShadowRoot();
		WebElement innershadowElement = innerShadowRoot.findElement(By.id("nested-shadow-element"));
		System.out.println("inner shadow text: "+innershadowElement.getText());
		
		//multi nested shadow element
		WebElement nestedShadowHost = innerShadowRoot.findElement(By.cssSelector("nested-shadow-dom"));
		SearchContext nestedShadowRoot = nestedShadowHost.getShadowRoot();
		WebElement nestedShadowRootElement = nestedShadowRoot.findElement(By.id("multi-nested-shadow-element"));
		System.out.println("Nested shadow Element Text: "+nestedShadowRootElement.getText());
	}

}
