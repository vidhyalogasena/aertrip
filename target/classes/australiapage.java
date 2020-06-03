package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class australiapage {

	WebDriver driver;
	
	
	public australiapage(WebDriver driver) {
		this.driver=driver;
	
	}
	By footer= By.xpath("//div[@class='footer-links ']//ul//li/a");
By login=By.cssSelector("a.login");
By email=By.cssSelector("input#myEmailAddress");
By pwd=By.cssSelector("input#myPassword");
By submit=By.cssSelector("input.c-btn.u-materia-primary-bg.u-button.fiz.u-text-uppercase.u-margin-bottom-small");
	public WebElement footerLink()
	{
		return driver.findElement(footer);
	}
	public WebElement loginLink()
	{
		return driver.findElement(login);
	}
	public WebElement emailField()
	{
		return driver.findElement(email);
	}
	public WebElement passwordField()
	{
		return driver.findElement(pwd);
	}
	public WebElement submitButton()
	{
		return driver.findElement(submit);
	}
}
