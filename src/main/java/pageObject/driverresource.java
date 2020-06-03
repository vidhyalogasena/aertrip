package pageObject;

	import java.io.File;
import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;



	public class driverresource {
		public static Logger log=LogManager.getLogger(driverresource.class.getName());
		public WebDriver driver;
		 protected Properties prop;
					
		public WebDriver BrowserDetails() throws IOException, InterruptedException
		{
			String browsername=System.getProperty("Browser");//this system.getProperty is used when need to parameter from maven  straighaway.In that case the mvn command will be mvn -test -DBrowser=chrome
			if(browsername.contains("chrome"))
			{
			
			System.setProperty("webdriver.chrome.driver", "//Users//vidhya.logasena//Documents//Installers//chromedriver");
			//to run code in headless mode
			
			ChromeOptions options=new ChromeOptions();
			
			if(browsername.contains("headless"))
			{
			options.addArguments("headless");
			driver = new ChromeDriver(options);
			}
			}
			else if(browsername.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "//Users//vidhya.logasena//Documents//Installers//geckodriver");
				 driver=new FirefoxDriver();
			}
			
			  prop=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//properties//file.properties");
			prop.load(fis);
			
			driver.get(prop.getProperty("url"));
	log.info(driver.getTitle());
	return driver;
	
		}
		
		
		
	/*	public void tearDown()
		{
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.close();
		}*/
	
		// TODO Auto-generated method stub

	
	public String screenshot(String Filename, WebDriver driver) throws IOException
	{
		TakesScreenshot sc=(TakesScreenshot)driver;
		File source=sc.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"//screenshot//"+Filename+".png";
	FileUtils.copyFile(source, new File(destination));
	
	return destination;
	}
	public static void main(String[] args) {
	//In order to handle insecure certifications it's necessary to add desiredcapabilities and chromeoptions in conjunction
		DesiredCapabilities cp=DesiredCapabilities.chrome();
		
		//All these are different ways to accept insecure certificates like http or ssl
		
		cp.acceptInsecureCerts();
		cp.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		cp.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				ChromeOptions options=new ChromeOptions();
	options.merge(cp);
	
	System.setProperty("webdriver.chrome.driver", "//Users//vidhya.logasena//Documents//Installers//chromedriver");
	WebDriver driver=new ChromeDriver(options);
	
	}
	}
	
