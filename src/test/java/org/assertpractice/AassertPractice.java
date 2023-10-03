package org.assertpractice;

import java.time.Duration;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.pom.LoginPom;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AassertPractice extends BaseClass {
	
public static BaseClass b = new BaseClass();
	
	public static LoginPom pom;
	
	@Test(priority=0)
	private void launchBrowser() {
		try {
		
			b.getDriver("Edge");
			b.windowsMax();
			System.out.println("Browser Launched Successfully");
//			Report - Browser Launched Successfully
	}  catch (Exception e) {
			System.out.println("Browser Launched Successfully");
			//	Report - Browser Not Launched Successfully - Failure - Screenshot
	}	
	}
	
	@Test(priority=1)
	private void launchUrl() {
		try {
			b.getUrl("http://adactinhotelapp.com/");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));	
			System.out.println("URL Launched Successfully");
//			Report - URL Launched Successfully
	} 	catch (Exception e) {
			System.out.println("URL Launched Successfully");
			//	Report - URL Not Launched Successfully - Failure - Screenshot
	}

	}
	
	@Test(priority=2)
	private void loginDatas() {
		try {
			
			System.out.println("Adactin Hotel login Webpage Inspected By USing Valid Credentials");
//			Report - Test Started - Adactin Hotel login Webpage Inspected By USing Valid Credentials
			
			pom = new LoginPom();
			
			WebElement userName = pom.getUserName();
			userName.sendKeys(b.excelRead(1, 0));
			
			WebElement passWord = pom.getPassWord();
			passWord.sendKeys(b.excelRead(1, 1));
			
			System.out.println("Login Data Entered Successfully");
//			Report - Login Data Entered Successfully
	} 	catch (Exception e) {
			System.out.println("Login Data Entered Not Successfully");
			//	Report - Login Data Entered Not Successfully
	}
	}
	
	@Test(priority=3)
	private void loginComplete() {
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
	}
	
	@Test(priority=4)
	private void searchHotel() {
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
