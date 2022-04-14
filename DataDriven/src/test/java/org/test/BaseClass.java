package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


		public static WebDriver driver;
		public static JavascriptExecutor js;
		
		public static void wait(int time) 
		{
			driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);

		}
		
		public static void chromeBrowserLaunch() 	
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
		}
		
		public static void firefoxBrowserLaunch()
		{
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();			
		}
		
		private void iEBrowserLaunch()
		{
			
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();

		}
		public static void urlLaunch(String url)
		{
			driver.get(url);
		}
		
		public static void fillTxt(WebElement e, String text)
		{
			e.sendKeys(text);
		}
		
		public static void btnClick(WebElement e)
		{
			e.click();		 	

		}
		
		
		public static void filltxtJava(WebElement e, String text)
		{
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('value','"+text+"')", e);

		}
		
		public static void btnClickJava(WebElement e) 
		{
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", e);

		}
		
		public static void navigate() {
			
			driver.navigate().refresh();

		}
		
		public static String readExcel(String fileName, String sheetname , int rownumb, int columnno) throws IOException		
		{
			FileInputStream fis = new FileInputStream("C:\\Users\\yegam\\eclipse-workspace\\DataDriven\\Data\\"+fileName+".xlsx");

			Workbook workbook = new XSSFWorkbook(fis);
			
			Sheet sheet = workbook.getSheet(sheetname);
			
			Row row = sheet.getRow(rownumb);
							
			Cell cell = row.getCell(columnno);			
			
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
			
			return value;
			
		}		
		
		public static void excelReadAndWrite(String filename, String sheetName, int rowno , int colno , String cellvalue) throws IOException
		
		{
			File f = new File("C:\\Users\\yegam\\eclipse-workspace\\DataDriven\\Data\\"+filename+".xlsx");
			
			FileInputStream fis= new FileInputStream(f);
			
			Workbook workbook = new XSSFWorkbook(fis);
			
			Sheet sheet = workbook.getSheet(sheetName);
			
			Row row = sheet.getRow(rowno);
			
			Cell createCell = row.createCell(colno);
			
			createCell.setCellValue(cellvalue);
			
			FileOutputStream fos = new FileOutputStream(f);
			
			workbook.write(fos);			
			
		}
		
	}
		
		
		


