package commonLibs.implementation;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonLibs.contracts.IBasePage;

public class BasePage implements IBasePage{
	protected WebDriver driver;
	//WebDriver wait;
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public BasePage(WebDriver driver) 
	{
		this.driver = driver;
	}
	@Override
	public void click(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Button = wait.until(ExpectedConditions.elementToBeClickable((locator)));
		Button.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void enterText(By locator, String text)
	{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		    element.click();
		    element.sendKeys(Keys.CONTROL + "a");
		    element.sendKeys(Keys.DELETE);
		    element.click();
		    element.sendKeys(text);
	}
	
	public void selectDropdown(By dropdownLocator, String optionText) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


	    String currentDropdown = driver.findElement(dropdownLocator).getText();
	    System.out.println("Current Dropdown is "+currentDropdown);
	  
	    switch (currentDropdown) {
	    case "Single":
	        optionText = "Married";
	        break;
	    case "Married":
	        optionText = "Single";
	        break;
	    case "American":
	        optionText = "Indian";
	        break;
	    case "Indian":
	        optionText = "American";
	        break;
	    case "A+":
	    	optionText = "B-";
	    	break;
	    case "B-":
	    	optionText = "A+";
	    	break;
	}
	    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
	    
	    dropdown.click();
	  
	    try {
	        Thread.sleep(5000); 
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    By optionLocator = By.xpath("//div[@class='oxd-select-option']//span[contains(text(),'" + optionText + "')]");

	    WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
	   
	    try {
	        option.click();
	    } catch (Exception e) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", option);
	    }
	}
	
	
	@Override
	public WebElement waitForElementClickable(By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	@Override
	public void addattachment(By locator) {
		// TODO Auto-generated method stub
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement uploadInput = wait.until(
		    ExpectedConditions.presenceOfElementLocated(locator)
		);
		uploadInput.sendKeys("C:\\Users\\mahma\\Downloads\\Mahesh_Passport.jpg");
	}
}
