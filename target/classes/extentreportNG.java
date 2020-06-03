package pageObject;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreportNG {
  static   ExtentSparkReporter exsreport;
   static ExtentReports exreport;


public static ExtentReports extReport()
{
	
String	path=System.getProperty("user.dir")+"//reports//index.html";
	ExtentSparkReporter exsreport=new ExtentSparkReporter(path);
	exsreport.config().setReportName("In the style Report");
	exsreport.config().setDocumentTitle("Test Results");
	
	ExtentReports exreport=new ExtentReports();
	exreport.attachReporter(exsreport);
	exreport.setSystemInfo("QA", "vidhya");
	return exreport;

}

}
