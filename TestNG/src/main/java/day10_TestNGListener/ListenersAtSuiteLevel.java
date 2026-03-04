package day10_TestNGListener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class ListenersAtSuiteLevel {

	@Test
	  public void m1() {
		  System.out.println("ListenersAtSuiteLevel -- m1 -- ");
	  }
	  
	  @Test
	  public void m2() {
		  System.out.println("ListenersAtSuiteLevel -- m2 -- ");
		  Assert.assertTrue(false);
	  }
	  
	  @Test(timeOut=2000)
	  public void m3() {
		  try {
			Thread.sleep(3000);
		  } catch (InterruptedException e) {
			e.printStackTrace();
		  }
		  System.out.println("ListenersAtSuiteLevel -- m3 -- ");
		  
	  }
	  
	  @Test(dependsOnMethods = "m3")
	  public void m4() {
		  System.out.println("ListenersAtSuiteLevel -- m4 -- ");
	  }
}
