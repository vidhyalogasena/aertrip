package Verifyhomepage;

import org.testng.annotations.Test;



import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.AssertionFailedError;
import pageObject.australiapage;
import pageObject.driverresource;
import pageObject.newObject;
import pageObject.page1;

public class page1Test extends driverresource  {
	private static Logger log=LogManager.getLogger(page1Test.class.getName());
	public WebDriver driver;
	australiapage ap;
	@BeforeTest(groups="Regression")
	public void intialiseBowser() throws IOException, InterruptedException
	{
		driver=BrowserDetails();
		log.info("Browser Started");
	}
	@Test(groups="Regression")
	public void GBpageone() throws InterruptedException , IOException//When used multiple test annotations they will be executed in alphabetical order,to prioritize you can use priority no as 0,1,2...

	{
		
		
driver.get(prop.getProperty("url"));
		//Accessing page1 class from pageobject package
		log.info("Launched the site");
		page1 homepage=new page1(driver);
		
		newObject no=new newObject(driver);
		australiapage aus=no.loginLink();//here no need to create new object for australia since it can be done in newObject class itself.See newObject for clarification
		Thread.sleep(2000);
		aus.emailField().sendKeys("dummy@dummy.com");
		aus.passwordField().sendKeys("0987654321");
		Thread.sleep(2000);
		homepage.inputField().sendKeys("Jumper");
		Thread.sleep(2000);
		homepage.cookieClose().click();
	AssertJUnit.assertTrue(homepage.cookieClose().isDisplayed());
		log.info("cookie is displayed");
	
	log.info(homepage.navValidation().size());
	
		Thread.sleep(2000);
	homepage.GBPFlag().click();
	try
	{
		AssertJUnit.assertTrue(homepage.countryDropdown().isDisplayed());
	log.info("Yes country dropdown is visible");
	}
	catch(AssertionFailedError e)
	{
		log.error("There's an exception");
	}
	finally
	{
		Thread.sleep(2000);
	WebElement aush = homepage.ausWebsite();
		aush.click();
		log.info(driver.getTitle());
	}
		
		
	}
	@Test(dataProvider="getData",priority=2)
	public void InternationalLogin(String Username, String password) throws InterruptedException 
	{
		
		 ap=new australiapage(driver);
	
		ap.loginLink().click();
		//WebDriverWait wait=new WebDriverWait(driver,50);
		//wait.until(ExpectedConditions.elementToBeClickable(ap.emailField()));
	Thread.sleep(2000);
		ap.emailField().sendKeys(Username);
	ap.passwordField().sendKeys(password);

	
	//ap.submitButton().click();
	
	}
	
	
	
	@Test(priority=1)
	public void InternationalPage()
	{
	 ap=new australiapage(driver);
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("arguments[0].scrollIntoView()",ap.footerLink());
	
	ap.footerLink().sendKeys(Keys.COMMAND,Keys.ENTER);
	
	
	Set<String> parent=driver.getWindowHandles();
	Iterator<String> it=parent.iterator();
	while(it.hasNext())
	{
		driver.switchTo().window(it.next());
		log.info(driver.getTitle());
	
	}

	driver.switchTo().window("");
}

	@DataProvider
	public  Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="vidhu@gmail.com";
		data[0][1]="0987654321";
		data[1][0]="vls@gmail.com";
		data[1][1]="0987654098";
		return data;
	}
	/*@AfterTest
	public void Teardown() throws InterruptedException
	{

		
		tearDown();
		
	}*/
	
	}
	

