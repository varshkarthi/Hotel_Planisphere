package org.planisphrer;

import java.time.Duration;
import java.util.Set;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.pom.LoginPagePom;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestingClassEdge extends BaseClass {

	public static BaseClass b = new BaseClass();

	public static LoginPagePom pom;

	public static ExtentSparkReporter spark = new ExtentSparkReporter("HotelPlaniSphere.html");

	public static ExtentReports extend = new ExtentReports();

	public static ExtentTest test = extend.createTest("Automate The Hoel Planisphere Webpage");

	@BeforeTest
	private void before() {
		extend.attachReporter(spark);
	}

	@AfterTest
	private void after() {
		extend.flush();
	}

	@Parameters({ "browser" })
	@Test(priority = 0)
	public static void getBrowser(String browserType) {
		try {

			test.assignAuthor("Karthikeyan S");
			test.assignCategory("Smoke Test");
			test.assignDevice("Edge");

			b.getDriver(browserType);
			b.windowsMax();
//			System.out.println("Browser Launched Successfully");

			test.log(Status.PASS, "Browser Launched Successfully");
			test.addScreenCaptureFromPath(screenCapture(driver)); 

		} catch (Exception e) {
//			System.out.println("Browser Not Launched Successfully");

			test.log(Status.FAIL, "Browser Not Launched Successfully" + e.getMessage());

		}

	}

	@Test(priority = 1)
	public void urlLanunched() {
		try {

			b.getUrl("https://hotel.testplanisphere.dev/en-US/index.html");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//			System.out.println("URL Launched Successfully");

			test.log(Status.PASS, "Url Launched Successfully");
			test.addScreenCaptureFromPath(screenCapture(driver));
			
		} catch (Exception e) {
//			System.out.println("URL Not Launched Successfully");

			test.log(Status.FAIL, "Url Not Launched Successfully" + e.getMessage());

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

//			System.out.println("LoginData Entered Successfully");
			test.log(Status.PASS, "LoginData Entered Successfully");
			test.addScreenCaptureFromPath(screenCapture(driver));

		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("LoginData not Entered Successfully");
			test.log(Status.FAIL, "LoginData not Entered Successfully" + e.getMessage());
		}
	}

	@Test(priority = 3)
	public void reserveRoom() {
		try {

			pom = new LoginPagePom();

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

//			System.out.println("Reserve Clicked Successfully");

			test.log(Status.PASS, "Reserve Clicked Successfully");
			test.addScreenCaptureFromPath(screenCapture(driver));

		} catch (Exception e) {
//			System.out.println("Reserve not Clicked Successfully");

			test.log(Status.FAIL, "Reserve not Clicked Successfully" + e.getMessage());
		}
	}

	@Parameters({ "date" })
	@Test(priority = 4)
	public static void reserveConfirmation(String dateOrder) {
		try {

			pom = new LoginPagePom();

			WebElement reserveRoom = pom.getReserveRoom();
			reserveRoom.click();

			String Window = driver.getWindowHandle();
			Set<String> windowHandles = driver.getWindowHandles();

			for (String x : windowHandles) {
				if (!Window.equals(x)) {
					driver.switchTo().window(x);
				}
			}

			b.getThread(4000);

			WebElement checkin = pom.getCheckin();
			b.buttonClick(checkin);
			checkin.clear();
			b.gettextSend(checkin, dateOrder);

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
			b.getAlert("accept");

//			System.out.println("Room Reserved Successfully");

			test.log(Status.PASS, "Reserve Confirmation Successfully");
			test.addScreenCaptureFromPath(screenCapture(driver));

		} catch (Exception e) {
//			System.out.println("Room not Reserved Successfully");

			test.log(Status.FAIL, "Reserve Confirmation Successfully" + e.getMessage());
		}
	}
}
