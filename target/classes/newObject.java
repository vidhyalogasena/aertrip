package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class newObject {
	
	WebDriver driver;
	
	public newObject(WebDriver driver)
	{
this.driver=driver;
	}
	
	By login=By.cssSelector("a.login");
	
	By email=By.cssSelector("input#myEmailAddress");
	By pwd=By.cssSelector("input#myPassword");
	
	public australiapage loginLink()
	{
		driver.findElement(login).click();
		
		australiapage aus=new australiapage(driver);//since login link is navigating to new page it's good to create object for that new page in this method itself
		return aus;
	}
}
