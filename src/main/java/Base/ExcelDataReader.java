package Base;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelDataReader {
	
	   
	   
	private static Sheet sheet;

	public String getData(String key,String columnName)
	{
		/*for(int i=1;i<sheet.getLastRowNum();i++)
		{
			Row currentRow=sheet.getRow(i);
			Cell keyCell = currentRow.getCell(0);
			if(keyCell!=null&&keyCell.getStringCellValue().equals(key))
			{
				ipAddress=curr
			}
		}*/
		
		try (FileInputStream fis = new FileInputStream("./src/test/resources/Data/commondata.xlsx")) {
			Workbook wb=WorkbookFactory.create(fis);
			sheet = wb.getSheetAt(0);
			//workbook = new XSSFWorkbook(fis);
			//sheet = workbook.getSheetAt(0); // Load the first sheet
		} catch (Exception e) {
			e.printStackTrace();
		}
		Row rowHeader = sheet.getRow(0);
		int columnIndex=-1;
		for(int i=0;i<rowHeader.getLastCellNum();i++)
		{
			if(rowHeader.getCell(i).getStringCellValue().equalsIgnoreCase(columnName))
			{
				columnIndex=i;
				break;
			}
		}	
		if (columnIndex == -1) {
			throw new IllegalArgumentException("Column name '" + columnName + "' not found");
		}

		for(int j=1;j<=sheet.getLastRowNum();j++)
		{
			Row currentRow=sheet.getRow(j);
			if (currentRow != null) {
			Cell keyCell = currentRow.getCell(0);
			//String KeyValue = keyCell.getStringCellValue();

			
			if(keyCell!=null&&keyCell.getStringCellValue().equalsIgnoreCase	(key))
			{
				Cell cell = currentRow.getCell(columnIndex);	
				return (cell!=null)?cell.toString():"";
			}
		}
		}
		return null;
	}

	public String getipAddress(String key)
	{
		return getData(key,"IPADDRESS");
		
	}
	
	public String getBrowser(String key) {
		return getData(key,"BROWSER");
    }

    public String getBrowserMode(String key) {
    	return getData(key,"BROWSER");
    }

    public String getBrowserLang(String key) {
    	return getData(key,"BROWSERLANG");
    }

    public String getUrl(String key) {
    	return getData(key,"CHROMEURL");
    }

//    public static String getChromeUrl() {
//    	getData(browserLang,"IPADDRESS");
//    }
//
//    public static String getWinSec() {
//    	getData(browserLang,"IPADDRESS");
//    }
//
//    public static String getViewIp() {
//    	getData(browserLang,"IPADDRESS");
//    }

//    public static String getFwModel() {
//    	getData(browserLang,"IPADDRESS");
//    }
//
//    public static String getFwVersion() {
//    	getData(browserLang,"IPADDRESS");
//    }
//
//    public static String getFwFileName() {
//    	getData(browserLang,"IPADDRESS");
//    }
//
//    public static String getViewIpa() {
//    	getData(browserLang,"IPADDRESS");
//    }
//
//    public static String getFwModelA() {
//    	getData(browserLang,"IPADDRESS");
//    }
//
//    public static String getFwVersionA() {
//    	getData(browserLang,"IPADDRESS");
//    }
//
//    public static String getFwFileNameA() {
//    	getData(browserLang,"IPADDRESS");
//    }
//
//    public static String getFwAtmntName() {
//    	getData(browserLang,"IPADDRESS");
//    }
//
//    public static String getXsMUsername() {
//    	getData(browserLang,"IPADDRESS");
//    }

	

}