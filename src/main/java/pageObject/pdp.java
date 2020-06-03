package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pdp {
WebDriver driver;
	public pdp(WebDriver driver)
	{
		this.driver=driver;
	}

By image=By.cssSelector("div.product-details--content-box>a");

By title=By.cssSelector("div.product-name>h1");
By results=By.cssSelector("div.item-filter__items-found>span");

public List<WebElement> imageCarousel()
{
	return driver.findElements(image);
}
public WebElement prodTitle()
{
	return driver.findElement(title);
}
public WebElement resultNumbers()
{
	return driver.findElement(results);
}
}
