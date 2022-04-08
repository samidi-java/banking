package com.fis.testCases;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.fis.util.ReadConfig;

public class BaseTest {
	WebDriver driver;
	Logger logger=Logger.getLogger("Banking Application");
	ReadConfig config=new ReadConfig();
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", config.getChromePath());
			driver=new ChromeDriver();	
		} else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", config.getFirefoxPath());
			driver=new FirefoxDriver();	
		} else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", config.getEdgePath());
			driver=new EdgeDriver();	
		} else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", config.getIEPath());
			driver=new InternetExplorerDriver();	
		}
		driver.get(config.getApplicationUrl());
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
