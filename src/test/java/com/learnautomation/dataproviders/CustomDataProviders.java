package com.learnautomation.dataproviders;

import org.testng.annotations.DataProvider;


public class CustomDataProviders 
{
	 
	@DataProvider(name="adminUser")
	public static Object [][] testData()
	{
		return ExcelUtility.getDataFromExcel("Admin");
	}
	

	@DataProvider(name="createUser")
	public static Object [][] createUserTestData()
	{
		return ExcelUtility.getDataFromExcel("CreateUser");
	}
	
	
}
