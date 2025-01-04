package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Listeners;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import io.opentelemetry.api.internal.Utils;


public class BaseClass  {
	
	public static WebDriver driver;
	//PropertyDataReader preader=new PropertyDataReader();
	//static String  driverpath=preader.getpropertyDataPath("driverpath");
	static
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
	}
	

	public void setupWebDriver(String language)
	{
		try
		{
			ChromeOptions option=new ChromeOptions();
			option.addArguments(language);
			driver=new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		
		catch (Exception e) {
			throw new RuntimeException("Failed to initialize WebDriver: " + e.getMessage());
		}
		
	}
	
	public void navigateToUrl(String url)
	{
		driver.get(url);
	}
	public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
