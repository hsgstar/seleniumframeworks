package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest
{
	
	
	
	
//	@DataProvider(name="LoginData")
	
	public Object[][] getLoginData() throws IOException{
		
		String filePath = System.getProperty("user.dir")+"/testdata/TestData.xlsx";  //path for the excel
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount-1][2];            //column not to consider
		
		for(int i=1; i<rowCount; i++) {
			
			data[i-1][0] = ExcelUtils.getCellData(i, 0);	// Username
			data[i-1][1] = ExcelUtils.getCellData(i, 1);	// Password
		}
		ExcelUtils.closeExcel();
		return data;
	}
	
	
//	@DataProvider(name="LoginData2")
//	public Object[][] getData(){
//		
//		return new Object[][] {
//			{"user1","pass1"},
//			{"user2","pass2"},
//			{"user3","pass3"}
//		};
//}
	
//	@Test(dataProvider = "LoginData")                          //excel
	
//	@Test(dataProvider = "LoginData2")                         // local
	
	@Test                                                      // testng.xml
	@Parameters({"username","password"})
	
//	@Test
	public void testValidLogin(String username,String password)
	{
		Log.info("Starting LoginTest");
		test = ExtentReportManager.createTest("Login Test with valid Credentials");
		
		test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);
		
		Log.info("Enter the username");
		test.info("Adding Credentails");
		
//		loginPage.enterUsername("admin@yourstore.com");
		loginPage.enterUsername(username);
		
		Log.info("Enter the password");
		
		
//		loginPage.enterPassword("admin");
		loginPage.enterPassword(password);
		
		Log.info("Click the Login btn");
		test.info("Clicking on Login button");
		loginPage.clickLogin();
		
		System.out.println("Title is" +driver.getTitle());
		Log.info("Verifying the title");
		
		test.pass("Login Successful");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
	}
	
	
	
//	@Test
//	public void testLoginWithInvalidCredentials() {
//
//		Log.info("Starting login test...");
//		test = ExtentReportManager.createTest("Login Test with Invalid Credentials");
//
//		test.info("Navigating to URL");
//		LoginPage loginPage = new LoginPage(driver);
//
//		Log.info("Adding credentials");
//		test.info("Adding Credentails");
//		loginPage.enterUsername("admin1234@yourstore.com");
//		loginPage.enterPassword("admin123");
//		test.info("Clicking on Login button");
//		loginPage.clickLogin();
//
//		System.out.println("Title of the page is : " + driver.getTitle());
//		Log.info("Verifying page title");
//		test.info("Verifying page title");
//		Assert.assertEquals(driver.getTitle(), "Just a moment...123");
//
//
//	}

}
