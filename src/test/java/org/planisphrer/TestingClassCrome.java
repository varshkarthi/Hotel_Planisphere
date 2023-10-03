package org.planisphrer;

import java.time.Duration;
import java.util.Set;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.pom.LoginPagePom;
import org.testng.annotations.Test;

public class TestingClassCrome extends BaseClass {

	public static BaseClass b = new BaseClass();

	public static LoginPagePom pom;


	@Test(priority = 0)
	public static void getBrowser() {
		try {

			b.getDriver("Chrome");
			b.windowsMax();
			System.out.println("Browser Launched Successfully");
			//			Report - Browser Launched Successfully			
		} catch (Exception e) {
			System.out.println("Browser Not Launched Successfully");
			//			Report - Browser Not Launched Successfully - Failure - Screenshot			
		}		

	}

	@Test(priority = 1)
	public void urlLanunched() {
		try{

			b.getUrl("https://hotel.testplanisphere.dev/en-US/index.html");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			System.out.println("URL Launched Successfully");
			//			Report - Url Launched Successfully			
		} catch (Exception e) {
			System.out.println("URL Not Launched Successfully");
			//			Report - Url Not Launched Successfully - Failure - Screenshot	
		}

	}

	@Test(priority = 2)
	public void loginDataEntering() {
		try {

			pom = new LoginPagePom();

			WebElement login = pom.getLogin();
			login.click();
			b.getThread(10000);

			WebElement userName = pom.getUserName();
			userName.sendKeys(b.excelRead(0, 0));
			WebElement passWord = pom.getPassWord();
			passWord.sendKeys(b.excelRead(0, 1));

			b.getThread(5000);
			b.screenShot("1.Login");

			System.out.println("LoginData Entered Successfully");
			//			Report - LoginData Entered Successfully			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("LoginData not Entered Successfully");
			//			Report - LoginData not Entered Successfully - Failure - Screenshot
		}
	}

	@Test(priority = 3)
	public void clicklogin() {
		try {

			pom = new LoginPagePom();

			WebElement logins = pom.getLogins();
			logins.click();

			WebElement reserve = pom.getReserve();
			reserve.click();
			b.getThread(2000);

			WebElement staying = pom.getStaying();
			b.getScroll("true", staying);

			b.getThread(5000);

			WebElement hotelPlaniSphere = pom.getHotelPlaniSphere();
			b.getScroll("false", hotelPlaniSphere);

			b.getThread(5000);			

			b.screenShot("2.Reserve Room");

			System.out.println("Reserve Clicked Successfully");
			//			Report - Reserve Clicked Successfully	
		} catch (Exception e) {
			System.out.println("Reserve not Clicked Successfully");
			//			Report - Reserve not Clicked Successfully - Failure - Screenshot
		}
	}

	@Test(priority = 4)
	public static void nextPage() {
		try {

			pom = new LoginPagePom();

			WebElement reserveRoom = pom.getReserveRoom();
			reserveRoom.click();			

			String Window = driver.getWindowHandle();
			Set<String> windowHandles = driver.getWindowHandles();

			for(String x : windowHandles) {
				if(!Window.equals(x)) {
					driver.switchTo().window(x);
				}
			}		

			b.getThread(4000);

			WebElement checkin = pom.getCheckin();
			b.buttonClick(checkin);	
			checkin.clear();
			b.gettextSend(checkin, "09/15/2023");

			b.getThread(3000);			

			WebElement done = pom.getDone();
			done.click();

			WebElement stay = pom.getStay();
			b.buttonClick(stay);
			stay.clear();
			b.gettextSend(stay, b.excelRead(2, 0));

			b.getThread(3000);

			WebElement guest = pom.getGuest();
			b.buttonClick(guest);
			guest.clear();
			b.gettextSend(guest, b.excelRead(2, 1));

			b.getThread(3000);

			WebElement checkBox = pom.getCheckBox();
			checkBox.click();

			b.getThread(3000);

			WebElement name = pom.getName();
			b.gettextSend(name, b.excelRead(3, 0));

			b.getThread(3000);

			WebElement confirmation = pom.getConfirmation();
			confirmation.click();

			b.getThread(3000);

			b.getSelect(confirmation, "value", "no");

			b.getThread(3000);

			WebElement request = pom.getRequest();
			b.gettextSend(request, b.excelRead(4, 0));

			b.getThread(3000);

			WebElement hotelPlaniSphere = pom.getHotelPlaniSphere();
			b.getScroll("false", hotelPlaniSphere);

			b.getThread(5000);
			b.screenShot("3.Confirm Reservation");

			WebElement confirmReserve = pom.getConfirmReserve();
			b.buttonClick(confirmReserve);	

			b.getThread(5000);			
			b.screenShot("4.Submit Reservation");

			WebElement submitReserve = pom.getSubmitReserve();
			b.buttonClick(submitReserve);		

			b.getThread(5000);			
			b.screenShot("5.We look forward to visiting you.");

			WebElement close = pom.getCloseEnd();
			b.buttonClick(close);			

			System.out.println("Room Reserved Successfully");
			//			Report - Room Reserved Successfully	
		} catch (Exception e) {
			System.out.println("Room not Reserved Successfully");
			//			Report - Room not Reserved Successfully - Failure - Screenshot
		}
	}
}
