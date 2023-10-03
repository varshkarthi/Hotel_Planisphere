package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.privilege.GetMethodAction;

public class BaseClass {

	public static WebDriver driver;

	public void getDriver(String browser) {
		try {
			switch (browser) {
			case "Chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case "Edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			default:
				System.out.println("In-valid Browser Type");
				break;
			}

		} catch (Exception e) {

		}
	}

	public void getUrl(String url) {
		driver.get(url);
	}

	public void windowsMax() {
		driver.manage().window().maximize();
	}

	public void gettextSend(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}

	public void buttonClick(WebElement element) {
		element.click();
	}

	public WebElement getLocator(String locator, String pathway) {
		try {
			switch (locator) {
			case "id":
				WebElement findelement = driver.findElement(By.id(pathway));
				return findelement;

			case "name":
				WebElement findelement1 = driver.findElement(By.name(pathway));
				return findelement1;

			default:
				System.out.println("In-valid locator");
				break;
			}
			return null;

		} catch (Exception e) {

		}
		return null;
	}

	public WebElement xpath(String Pathway) {
		WebElement findelement = driver.findElement(By.xpath(Pathway));
		return findelement;
	}

	public void selectByIndex(WebElement string, int text) {
		Select S = new Select(string);
		S.selectByIndex(text);
	}

	public void getSelect(WebElement element, String Select, String enter) {
		Select s = new Select(element);

		switch (Select) {
		case "Text":
			s.selectByVisibleText(enter);
			break;

		case "value":
			s.selectByValue(enter);
			break;
		default:
			System.out.println("No Select");
			break;
		}
	}

	public void getThread(int sec) throws InterruptedException {
		Thread.sleep(sec);
	}

	public static void screenShot(String Name) {
		try {

			TakesScreenshot ts = (TakesScreenshot) driver;

			File SourceFile = ts.getScreenshotAs(OutputType.FILE);

			File TargetFile = new File("C:\\Users\\Admin\\Pictures\\Selenium\\" + Name + ".png");

			FileUtils.copyFile(SourceFile, TargetFile);

		} catch (Exception e) {

		}
	}
	
	public static String screenCapture(WebDriver driver) {
		
		String errorfilepath = null;
		try {
			
			File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File DestFile = new File("src/../ErrorImages/"+ System.currentTimeMillis() + ".png");
			
			errorfilepath = DestFile.getAbsolutePath();
			FileUtils.copyFile(SourceFile, DestFile);
			
		} catch (Exception e) {
			
		}
		return errorfilepath;
	}

	public void getPressKey(int keycode) throws AWTException {

		Robot r = new Robot();
		r.keyPress(keycode);
	}

	public void getReleaseKey(int keycode) throws AWTException {

		Robot r = new Robot();
		r.keyRelease(keycode);
	}

	public void getAlert(String Alert) {
		try {
			switch (Alert) {
			case "accept":
				driver.switchTo().alert().accept();
				break;
			case "dismiss":
				driver.switchTo().alert().dismiss();
				break;
			case "promtOk":
				driver.switchTo().alert().sendKeys("OK");
				break;
			case "promtCancel":
				driver.switchTo().alert().sendKeys("cancel");
				break;
			default:
				System.out.println("No Alert");
				break;
			}
		} catch (Exception e) {

		}

	}

	public void getActions(WebElement element) {

		Actions a = new Actions(driver);

		a.moveToElement(element).build().perform();
		return;
	}

	public void getDragDrop(WebElement SourceElement, WebElement TargetElement) {

		Actions a = new Actions(driver);

		a.dragAndDrop(SourceElement, TargetElement).perform();

	}

	public void getDoubleClick(WebElement target) {

		Actions a = new Actions(driver);

		a.doubleClick(target).perform();
	}

	public void getRightClick(WebElement Target) {

		Actions a = new Actions(driver);

		a.contextClick(Target).perform();

	}

	public void getScroll(String scroll, WebElement element) {
		try {

			JavascriptExecutor JS = (JavascriptExecutor) driver;

			switch (scroll) {
			case "false":
				JS.executeScript("arguments[0].scrollIntoView(false)", element);
				break;

			case "true":
				JS.executeScript("arguments[0].scrollIntoView(true)", element);
				break;

			default:
				System.out.println("No Scrolling");
				break;
			}

		} catch (Exception e) {

		}

	}

	public void gettextSendJS(String textvalue, WebElement element) {
		try {

			JavascriptExecutor JS = (JavascriptExecutor) driver;

			JS.executeScript("arguments[0].setAttribute('value','" + textvalue + "')", element);
		} catch (Exception e) {

		}
	}

	public void getWindowsHandle(int index) {
		try {

			String parentWindowsID = driver.getWindowHandle();
			Set<String> allWindowsID = driver.getWindowHandles();

			List<String> li = new LinkedList<String>();
			li.addAll(allWindowsID);

			String ChildWindowsID = li.get(index);
			driver.switchTo().window(ChildWindowsID);
			System.out.println(index + "ChildWindows ID : " + ChildWindowsID);

		} catch (Exception e) {

		}

	}

	// Excel File Read

	public String excelRead(int rownum, int cellnum) {

		try {
			File file = new File("E:\\Framework\\ReadExel.xlsx");

			FileInputStream stream = new FileInputStream(file);

			Workbook book = new XSSFWorkbook(stream);

			Sheet sheet = book.getSheet("Sheet1");

			Row row = sheet.getRow(rownum);

			Cell cell = row.getCell(cellnum);

			CellType cellType = cell.getCellType();

			String value = null;

			switch (cellType) {

			case STRING:

				value = cell.getStringCellValue();

				break;

			case NUMERIC:

				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MMMM/yyyy");
					value = simpleDateFormat.format(dateCellValue);

				} else {

					double numericCellValue = cell.getNumericCellValue();

					long l = (long) numericCellValue;
					BigDecimal valueOf = BigDecimal.valueOf(l);
					value = valueOf.toString();
				}

				break;

			default:
				System.out.println("In Valid Cell Format");
				break;
			}

			return value;

		} catch (Exception e) {

		}

		return null;

	}

}
