package org.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SampleWrite {
	
public static void main(String[] args) throws IOException {
	
	File f = new File("C:\\Users\\yegam\\eclipse-workspace\\DataDriven\\Data\\Excel-Writing.xlsx");
	
	Workbook workbook= new XSSFWorkbook();
	
	Sheet createSheet = workbook.createSheet("Facebook");
	
	Row createRow = createSheet.createRow(0);
	
	Cell createCell = createRow.createCell(0);
	
	createCell.setCellValue("UserName");
	
	FileOutputStream fos = new FileOutputStream(f);
	
	workbook.write(fos);
	
	System.out.println("done");
	
	
	
	
	
}
	

}
