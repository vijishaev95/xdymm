package Utility;

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

public class ExtentReportManager implements ITestListener{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	JavaUtils jutil=new JavaUtils();
	
	@Override
	public void onStart(ITestContext context) {
	sparkReporter=new ExtentSparkReporter("./src/test/resources/report/myreport"+jutil.randomNum()+".html");
	sparkReporter.config().setDocumentTitle("AutomationTesting");
	sparkReporter.config().setReportName("Functional test");
	sparkReporter.config().setTheme(Theme.DARK);
	
	extent=new ExtentReports();
	extent.attachReporter(sparkReporter);
	extent.setSystemInfo("ComputerName", "localhost");
	extent.setSystemInfo("Environment", "QA");
	extent.setSystemInfo("TesterName", "Vijisha");
	extent.setSystemInfo("OS","WINDOWS");
	extent.setSystemInfo("Browsername", "chrome");
	
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "Testcase passed is: "+result.getTestName());
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Testcase passed is: "+result.getName());
		test.log(Status.FAIL, "Testcase passed is: "+result.getThrowable());
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Testcase passed is: "+result.getName());
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	
	

}
