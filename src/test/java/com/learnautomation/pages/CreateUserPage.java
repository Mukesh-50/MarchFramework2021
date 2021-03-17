package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learnautomation.utility.Utility;

public class CreateUserPage {

	WebDriver driver;

	public CreateUserPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	By Admin = By.xpath("//b[text()='Admin']");
	By AddButton = By.xpath(("//input[@name='btnAdd']"));
	By EmployeeName = By.xpath("//label[text()='Employee Name']//following::input[1]");
	By NewUserName = By.xpath("//label[text()='Username']//following::input[1]");
	By NewPassword = By.xpath("//label[text()='Password']//following::input[1]");
	By ConfirmPassword = By.xpath("//label[text()='Confirm Password']//following::input[1]");
	By Save = By.xpath("//input[@value='Save']");
	By SuccessMessage = By.xpath("//div[contains(text(),'Successfully Saved ') and @class='message success fadable']");
	By SearchUserName = By.xpath("//input[@id='searchSystemUser_userName']");
	By SearchButton = By.xpath("//input[@class='searchbutton']");

	public String createUser(String employeeName, String newUserName, String newPassword, String confirmPassword) {

		Utility.click(driver, Admin);
		Utility.click(driver, AddButton);
		Utility.type(driver, EmployeeName, employeeName);
		Utility.type(driver, NewUserName, newUserName);
		Utility.type(driver, NewPassword, newPassword);
		Utility.type(driver, ConfirmPassword, confirmPassword);
		Utility.ExplicitClick(driver, Save);
		String msg = Utility.getText(driver, SuccessMessage);
		return msg;

	}

	public Boolean searchForNewUser(String newUserName) {

		Utility.type(driver, SearchUserName, newUserName);
		Utility.click(driver, SearchButton);
		Boolean newUserDisplayed = driver.findElement(By.xpath("//a[contains(text(),'" + newUserName + "')]"))
				.isDisplayed();
		return newUserDisplayed;

	}

}
