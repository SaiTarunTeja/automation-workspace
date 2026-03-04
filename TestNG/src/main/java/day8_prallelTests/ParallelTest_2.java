package day8_prallelTests;

import org.testng.annotations.Test;

public class ParallelTest_2 {
  @Test
  public void m1() {
	  System.out.println("ParallelTest_2 -- m1 -- "+Thread.currentThread().getId());
  }
  
  @Test
  public void m2() {
	  System.out.println("ParallelTest_2 -- m2 -- "+Thread.currentThread().getId());
  }
  
  @Test
  public void m3() {
	  System.out.println("ParallelTest_2 -- m3 -- "+Thread.currentThread().getId());
  }
  
  @Test
  public void m4() {
	  System.out.println("ParallelTest_2 -- m4 -- "+Thread.currentThread().getId());
  }
}
