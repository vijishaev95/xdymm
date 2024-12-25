package Test_Language;

import java.time.Duration;

import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.checkerframework.checker.units.qual.h;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.BaseClassFinder;

import Base.BaseClass;
import Base.SeleniumUtils;
import ObjectRepo.HomeElements;
import Test_Pages.HomePage;

public class TestCases extends BaseClass{
	
	HomePage hPage=new HomePage();
	
	public void XDM_Licensing(String lang) 
	{
		
		hPage.verifyElectronicsBtn(lang);

	}
}
