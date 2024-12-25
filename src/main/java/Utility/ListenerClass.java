package Utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Base.BaseClass;
import Base.SeleniumUtils;

public class ListenerClass extends BaseClass implements ITestListener {
	
	SeleniumUtils sutil=new SeleniumUtils();
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		String name=result.getName();
		sutil.takeScreenshot(name);
		
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
	}
	
	

}
