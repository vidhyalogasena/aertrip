package categoryNavigation;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.aventstack.extentreports.model.Log;
import com.google.common.io.Files;

import pageObject.driverresource;
import pageObject.page1;
import pageObject.pdp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class validateNavigationTest extends driverresource{
	private static Logger log=LogManager.getLogger(validateNavigationTest.class.getName());
	public WebDriver driver;
	
@Test
public void mainPageNavValidation() throws IOException, InterruptedException
{
		
		driver=BrowserDetails();
		page1 navMain=new page1(driver);
	Thread.sleep(2000);
	navMain.inputField().sendKeys("Orange");
	
	
	int total=navMain.navValidation().size();
	log.info(total);
	//System.out.println(total);
	
	int subTotal=navMain.subNavigation().size();
log.info(subTotal);
	for(int i=0;i<total;i++)
	{
		String name=navMain.mainNavigation().get(i).getText();
		log.info(name);
		if(name.equalsIgnoreCase("Tops"))
		{
			Actions select=new Actions(driver);
			String navMenu=navMain.mainNavigation().get(i).getText();
			log.info(navMenu);
			//System.out.println(navMenu);
			select.moveToElement(navMain.mainNavigation().get(i)).build().perform();
		break;
		}
		}

	for(int j=0;j<subTotal;j++)
	{
		String subMenu=navMain.subNavigation().get(j).getText();
		//System.out.println(subMenu);
		log.info(subMenu);
		if(subMenu.equalsIgnoreCase("Going Out Tops"))
		{
			navMain.subNavigation().get(j).click();
			break;
		}
	
	}


}
@Parameters({"colour"})
	@Test(groups="Regression", dependsOnMethods= {"mainPageNavValidation"},priority=1)
public void filterValidation() throws InterruptedException
{
	
		page1 navMain=new page1(driver);
		Thread.sleep(2000);
		int filtersize=navMain.filterSelection().size();
		log.info(filtersize);
		//System.out.println(filtersize);
		
		for(int i=0;i<filtersize;i++)	
		{
			
			String titlename=navMain.filterSelection().get(i).getAttribute("title").toString();
	
			log.info(titlename);
			//System.out.println("titlename");
		if(titlename.equalsIgnoreCase("colour"))
		{
			Actions a=new Actions(driver);
			
			
			
			JavascriptExecutor jse8 = (JavascriptExecutor)driver;
			jse8.executeScript("arguments[0].scrollIntoView();", navMain.filterSelection().get(i));
			
					a.moveToElement(navMain.filterSelection().get(i)).click().build().perform();


		break;
		
		}
		
	}
		pdp im=new pdp(driver);
	String numbers=im.resultNumbers().getText().toString();
	SoftAssert s=new SoftAssert();
	Assert.assertEquals(numbers, "20 results");
//s.assertEquals(numbers, "20 results");
	log.error("numbers don't match");
	
}
@Test(priority=2)
public void pdpValidation() throws InterruptedException
{
	pdp im=new pdp(driver);
	Thread.sleep(2000);
	int imgsize=im.imageCarousel().size();
	log.info(imgsize);
	for(int i=0;i<imgsize;i++)
	{
		String imgTitle=im.imageCarousel().get(i).getText().toString();
	if(imgTitle.equalsIgnoreCase("Black Pu Puff Sleeve Blouse"))
			{
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();",im.imageCarousel().get(i));
		im.imageCarousel().get(i).click();
			
			break;
			}
	
	}

String titlevalid=im.prodTitle().getText().toString();

SoftAssert sa=new SoftAssert();
Assert.assertEquals(titlevalid, "pink PU PUFF SLEEVE BLOUSE");
//sa.assertEquals(titlevalid, "pink PU PUFF SLEEVE BLOUSE");
log.error("Title don't match");
}



}






   
