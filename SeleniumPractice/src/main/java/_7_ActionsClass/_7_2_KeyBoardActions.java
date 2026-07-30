package _7_ActionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _7_2_KeyBoardActions {

	static WebDriver webDriver;
	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		
		KeyBoardAct();

	}
	
	public static void KeyBoardAct() {
		webDriver.get("https://text-compare.com/");
		Actions actions = new Actions(webDriver);
		
		webDriver.findElement(By.id("inputText1")).sendKeys("Welcome");
		actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		actions.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		actions.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		actions .keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
	}

}
