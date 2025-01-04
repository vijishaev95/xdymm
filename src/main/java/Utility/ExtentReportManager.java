package Utility;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base.JavaUtils;
import Base.SeleniumUtils;

public class ExtentReportManager implements ITestListener{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	JavaUtils jutil=new JavaUtils();
	public String repName;
	SeleniumUtils sutil=new SeleniumUtils();
	
	@Override
	public void onStart(ITestContext context) {
	SimpleDateFormat df=new SimpleDateFormat("YYYY.MM.DD.HH.mm.ss");
	Date dt=new Date();
	String timeStamp=df.format(dt);
	repName="Test-Report-"+timeStamp+".html";
	sparkReporter=new ExtentSparkReporter("./src/test/resources/report/"+repName);
	sparkReporter.config().setDocumentTitle("AutomationTesting");
	sparkReporter.config().setReportName("Functional test");
	sparkReporter.config().setTheme(Theme.DARK);
	
	extent=new ExtentReports();
	extent.attachReporter(sparkReporter);
	extent.setSystemInfo("Application", "Noon");
	extent.setSystemInfo("ComputerName", "localhost");
	extent.setSystemInfo("Environment", "QA");
	extent.setSystemInfo("TesterName", "Vijisha");
	String os=context.getCurrentXmlTest().getParameter("os");
	extent.setSystemInfo("OS",os);
	String browser=context.getCurrentXmlTest().getParameter("browser");
	extent.setSystemInfo("Browsername", browser);
	
		
	}
//	@Override
//	public void onTestStart(ITestResult result) {
//	    test = extent.createTest(result.getMethod().getMethodName());
//	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		test=extent.createTest(result.getTestClass().getName());
//		test.assignCategory(result.getMethod().tes)
		test.log(Status.PASS, "Testcase passed is: "+result.getMethod().getMethodName()+"got succesfully passed");
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.log(Status.FAIL, "Testcase failed: "+result.getMethod().getMethodName()+"got failed");
		test.log(Status.FAIL, "Testcase failed: "+result.getThrowable().getMessage());
		String name=result.getMethod().getMethodName();
		String path=sutil.takeScreenshot(name);
		
		try {
	        // Attach the screenshot to the report
	        test.addScreenCaptureFromPath(path, "Failed Test Screenshot");
	    } catch (Exception e) {
	        test.log(Status.WARNING, "Failed to attach screenshot to the report: " + e.getMessage());
	    }
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.log(Status.SKIP, "Testcase skipped: "+result.getMethod().getMethodName()+"got skipped");
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		String pathofExtentReport=System.getProperty("user.dir")+"/src/test/resources/report/"+repName;
		File extentReports=new File(pathofExtentReport);
		try {
			Desktop.getDesktop().browse(extentReports.toURI());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
