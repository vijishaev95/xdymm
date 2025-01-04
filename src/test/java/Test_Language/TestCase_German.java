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
public class TestCase_German extends BaseClass{
	
	//@Listeners(Utility.ExtentReportManager.class)
	
		
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
		@Test
		public void EN_XDM_Licensing() 
		{
			
			test.XDM_Licensing(lang);
		}
		
		@AfterMethod
		public void tearDown()
		{
			closeBrowser();
		}
	}


