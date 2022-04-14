package org.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


public class sample {
	
public static void main(String[] args) throws IOException {
	
	FileInputStream fis = new FileInputStream("C:\\Users\\yegam\\eclipse-workspace\\DataDriven\\Data\\readBook1.xlsx");

	Workbook workbook = new XSSFWorkbook(fis);
	
	Sheet sheet = workbook.getSheet("Sheet1");
	
	for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) 
	{
		
	Row row = sheet.getRow(i);
	
	for (int j = 0; j < row.getPhysicalNumberOfCells() ; j++) 
	{
			
	Cell cell = row.getCell(j);
	
	
	
	int cellType = cell.getCellType();
	
	String value = "";
	
	if(cellType==1)
		
	{
		value = cell.getStringCellValue();
	}
	
	else if(DateUtil.isCellDateFormatted(cell))
		
	{
		Date d = cell.getDateCellValue();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
		value = s.format(d);
	}
	else
		
	{
		double d = cell.getNumericCellValue();
		
		long l = (long) d;
		
		value = String.valueOf(l);					
	}
	
	System.out.println(cell);
}
	
}
	
}
}
