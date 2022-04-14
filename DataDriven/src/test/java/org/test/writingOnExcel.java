package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writingOnExcel {

	public static void main(String[] args) throws IOException {
		
		File f = new File("C:\\Users\\yegam\\eclipse-workspace\\DataDriven\\Data\\Excel-Writing.xlsx");
		
		FileInputStream fis= new FileInputStream(f);
		
		Workbook workbook = new XSSFWorkbook(fis);
		
		Sheet sheet = workbook.getSheet("Facebook");
		
		Row row = sheet.getRow(0);
		
		Cell createCell = row.createCell(1);
		
		createCell.setCellValue("Password");
	
		FileOutputStream fos = new FileOutputStream(f);
		
		workbook.write(fos);			
		
		System.out.println("done");
			
			
	}
}
