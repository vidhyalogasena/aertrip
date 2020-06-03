package aertrip;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import apple.laf.JRSUIConstants.Size;
import junit.framework.Assert;

public class homepage {

	WebDriver driver;
	
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

	
	System.setProperty("webdriver.chrome.driver", "//Users//vidhya.logasena//Documents//Installers//chromedriver"); 
			WebDriver driver=new ChromeDriver();
			
			driver.get("https://aertrip.com/flights#/search");
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
	driver.findElement(By.id("hotels-module")).click();

	Thread.sleep(2000);
	
	driver.findElement(By.id("hotels-module")).click();
	WebElement inputfield=driver.findElement(By.id("autocomplete-js"));
	Thread.sleep(2000);
	
	inputfield.clear();
	
	inputfield.sendKeys("London,UK");

	Thread.sleep(8000);
List<WebElement> list=driver.findElements(By.cssSelector("span.css-placename-col.css-ellipsis"));
	
	int citylist=list.size();
	System.out.println(citylist);
	for(int i=0;i<citylist;i++)
	{
		String cityname=list.get(i).getText();
		System.out.println(cityname);
		if(cityname.equalsIgnoreCase("London, England, United Kingdom"))
		{
			String selected=list.get(i).getText();
			System.out.println(selected);
			list.get(i).click();
		}
	}
	Thread.sleep(2000);

	WebElement datefield=driver.findElement(By.cssSelector("input.datepicker"));
	System.out.println(datefield.getAttribute("value"));
	datefield.click();
	datefield.clear();
	//Using combination od date,simpledateformat and calendar classes in conjuction to set future date
	Thread.sleep(2000);
	Date date=new Date();
	Calendar calendar=Calendar.getInstance();
	calendar.setTime(date);
	 calendar.add(Calendar.DATE,6);
	SimpleDateFormat sdf=new 	SimpleDateFormat("dd/MM/yyyy");
	String dateinput=sdf.format(calendar.getTime());
	datefield.sendKeys(dateinput);
	//datefield.sendKeys(Keys.ENTER);

	System.out.println(datefield.getAttribute("value"));
		
	Thread.sleep(2000);
	WebElement checkout=driver.findElement(By.cssSelector("input[placeholder='Check-out']"));
	checkout.click();
	calendar.add(calendar.DATE, 4);
	String destinput=sdf.format(calendar.getTime());
	checkout.sendKeys(destinput);
	checkout.sendKeys(Keys.ENTER);
	
	driver.findElement(By.cssSelector("input[placeholder='1 Adult']")).click();
List<WebElement> childicon=	driver.findElements(By.cssSelector("i.icon.icon_children"));

	
	int i=0;
		while(i<1)
		{
			childicon.get(i).click();
		
		i++;
		}
		driver.findElement(By.cssSelector("input.numberInput")).sendKeys("0");
	
	
	driver.findElement(By.cssSelector("div.css-addRooms.addRooms.addRooms-js")).click();
	Thread.sleep(2000);
	List<WebElement> adultsel=driver.findElements(By.xpath("//div[@data-index='1']//div[2]//i[@class='icon icon_adult']"));

	

	int j=0;
	while(j<1)
	{
		adultsel.get(j).click();
		j++;
	}
	
	
	
	List<WebElement> childsel=driver.findElements(By.xpath("//div[@data-index='1']//div[3]//i[@class='icon icon_children']"));
	List<WebElement> ageinput=driver.findElements(By.cssSelector("div[data-index='1'] span>input.numberInput"));
	String array[]= {"10","12"};
	
	for(int x=0;x<=1;)
	{
		childsel.get(x).click();
		ageinput.get(x).clear();
		ageinput.get(x).sendKeys(array[x]);
		x++;
		
	}
	

driver.findElement(By.cssSelector("button.button.fill")).click();

//page load wait

Thread.sleep(20000);
//to locate range element and deciding which tab to slect either range or nearby
WebElement title=driver.findElement(By.cssSelector("div.css-map-title-name"));
System.out.println("Result:"+title.getText());
if(title.getText().equalsIgnoreCase("showing 1 out of 1 hotels"))
{
	driver.findElement(By.cssSelector("div#withinRange-hotels-js div")).click();
}
else
{
	driver.findElement(By.cssSelector("span.nearby-tab-js")).click();
}


//driver.findElement(By.cssSelector("span.nearby-tab-js")).click();
Thread.sleep(2000);
List<WebElement> nearbylist=driver.findElements(By.cssSelector("div.css-hotel-result-view.css-hotels-nearby div.hotel-types-box.hotel-list-box"));
System.out.println(nearbylist.size());
ArrayList<Integer> alist=new ArrayList<Integer>();
for(int n=0;n<nearbylist.size();n++)
{
	List<WebElement> nearbyratings=nearbylist.get(n).findElements(By.cssSelector("div.hotel-types-box.hotel-list-box i.icon.icon_star-filled"));
	int nearbyratingsize=nearbyratings.size();
	System.out.println("Rating of"+n+"hotel:" +nearbyratingsize);
	alist.add(nearbyratingsize);
	System.out.println("Value in " +n+ "index is"+alist.get(n));
}
Collections.sort(alist);
System.out.println("Sort order is:"+alist);
Integer min=alist.get(0);
//Removing the duplicate minmimum value from the list
while(alist.contains(min))
{
	alist.remove(min);
}
System.out.println("Size after removing first minimum :"+alist.size());
int secmin=alist.get(0);
System.out.println("Second lowest rating is:"+secmin);
Thread.sleep(2000);

//Getting the value of second lowest and iterating to click the hotel
/*for(int f=0;f<nearbylist.size();f++)
{
	List<WebElement> finalsize=nearbylist.get(f).findElements(By.cssSelector("div.hotel-types-box.hotel-list-box i.icon.icon_star-filled"));
finalsize.size();	
	while(finalsize.size()==secmin)
	{
		finalsize.get(f).click();
		break;
	}
	
}*/

WebElement five=driver.findElement(By.cssSelector("div.css-hotel-result-view.css-hotels-nearby div:nth-child(5)"));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].scrollIntoView();",five);
Thread.sleep(1000);
five.click();
Thread.sleep(8000);
driver.findElement(By.xpath("//button[text()='Book']")).click();
Thread.sleep(2000);
List<WebElement> details=driver.findElements(By.cssSelector("div.css-rates-cards.room-rate-wrapper-js"));
details.size();
By price=By.xpath("//div[@class='css-rates-cards room-rate-wrapper-js']/div[2]/div/div[2]/span/div/span[2]");
ArrayList<Integer> demo=new ArrayList<Integer>();
for(int hdetails=0;hdetails<details.size();hdetails++)
{
	WebElement pricediv=details.get(hdetails).findElement(price);
	String value=pricediv.getAttribute("data-base");
	int rates=Integer.valueOf(value);
	System.out.println("Price of" +hdetails+" is"+value);
	
	demo.add(rates);

}

System.out.println("Array size is:"+demo.size());



//To click book button
/*driver.findElement(By.xpath("//button[text()='Book']")).click();
Thread.sleep(1000);
driver.findElement(By.cssSelector("button.button.line.bookingConfirmation-js")).click();

//To grab a shot of the booking page
TakesScreenshot sc=(TakesScreenshot)driver;
File Source=sc.getScreenshotAs(OutputType.FILE);

FileUtils.copyFile(Source, new File("//Users//vidhya.logasena//Desktop//confirmation.png"));*/
	
	 
	}
}


