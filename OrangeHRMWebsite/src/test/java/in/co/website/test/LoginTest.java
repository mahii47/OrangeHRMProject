package in.co.website.test;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import in.co.websitesPages.LoginPage;
import commonLibs.implementation.DriverManager;

public class LoginTest {

	LoginPage loginPage;
	DriverManager driverManager;
	public static WebDriver driver;
	
	
	@BeforeTest
	public void invokeBrowser()
	{
		driverManager = new DriverManager();
		driver = driverManager.initializeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		loginPage = new LoginPage(driver); 
	}
	
	@Test(priority = 1)
	public void ValidLogin()
	{
		driver.navigate().refresh();
		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
		loginPage.ClickButton();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl =  "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(actualUrl, expectedUrl,"Test passed");	
	}
	
	@Test(priority = 0)
	public void InvalidLogin() throws InterruptedException {
	    loginPage.enterUsername("Admin");
	    loginPage.enterPassword("admin1234");
	    loginPage.ClickButton();
	    
	    String actualError = loginPage.errorMessage();
	    String expectedError = "Invalid credentials";
	    Assert.assertEquals(actualError, expectedError, "Error message mismatch - Test Failed");
	    System.out.println("Test Passed: Invalid login message displayed correctly");
	    Thread.sleep(5000);
	}
	
	
	@AfterTest
	public void closeBrowser()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	driverManager.teardown();
	
	}
}
