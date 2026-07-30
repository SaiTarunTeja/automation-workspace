package _4_dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _4_4_HiddenDropdowns {
	static WebDriver webDriver;
	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		hiddenddlOrangeHRM();
		
		webDriver.quit();
	}
	public static void hiddenddlOrangeHRM() {
		webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		webDriver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		webDriver.findElement(By.xpath("//button[@type='submit']")).click();
		
		webDriver.findElement(By.xpath("//span[text()='PIM']")).click();
		webDriver.findElement(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div//div[text()='-- Select --']")).click();
		
		List<WebElement> ddlOptions = webDriver.findElements(By.xpath("//div[@role='listbox']//span"));
		System.out.println("total elements: "+ddlOptions.size());
		for(WebElement webElement: ddlOptions) {
			System.out.println(webElement.getText());
		}
		
		webDriver.findElement(By.xpath("//div//span[normalize-space()='QA Lead']")).click();
	}
}
