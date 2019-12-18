package acial.selenium.exercices;


import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Exercice4 {
  private WebDriver driver;
  WebDriverWait wait; 
  
  private String baseUrl;

  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  
  
  @DataProvider(name = "salaries")
  public Object[][] dataProviderMethod() {
      return new Object[][]  {
    		  {"Germaine","Touto","3200"},
    		  {"Robert", "Trouti", "3201"}
      };
  }


  
  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
     System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Admloc\\eclipse-workspace"); 
       driver = new ChromeDriver();
       baseUrl = "http://www.universitedutest.com/";
       
       wait = new WebDriverWait(driver, 10);

    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @Test (priority=1)
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
  
  }

  @Test (dataProvider = "salaries", priority=2)
  public void testAjouterEmploye2(String Prenom , String Nom , String Identifiant) throws Exception {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewEmployeeList")));
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Social Media Authentication'])[1]/following::b[1]")).click();
    driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
    driver.findElement(By.id("btnAdd")).click();
    driver.findElement(By.id("firstName")).click();
    driver.findElement(By.id("firstName")).clear();
    driver.findElement(By.id("firstName")).sendKeys(Prenom);
    driver.findElement(By.id("lastName")).click();
    driver.findElement(By.id("lastName")).clear();
    driver.findElement(By.id("lastName")).sendKeys(Nom);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[2]/following::li[1]")).click();
    driver.findElement(By.id("employeeId")).clear();
    driver.findElement(By.id("employeeId")).sendKeys(Identifiant);
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
  @Test (priority=3, dataProvider = "salaries")
  public void testSupprimerEmploye(String Prenom , String Nom, String Identifiant) throws Exception {
    driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
    driver.findElement(By.id("empsearch_id")).click();
    driver.findElement(By.id("empsearch_id")).clear();
    driver.findElement(By.id("empsearch_id")).sendKeys(Identifiant);
    driver.findElement(By.id("searchBtn")).click();
    driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td/input")).click();
    driver.findElement(By.id("btnDelete")).click();
    driver.findElement(By.id("dialogDeleteBtn")).click();
  }
  
  @Test (priority=4)
  public void Logout()  throws Exception {
  driver.findElement(By.id("welcome")).click();
  driver.findElement(By.linkText("Déconnexion")).click();
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
