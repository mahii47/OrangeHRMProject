package in.co.website.test;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import commonLibs.utils.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;
import in.co.websitesPages.LoginPage;
import testData.DataProviders;
import commonLibs.implementation.BasePage;
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
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--incognito"); 
		options.addArguments("--start-maximized"); 
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		loginPage = new LoginPage(driver); 
	}
	@Test(dataProvider = "loginDataFromDB",dataProviderClass = DataProviders.class)
	public void loginTest(String username,String password,boolean expectedResult)
	{
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.ClickButton();
		
		boolean isLoginSuccessful;
		
		try {
            String errormsg = loginPage.errorMessage();
            if (errormsg.contains("Invalid credentials")) {
                isLoginSuccessful = false;
            } else {
                isLoginSuccessful = true;
            }
        } catch (Exception e) {
            isLoginSuccessful = true;
        }

        System.out.println("Testing with: " + username + " | Expected: " 
                + expectedResult + " | Actual: " + isLoginSuccessful);

        Assert.assertEquals(isLoginSuccessful, expectedResult,
                "Test failed for username: " + username);
	}
	@AfterTest
	public void closeBrowser()
	{
		driverManager.teardown();
	}
}
