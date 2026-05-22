package _3_textBoxes;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_HandlingTextboxes {

	public static void main(String[] args) {
		handlingTextboxes();
	}
	
	public static void handlingTextboxes() {
		System.out.println("Enter UserId");
		Scanner scanner = new Scanner(System.in);
		String userId = scanner.nextLine();
		scanner.close();
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			
			webDriver.get("https://github.com/login");
			
			WebElement txtUserId = webDriver.findElement(By.id("login_field"));
			
			sleep(3000);
			//to verify userId textbox displayed or not
			if(txtUserId.isDisplayed()) {
				//to verify user id text box is enabled or not 
				if(txtUserId.isEnabled()) {
					txtUserId.sendKeys(userId);
					
					//printing entered value 
					String enteredValue = txtUserId.getAttribute("value");
					System.out.println(enteredValue);
					
					sleep(3000);
					
					//to clear existing text in the text box
					txtUserId.clear();
					
					sleep(3000);
					
				}else {
					System.err.println("user id is not enabled");
				}
			}else {
				System.err.println("user id test box is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			webDriver.close();
		}
		
	}
	
	public static void sleep(long waitTimeInSeconds) {
		try {
			Thread.sleep(waitTimeInSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
