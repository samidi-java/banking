package com.fis.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver ldriver;
	
	// Web elements
	@FindBy(name="uid")
	WebElement userIdField;
	
	@FindBy(name="password")
	WebElement passwordField;
	
	@FindBy(name="btnLogin")
	WebElement loginButton;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[10]/a")
	WebElement lnkLogout;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}

	
	//Action methods
	public void enterUserId(String userId)
	{
		userIdField.sendKeys(userId);
	}
	
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
  public void clickLoginButton()
  {
	  loginButton.click(); 
  }
  public void clickLogout()
	{
		lnkLogout.click();
	}

}
