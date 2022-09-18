package com.seleniumTA.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetData 
{
	static File fl;
	static FileInputStream fis;
	static HashMap<String, String> elementMap;
	
	public static String fromExcel(String fileName, String sheetName, int rIndex, int cIndex) 
	{
		String data = null;
		fl = new File("./resources/"+fileName+".xlsx");
		try
		{
			fis=  new FileInputStream(fl);
			Workbook wb =WorkbookFactory.create(fis);
			Sheet st= wb.getSheet(sheetName);
			Row rw =st.getRow(rIndex);
			Cell c =rw.getCell(cIndex);
			DataFormatter dataformat = new DataFormatter();
			data=dataformat.formatCellValue(c);		
		}
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return data;
	}
	
	public static List<String> getEntireRowData(String filePath, String sheetName, int rIndex ) 
	{
		
		String data = null;
		fl = new File(filePath);
		ArrayList<String> ar = new ArrayList<String>() ;		
		try
		{
			fis=  new FileInputStream(fl);
			Workbook wb =WorkbookFactory.create(fis);
			Sheet st= wb.getSheet(sheetName);
			Row rw =st.getRow(rIndex);			
			for(Cell c: rw) 
			{
				 data = c.getStringCellValue();
				ar.add(data);
			}
			
			return ar;	
		}
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return ar;
	}
	public static HashMap<String, String> getDataMap(String filePath, String sheetName, int startRow ) 
	{
		elementMap = new HashMap<String, String>();
		/*String data = null;*/
		fl = new File(filePath);
				
		try
		{
			fis=  new FileInputStream(fl);
			Workbook wb =WorkbookFactory.create(fis);
			Sheet st= wb.getSheet(sheetName);
			for (int i = startRow; i <= st.getLastRowNum(); i++)
			{
				Row rw = st.getRow(i);
				String ename = rw.getCell(0).getStringCellValue();
				String path = rw.getCell(1).getStringCellValue();
				elementMap.put(ename, path);
			
			}		
			
		}
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return elementMap;
	}
	
	public static String fromProperties(String fileName, String key) {
		String data = null;
		fl= new File("./src/main/resources/"+fileName+".properties");
		try 
		{
		fis = new FileInputStream(fl);
		Properties prop = new Properties();
		prop.load(fis);
		data=(String)prop.getProperty(key);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	//copy all these
}
