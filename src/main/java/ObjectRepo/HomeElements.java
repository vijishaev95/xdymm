package ObjectRepo;
import Base.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.PropertyDataReader;



public class HomeElements extends BasePage{

	private PropertyDataReader p=new PropertyDataReader();
	private String lang;
	private String Electronics;
	

	@FindBy(id="dd_header_signInOrUp")
	private WebElement loginBtn;
	
	public HomeElements(WebDriver driver)
	{
		super(driver);
		//this.driver=driver;
//		PageFactory.initElements(driver, this);		
	}
	public void languageRead(String lang)
	{
		this.lang=lang;
		this.Electronics=p.getpropertyData("Electronics", lang);
		//System.out.println(Electronics);
		
	}

	//	@FindBy(xpath="//span[text()='"+Electronics+"']")
	//	private WebElement btn_Electronics;

	public WebElement getElectronicsBtn()
	{
		//return btn_Electronics;
		return driver.findElement(By.xpath("//span[text()='"+Electronics+"']"));
	}
	public void ClickElectronicsBtn()
	{
		//btn_Electronics.click();
		driver.findElement(By.xpath("//span[text()='"+Electronics+"']")).click();
	}
	
	public WebElement getLoginBtn()
	{
		return loginBtn;
	}

}
