package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class page1{
	
	 WebDriver driver;
	
	public page1(WebDriver driver) {
		this.driver=driver;
	}
By mainnav=By.xpath("//ul[@id='nav']//li//a");
By subNav=By.xpath("//div[@class='list-block categories-list-block megamenu-list-block ']//ul//li/a");
	
By close=By.xpath("//span[text()='Close']");
	
By field=By.cssSelector("input.visual-search__input");
	
By nav=By.xpath("//ul[@id='nav']//li//a");
	//another way of defining web element using findBy annotation
	
By flag=By.cssSelector("div.currency-dropdown.f-dropdown.content.open.f-open-dropdown");

	
By GBP=By.cssSelector("a.currency-current.currency-flag.currency-GBP.flag-default");
	
By Aus=By.xpath("//ul[@class='currency-dropdown']//li/a");
			
By filter=By.xpath("//ul[@class='filter-list-items colour-swatches']//li");			
			


public WebElement inputField()
	{
		return driver.findElement(field);
	}
	public WebElement cookieClose()
	{
		return driver.findElement(close);
	}
	public List<WebElement> navValidation()
	{
		return driver.findElements(nav);
	}
	public WebElement GBPFlag()
	{
		return driver.findElement(GBP);
	}
	public WebElement countryDropdown()
	{
		return driver.findElement(flag);
	}
	public WebElement ausWebsite()
	{
		return driver.findElement(Aus);
	}
	public List<WebElement> mainNavigation()
	{
		return driver.findElements(mainnav);
	}
	public List<WebElement> subNavigation()
	{
		return driver.findElements(subNav);
	}
	public List<WebElement> filterSelection()
	{
		return driver.findElements(filter);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

}

}
