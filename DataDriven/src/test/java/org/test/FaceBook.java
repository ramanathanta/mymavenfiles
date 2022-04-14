package org.test;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class FaceBook extends BaseClass
{
	
	@Ignore
	@Test
	public void tc1() throws IOException {
		chromeBrowserLaunch();
		urlLaunch(readExcel("readBook1", "Sheet1", 0, 4));
		
		PojoClass pj = new PojoClass();		
		 
		
		fillTxt	(pj.getTxtuser(), readExcel("readBook1", "Sheet1" ,3, 0) );
		fillTxt	(pj.getTxtPass(), readExcel("readBook1", "Sheet1" , 1, 1) );
		btnClick(pj.getBtnLogin());
		
	}
	
	@Test
	public void tc2() throws IOException {
		chromeBrowserLaunch();
		urlLaunch(readExcel("readBook1", "Sheet1",0 , 4));
		
		WebElement fbtext = driver.findElement(By.xpath("//h2[contains(text(),'Facebook')]"));
		
		String text = fbtext.getText();
		
		excelReadAndWrite("Excel-Writing", "Facebook" , 0, 2, text);
		
		
		
	}
	

}
