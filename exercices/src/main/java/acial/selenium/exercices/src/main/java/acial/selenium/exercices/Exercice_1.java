package acial.selenium.exercices;


import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercice_1 {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
     System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Admloc\\eclipse-workspace"); 
       driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLoginLogout() throws Exception {
	driver.get("http://universitedutest.com/OrangeHRM/");
	driver.findElement(By.id("txtUsername")).clear();
    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    driver.findElement(By.id("txtPassword")).clear();
    driver.findElement(By.id("txtPassword")).sendKeys("Nantes$2020");
    driver.findElement(By.id("btnLogin")).click();
    try {
      assertEquals(driver.findElement(By.id("welcome")).getText(), "Welcome Admin");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("welcome")).click();
    driver.findElement(By.linkText("Déconnexion")).click();
  }

  @Test
  public void testAjouterEmploye2() throws Exception {
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Social Media Authentication'])[1]/following::b[1]")).click();
    driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
    driver.findElement(By.id("btnAdd")).click();
    driver.findElement(By.id("firstName")).click();
    driver.findElement(By.id("firstName")).clear();
    driver.findElement(By.id("firstName")).sendKeys("germaine");
    driver.findElement(By.id("lastName")).click();
    driver.findElement(By.id("lastName")).clear();
    driver.findElement(By.id("lastName")).sendKeys("touto");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[2]/following::li[1]")).click();
    driver.findElement(By.id("employeeId")).clear();
    driver.findElement(By.id("employeeId")).sendKeys("3200");
    driver.findElement(By.id("btnSave")).click();
    driver.findElement(By.id("btnSave")).click();
    driver.findElement(By.id("personal_optGender_2")).click();
    driver.findElement(By.id("personal_cmbMarital")).click();
    new Select(driver.findElement(By.id("personal_cmbMarital"))).selectByVisibleText("Autre");
    driver.findElement(By.id("personal_cmbMarital")).click();
    driver.findElement(By.id("personal_DOB")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Next'])[1]/following::select[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Next'])[1]/following::select[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Next'])[1]/following::select[2]")).click();
    driver.findElement(By.linkText("17")).click();
    driver.findElement(By.id("btnSave")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
