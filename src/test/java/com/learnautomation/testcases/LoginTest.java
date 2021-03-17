package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataproviders.CustomDataProviders;
import com.learnautomation.pages.CreateUserPage;
import com.learnautomation.pages.LoginPage;

public class LoginTest extends BaseClass {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = getDriver();
	}

	@Test(priority = 1, dataProvider = "adminUser", dataProviderClass = CustomDataProviders.class)
	public void loginApplication(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(username, password);
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

	}

	@Test(priority = 2, dataProvider = "createUser", dataProviderClass = CustomDataProviders.class)
	public void createUserTest(String employeeName, String newUserName, String newPassword, String confirmPassword) {
		CreateUserPage user = new CreateUserPage(driver);
		String message = user.createUser(employeeName, newUserName, newPassword, confirmPassword);
		Assert.assertTrue(message.contains("Success"));
		Boolean NewUserDisplayed=user.searchForNewUser(newUserName);
		Assert.assertTrue(NewUserDisplayed, "User cannot be found");
	}
}