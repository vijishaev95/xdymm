package Base;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils extends BaseClass {
	
	
	public void waitUntilElementVisible(WebElement welement)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(welement));
	}
	
	public void takeScreenshot(String message)
	{
		if (driver == null) {
	        System.out.println("Driver is null - cannot take screenshot");
	        return;
	    }
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		try {
		File src=takesScreenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File("./src/test/resources/Screenshot/"+message+".png");
		dest.getParentFile().mkdirs();
		FileUtils.copyFile(src, dest);
		}
		catch (Exception e) {
			e.printStackTrace();			
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}

}
