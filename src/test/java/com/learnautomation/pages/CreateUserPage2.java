package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateUserPage2 {

	 WebDriver driver;
	public CreateUserPage2(WebDriver ldriver) {
		
		this.driver =ldriver;
	}
	
	By Admin = By.xpath("//b[text()='Admin']");

	public void createUser( String employeeName, String newUserName,
			String newPassword, String confirmPassword)  {

	
		driver.findElement(By.xpath("//b[text()='Admin']")).click();

		driver.findElement(By.xpath("//input[@name='btnAdd']")).click();

	
		driver.findElement(By.xpath("//label[text()='Employee Name']//following::input[1]"))
				.sendKeys(employeeName);
		driver.findElement(By.xpath("//label[text()='Username']//following::input[1]")).sendKeys(newUserName);
		driver.findElement(By.xpath("//label[text()='Password']//following::input[1]"))
				.sendKeys(newPassword);
		driver.findElement(By.xpath("//label[text()='Confirm Password']//following::input[1]"))
				.sendKeys(confirmPassword);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
		String msg=driver.findElement(By.xpath("//div[contains(text(),'Successfully Saved ') and @class='message success fadable']")).getText();
		
		System.out.println("Msg Captured "+msg);

		if(msg.contains("Saved"))
		{
			System.out.println("Validation Passed- User added");
		}
		else
		{
			System.out.println("Validation Failed- User creation failed");
		}

		
		driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys(newUserName);
		
		driver.findElement(By.xpath("//input[@class='searchbutton']")).click();
		
		Boolean b = driver.findElement(By.xpath("//a[contains(text(),'" + newUserName + "')]")).isDisplayed();
		
		if (b.equals(true)) {
			System.out.println("Username " + newUserName + " is added successfully");
		} else {
			System.out.println("Username " + newUserName + " cannot be found");
		}
		
	}
	
}
