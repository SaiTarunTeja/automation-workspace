package day9_invoation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Invocation_1 {

//	@Test(invocationCount = 2)
//	public void m1() {
//		WebDriver webDriver = new ChromeDriver();
//		webDriver.get("https://randomuser.me/");
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		webDriver.findElement(By.xpath("//li[@data-label='name']")).click();
//		System.out.println(webDriver.findElement(By.id("user_value")).getText());
//		
//		webDriver.findElement(By.xpath("//li[@data-label='email']")).click();
//		System.out.println(webDriver.findElement(By.id("user_value")).getText());
//		webDriver.quit();
//		
//	}
	
//	@Test(invocationCount = 2, invocationTimeOut = 10000)
//	public void m2() {
//		WebDriver webDriver = new ChromeDriver();
//		webDriver.get("https://randomuser.me/");
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		webDriver.findElement(By.xpath("//li[@data-label='name']")).click();
//		System.out.println(webDriver.findElement(By.id("user_value")).getText());
//		
//		webDriver.findElement(By.xpath("//li[@data-label='email']")).click();
//		System.out.println(webDriver.findElement(By.id("user_value")).getText());
//		webDriver.quit();
//		
//	}
	
	@Test(invocationCount = 4, threadPoolSize = 2)
	public void m2() {
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://randomuser.me/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webDriver.findElement(By.xpath("//li[@data-label='name']")).click();
		System.out.println(webDriver.findElement(By.id("user_value")).getText());
		
		webDriver.findElement(By.xpath("//li[@data-label='email']")).click();
		System.out.println(webDriver.findElement(By.id("user_value")).getText());
		webDriver.quit();
		
	}
}
