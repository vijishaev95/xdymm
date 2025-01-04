package Base;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.j2objc.annotations.Property;

public class PropertyDataReader {

	public  Properties p=new Properties();
	public  String currentLang;
	public String getpropertyData(String key, String language)
	{
		language = language.replace("--lang=", "").toLowerCase();
		System.out.println(language);
		try(FileInputStream fis=new FileInputStream("./src/test/resources/LanElements/Elements.properties"))
		{
			p.load(fis);
			//currentLang=language;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fullKey = key+"."+language;
		String value=p.getProperty(fullKey);  
		
		if(value == null)
		{
			throw new RuntimeException("Missing text for key: " + key + " in language: " + language);
		}
		return value;
		
		
	}
	
	public String getpropertyDataPath(String key)
	{
		
		try(FileInputStream fis=new FileInputStream("./src/test/resources/Data/commondata.properties"))
		{
			p.load(fis);
			//currentLang=language;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String value=p.getProperty(key);  
		
		if(value == null)
		{
			throw new RuntimeException("Missing text for key: " + key + " in language: " + currentLang);
		}
		return value;
		
		
	}
	
}
