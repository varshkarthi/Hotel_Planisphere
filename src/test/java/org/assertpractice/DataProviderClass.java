package org.assertpractice;

import java.time.Duration;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.pom.LoginPom;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderClass extends BaseClass {
	
	public static BaseClass b = new BaseClass();
	
	public static LoginPom pom;
	
	@DataProvider(name="Login")
	private Object[][] getLoginDatas(){
		
		return new Object[][] {
			
			{ excelRead(0, 0), excelRead(0, 1)},
			{ excelRead(1, 0), excelRead(1, 1)},
			{ excelRead(2, 0), excelRead(2, 1)},
			{ excelRead(3, 0), excelRead(3, 1)},			
		};	
	}	
		
	@Test(dataProvider="Login")
	private void adactionTest(String user, String pass) {
		try {
		
			b.getDriver("Edge");
			b.windowsMax();
			System.out.println("Browser Launched Successfully");
//			Report - Browser Launched Successfully
	}  catch (Exception e) {
			System.out.println("Browser Launched Successfully");
			//	Report - Browser Not Launched Successfully - Failure - Screenshot
	}	
	
		try {
			b.getUrl("http://adactinhotelapp.com/");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));	
			System.out.println("URL Launched Successfully");
//			Report - URL Launched Successfully
	} 	catch (Exception e) {
			System.out.println("URL Launched Successfully");
			//	Report - URL Not Launched Successfully - Failure - Screenshot
	}

	
		try {
			
			System.out.println("Adactin Hotel login Webpage Inspected By USing Valid Credentials");
//			Report - Test Started - Adactin Hotel login Webpage Inspected By USing Valid Credentials
			
			pom = new LoginPom();
			
			WebElement userName = pom.getUserName();
			userName.sendKeys(user);
			
			WebElement passWord = pom.getPassWord();
			passWord.sendKeys(pass);
			
			System.out.println("Login Data Entered Successfully");
//			Report - Login Data Entered Successfully
	} 	catch (Exception e) {
			System.out.println("Login Data Entered Not Successfully");
			//	Report - Login Data Entered Not Successfully
	}
	
		try {
			
			pom = new LoginPom();
			
			WebElement login = pom.getLogin();
			b.buttonClick(login);
			System.out.println("Login Successfully");
//			Report - Login Successfully
	} 	catch (Exception e) {
		System.out.println("Login Not Successfully");
//		Report - Login Not Successfully - Failure - Screenshot
	}

		try {
			
			pom = new LoginPom();
			
			WebElement hotel = pom.getHotel();
//			Use Assert
			
			boolean displayed = hotel.isDisplayed();
			
			Assert.assertTrue(displayed);
//			Assert.assertFalse(displayed);
			Assert.assertEquals(displayed, true);
			Assert.assertNotEquals(displayed, false);
			
//			Assert.assertTrue(true);
			
			System.out.println("Search Hotel Element is Present");			
			
//			Use IF
//			if(hotel.isDisplayed()) {
//				System.out.println("Search Hotel Element is Present");
////				Report Webpage Navigated to Search Hotel Page
//			} else {
//				System.out.println("Search Hotel Element is Not Present");
////				Report Webpage Not Navigated to Search Hotel Page
//			}
			
	} 	catch (Exception e) {
			
	}

	}
	

}
