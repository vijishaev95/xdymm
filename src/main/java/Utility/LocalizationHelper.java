package Utility;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationHelper {

	private ResourceBundle resourceBundle;	

	public LocalizationHelper(String language)
	{	
		Locale locale=new Locale(language);
		resourceBundle=ResourceBundle.getBundle("localization/messages", locale);
	}
	
	public String getText(String key)
	{
		return resourceBundle.getString(key);
		
	}
	
	public String createLocalizationXpath(String textkey)
	{
		String localizedText=getText(textkey);
		return localizedText;
		
	}
}
