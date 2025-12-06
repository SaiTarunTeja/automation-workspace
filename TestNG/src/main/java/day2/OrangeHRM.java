package day2;

import org.testng.ITestContext;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeHRM {
	
	@BeforeTest
    public void beforeTest(ITestContext context) {
        System.out.println("Test Name: " + context.getName()+"++++++=");
    }
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("====================================");
	}
	
	@Test
	public void LaunchApp() {
		System.out.println("App launched Successfully");
	}
	
	@Test
	public void EnterLoginDetails() {
		System.out.println("Entered to login Details Successfully");
	}
	
	@Test
	public void NavigateToMyInfo() {
		System.out.println("NavigateToMyInfo");
	}
	
	@Test
	public void VerifyMyInfo() {
		System.out.println("VerifyMyInfo");
	}
	
	@Test
	public void VerifyLogin() {
		System.out.println("VerifyLogin");
	}
}