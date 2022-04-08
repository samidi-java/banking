package com.fis.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fis.pageObjects.LoginPage;

public class TC_LoginTest_001  extends BaseTest{
	
	@Test
	public void loginTest1() throws IOException
	{
		logger.info("loginTest is started");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserId(config.getUserName());
		loginPage.enterPassword(config.getPassword());
		loginPage.clickLoginButton();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}else
		{
			captureScreen(driver,"loginTest1");
			Assert.assertTrue(false);
		}
		
		logger.info("loginTest is completed");
	}
	
	@Test
	public void loginTest2() throws IOException
	{
		logger.info("loginTest is started");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserId(config.getUserName());
		loginPage.enterPassword(config.getPassword());
		loginPage.clickLoginButton();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage1"))
		{
			Assert.assertTrue(true);
		}else
		{
			captureScreen(driver,"loginTest2");
			Assert.assertTrue(false);
		}
		
		logger.info("loginTest is completed");
	}
	
	

}
