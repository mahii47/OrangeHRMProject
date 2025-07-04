package in.co.websitesPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonLibs.implementation.BasePage;

public class LoginPage extends BasePage{
	
	WebDriverWait wait;
	
	private By usernamefield =  By.name("username");
	private By passwordfield = By.name("password");
	private By clickLogin = By.xpath("//button[@type='submit']");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	public void enterUsername(String username)
	{
		enterText(usernamefield,username);
		//WebElement userFiled = wait.until(ExpectedConditions.visibilityOfElementLocated(usernamefiled));
	}
	
	public void enterPassword(String password)
	{
		enterText(passwordfield,password);
	}

	public void ClickButton()
	{
		click(clickLogin);
	}
	
	public String  errorMessage()
	{
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")));
		String errormsg = error.getText();
		return errormsg;
	}
}
