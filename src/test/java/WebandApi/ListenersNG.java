package WebandApi;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;


import pageObject.driverresource;
import pageObject.extentreportNG;

public class ListenersNG extends driverresource implements ITestListener {
	ExtentTest test;
	ExtentReports exreport=extentreportNG.extReport();
	ThreadLocal<ExtentTest> parallel=new ThreadLocal<ExtentTest>();//Threadsafe will jhelp to run tests parallely and it's required to mention the test name inside tags needs to be thread safe.Here it's ExtentTest Class

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=exreport.createTest(result.getMethod().getMethodName());
	parallel.set(test);//Whenever a new report is starting to generate it should be set in threadsafe
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	parallel.get().log(Status.PASS, "I'm successfully passed");//after finishing test in threadsafe to get result need to use get()
	

	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	parallel.get().fail(result.getThrowable());//after finishing test in threadsafe to get result need to use get()
		String Filename=result.getMethod().getMethodName();	
	
	try {
		driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	try {
		parallel.get().addScreenCaptureFromPath(screenshot(Filename, driver),result.getMethod().getMethodName());
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		exreport.flush();
	}

	

}
