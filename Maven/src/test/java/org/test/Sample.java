package org.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {
	
	
	
	public static void main(String[] args) 

	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yegam\\eclipse-workspace\\SeleniumTest\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		System.out.println("my changes");
		System.out.println("my changes 2");
		System.out.println("my changes 3");
	}
	}

