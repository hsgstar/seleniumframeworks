package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest
{
	@Test
	public void testValidation()
	{
		Log.info("Starting LoginTest");
		LoginPage loginPage = new LoginPage(driver);
		
		Log.info("Enter the username");
		loginPage.enterUsername("admin@yourstore.com");
		
		Log.info("Enter the password");
		loginPage.enterPassword("admin");
		
		Log.info("Click the Login btn");
		loginPage.clickLogin();
		
		System.out.println("Title is" +driver.getTitle());
		Log.info("Verifying the title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
	}
}
