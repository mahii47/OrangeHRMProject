package commonLibs.contracts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface IBasePage {

	void click(By locator);
	void enterText(By locator,String text);
	void selectDropdown(By locator,String text);
	WebElement waitForElementClickable(By locator, int timeoutInSeconds);
	void addattachment(By locator);
	
}
