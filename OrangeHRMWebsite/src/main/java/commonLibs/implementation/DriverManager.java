package commonLibs.implementation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	public static WebDriver driver;
	public WebDriver initializeDriver(ChromeOptions options)
	{
	//	WebDriverManager.chromedriver().setup();
	//	driver = new ChromeDriver();
		return new ChromeDriver(options);	
	}
	
	public void setDriver(WebDriver driver)
	{
		DriverManager.driver = driver;
	}
	public void teardown()
	{
		driver.quit();		
	}
}
