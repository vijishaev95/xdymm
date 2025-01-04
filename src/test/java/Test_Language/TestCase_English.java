package Test_Language;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import Base.BaseClass;
import Base.ExcelDataReader;
//@Listeners(Utility.ExtentReportManager.class)
public class TestCase_English extends BaseClass{
	
	ExcelDataReader ex=new ExcelDataReader();
	TestCases test=new TestCases();
	String lang;
	
	@BeforeMethod
	public void browserSetUp()
	{
		lang = ex.getBrowserLang("EN");
		setupWebDriver(lang);
		//System.out.println(lang);
		String url = ex.getUrl("EN");
		navigateToUrl(url);
	}
	@Test(description = "TestCase=001")
	
	public void EN_XDM_Licensing() 
	{
		
		test.XDM_Licensing(lang);
	}
	@Test
	public void EN_XDM_admin() 
	{
		
		test.XDM_Licensing(lang);
	}
	
	@AfterMethod
	public void tearDown()
	{
		closeBrowser();
	}
}
