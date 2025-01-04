package Test_Pages;

import org.testng.asserts.SoftAssert;

import Base.BaseClass;
import Base.PropertyDataReader;
import Base.SeleniumUtils;
import ObjectRepo.HomeElements;

public class HomePage extends BaseClass {
	
	SeleniumUtils selutil=new SeleniumUtils();
	PropertyDataReader pdata=new PropertyDataReader();
	//HomeElements hElements;
	HomeElements hElements;
	public void verifyElectronicsBtn(String lang)
	{
		 hElements=new HomeElements(driver);
		
		//Pass the language to Homeelements to fetch the property data
		hElements.languageRead(lang);
		//Wait the Electronics button
		selutil.waitUntilElementVisible(hElements.getElectronicsBtn());
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOf(hElements.getElectronicsBtn()));
		String actbtn=hElements.getElectronicsBtn().getText();
		System.out.println(actbtn);			
		hElements.ClickElectronicsBtn();
		hElements.getElectronicsBtn().click();
		String Expctbtn=pdata.getpropertyData("Electronics", lang);
		//String Expctbtn="Electronicss";
		SoftAssert sassert=new SoftAssert();
		sassert.assertEquals(actbtn, Expctbtn,"Actual and expected not Matching");
		sassert.assertEquals(actbtn, Expctbtn);
		sassert.assertAll();
	}

	
}
