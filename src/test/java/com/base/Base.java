package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.utilities.Utilis;

public class Base {
	WebDriver driver;
    public Properties prop;
    public Properties dataProp;
	
	public Base()  {
		prop=new Properties();
		File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\configs\\config.properties");
		
		dataProp=new Properties();
		File dataPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\testdata\\testdata.properties");
		try {
			FileInputStream fis=new FileInputStream(dataPropFile);
			dataProp.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream file=new FileInputStream(propFile);
			prop.load(file);
		} catch (Throwable e) {
		
			e.printStackTrace();
		}
	}
	
	
	public WebDriver initializeBrowser(String browserName) {

		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
		}
		
		
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilis.IMPLICIT_WAIT_TIME));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilis.PAGE_WAIT_TIME));
		
		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(prop.getProperty("url"));
		
		return driver;
		
}
}