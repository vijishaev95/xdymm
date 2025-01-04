package Base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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
	
	public String takeScreenshot(String message)
	{
		if (driver == null) {
	        System.out.println("Driver is null - cannot take screenshot");
	        
	    }
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//String desFilePath=null;
//		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//		
//		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
//		File targetFile=new File(targetFilePath);
//		
//		sourceFile.renameTo(targetFile);
//			
//		return targetFilePath;
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
	
		File src=takesScreenshot.getScreenshotAs(OutputType.FILE);
	    String desFilePath=System.getProperty("user.dir")+"/src/test/resources/screenshots/" + message + "_" + timeStamp + ".png";
		File dest=new File(desFilePath);
		dest.getParentFile().mkdirs();
		src.renameTo(dest);
		//FileUtils.copyFile(src, dest);
		
		return desFilePath;
	}

}
