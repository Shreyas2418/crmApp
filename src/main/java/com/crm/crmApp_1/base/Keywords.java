package com.crm.crmApp_1.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Keywords {
	WebDriver driver = null;
	FileInputStream fis;
	Properties prop;
	
	FileInputStream confis;
	Properties conprop;
	public void open() {
		try {
			
			
			fis = new FileInputStream("D:\\New folder\\crmApp_1\\src\\main\\java\\com\\crm\\crmApp_1\\base\\objectRepository.properties");
			prop = new Properties();
			prop.load(fis);
			
			confis = new FileInputStream("D:\\New folder\\crmApp_1\\src\\main\\java\\com\\crm\\crmApp_1\\base\\config.properties");
			conprop = new Properties();
			conprop.load(confis);
			
			if(conprop.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D://selenium files//chromedriver.exe");
				driver = new ChromeDriver();
			}
			
			if(conprop.getProperty("browser").equals("edge")) {
				System.setProperty("webdriver.edge.driver", "D://selenium files//msedgedriver.exe");
				driver = new EdgeDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void url(String httpUrl) {
		driver.get(httpUrl);
	}

	public void input(String data, String objectname) {
		driver.findElement(By.xpath(prop.getProperty(objectname))).sendKeys(data);
	}

	public void click(String objectname) {
		driver.findElement(By.xpath(prop.getProperty(objectname))).click();
	}

	public void close() {
		driver.close();
	}
}
