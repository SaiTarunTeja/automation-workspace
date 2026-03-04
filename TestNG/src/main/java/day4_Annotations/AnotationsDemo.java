package day4_Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnotationsDemo {

	@Test
	public void testMethod1() {
		System.out.println("TestMethod1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("TestMethod2");
	}
	
	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("BeforeTestMethod");
	}
	
	@AfterTest
	public void afterTestMethod() {
		System.out.println("AfterTestMethod");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("AfterCLass");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite");
	}
	
	@AfterSuite
	public void AFterSuite() {
		System.out.println("AfterSuite");
	}
}
