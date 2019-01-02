package com.seleniumTA.Utilities;

import java.io.File;
import java.io.FileInputStream;
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
}
