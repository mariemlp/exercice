package acial.selenium.exercices;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testB {
  @BeforeClass(alwaysRun = true)
  public void setUpClassB() throws Exception {
	  System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
  }
  @BeforeTest(alwaysRun = true)
  public void setUpTestB() throws Exception {
	  
	  System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
  }
  @Test
  public void test_B_1() throws Exception {
	  System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
  }
  @Test
  public void test_B_2() throws Exception {
	  System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
  }
  @AfterTest(alwaysRun = true)
  public void tearDownTestB() throws Exception {
	  System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
  }
  @AfterClass(alwaysRun = true)
  public void tearDownClassB() throws Exception {
	  System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
  }
}
