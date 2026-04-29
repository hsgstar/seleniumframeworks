package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest
{
	@Test
	public void testValidation()
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("admin@yourstore.com");
		loginPage.enterPassword("admin");
		loginPage.clickLogin();
		System.out.println("Title is" +driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
	}
}
