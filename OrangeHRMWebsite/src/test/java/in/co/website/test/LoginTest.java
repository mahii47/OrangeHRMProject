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
import org.testng.annotations.DataProvider;
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
	
	
	@DataProvider(name = "loginData")
	public Object[][]getLoginData()
	{
		return new Object[][]
				{
			{"WrongUser","admin123",false},
			{"Admin","admin1234",false},
			{"12345","45678",false},
			{"","admin123",false},
			{"Admin","",false},
			{"","",false},
			{"Admin","admin123",true}
			
				};
	}
	
	
	
	@Test(dataProvider = "loginData")
	public void loginTest(String username,String password,boolean expectedResult)
	{
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.ClickButton();
		
		boolean isLoginSuccessful;
		
		try {
			String errormsg = loginPage.errorMessage();
			if( errormsg.contains("Invalid credentials"))
			{
			isLoginSuccessful = false;
			}
			else {
				isLoginSuccessful = true;
			}
		}
		catch(Exception e)
		{
			isLoginSuccessful = true;
		}
		
		  System.out.println("Testing with: " + username + " | Expected: " + expectedResult + " | Actual: " + isLoginSuccessful);

		    Assert.assertEquals(isLoginSuccessful, expectedResult, 
		        "Test failed for username: " + username);
	}
	
	
	@AfterTest
	public void closeBrowser()
	{
		driverManager.teardown();
	}
}
