package com.fis.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	public ReadConfig()
	{
		File file=new File(".\\config\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(file);
			prop=new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getApplicationUrl()
	{
		String url=prop.getProperty("baseUrl");
		return url;
	}
	
	public String getUserName()
	{
		String userName=prop.getProperty("userName");
		return userName;
	}
	public String getPassword()
	{
		String password=prop.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromePath=prop.getProperty("chromePath");
		return chromePath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxPath=prop.getProperty("firefoxPath");
		return firefoxPath;
	}
	
	public String getEdgePath()
	{
		String edgePath=prop.getProperty("edgePath");
		return edgePath;
	}
	public String getIEPath()
	{
		String iePath=prop.getProperty("iePath");
		return iePath;
	}
}
