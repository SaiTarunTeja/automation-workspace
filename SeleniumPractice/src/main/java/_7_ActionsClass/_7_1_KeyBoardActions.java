package _7_ActionsClass;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _7_1_KeyBoardActions {
	static WebDriver webDriver ;
	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		webDriver.manage().window().maximize();
		
		//hoverAction_MoveToElement();
		//contextClick_DoubleClick();
		//dragAndDrop();
		//contextClick_rightClick();
		horizontalSlider();
		
		webDriver.quit();
	}

	public static void hoverAction_MoveToElement() {
		Actions actions = new Actions(webDriver);
		
		File file = new File("src/main/resources/SeleniumMouseActionsDemo.html");
		webDriver.get(file.toURI().toString());
		
		actions.moveToElement(webDriver.findElement(By.xpath("//a[normalize-space()='Products ▼']")))
		.moveToElement(webDriver.findElement(By.xpath("//a[contains(normalize-space(),'Electronics')]")))
		.moveToElement(webDriver.findElement(By.xpath("//a[contains(normalize-space(),'Mobiles')]")))
		.click()
		.perform();
		
		String selectedCategory = webDriver.findElement(By.xpath("//h2//span")).getText().trim();
		if("Mobiles".equals(selectedCategory)) {
			System.out.println("selected Mobiles Category");
		} else {
			System.out.println("Something went wrong");
		}
		
	}
	
	public static void doubleClick() {
		Actions actions = new Actions(webDriver);
		
		File file = new File("src/main/resources/SeleniumMouseActionsDemo.html");
		webDriver.get(file.toURI().toString());
		
		actions.moveToElement(webDriver.findElement(By.xpath("//button[normalize-space()='Copy Text']")))
		.doubleClick()
		.perform();
	
		String field2Text = webDriver.findElement(By.xpath("//input[@id='field2']")).getAttribute("value").trim();
		
		if("Hello World!".equals(field2Text)) {
			System.out.println("Process Completed successfully");
		}else {
			System.out.println("Something went wrong");
		}
		
	}
	
	public static void dragAndDrop() {
		Actions actions = new Actions(webDriver);
		
		File file = new File("src/main/resources/SeleniumMouseActionsDemo.html");
		webDriver.get(file.toURI().toString());
		
		WebElement srcElement = webDriver.findElement(By.xpath("//h2[normalize-space()='Capitals']/following::div/div[normalize-space()='Delhi']"));
		WebElement trgElement = webDriver.findElement(By.xpath("//div[@class='countries']//div[normalize-space()='India']"));

		
		actions.dragAndDrop(srcElement, trgElement)
		.perform();
			
		
		
	}
	
	public static void contextClick_rightClick() {
		Actions actions = new Actions(webDriver);
		
		webDriver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		actions.moveToElement(webDriver.findElement(By.xpath("//span[normalize-space()='right click me']")))
		.contextClick()
		.perform();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		webDriver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();
		
		System.out.println(webDriver.switchTo().alert().getText());
		webDriver.switchTo().alert().accept();
	}
	
	public static void horizontalSlider() {
		
		
		webDriver.get("https://www.myntra.com/men-casual-wear");
		
		WebElement leftThumb = webDriver.findElement(By.id("rootRailThumbLeft"));
		WebElement rightThumb = webDriver.findElement(By.id("rootRailThumbRight"));

		int movePixels = 30; // negative = left, positive = right
		int moveleft = -50;
		
		Action movingLeftAction = new Actions(webDriver).clickAndHold(rightThumb).moveByOffset(moveleft, 0).release().build();

		new Actions(webDriver)
		    .clickAndHold(leftThumb)
		    .moveByOffset(movePixels, 0)
		    .release()
		    .perform();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		movingLeftAction.perform();
		
	}
}
