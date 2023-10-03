package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPom extends BaseClass {
	
	public LoginPom() {

		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(how=How.ID, using="username")
	private WebElement userName;

	public WebElement getUserName() {
		return userName;
	}
	
	@FindBy(how=How.ID, using="password")
	private WebElement passWord;

	public WebElement getPassWord() {
		return passWord;
	}
	
	@FindBy(how = How.ID, using = "login")
	private WebElement login;	
	
	public WebElement getLogin() {
		return login;	
	}
	
	
	@FindBy(how = How.XPATH, using = "//td[text()='Search Hotel ']")
	private WebElement searchHotel;

	public WebElement getHotel() {
		return searchHotel;
	}	
	
	@FindBy(how = How.XPATH, using = "//a[text()='Reserve']")
	private WebElement reserve;

	public WebElement getReserve() {
		return reserve;
	}	
	
	@FindBy(how = How.XPATH, using = "(//a[text()='Reserve room'])[1]")
	private WebElement reserveroom;

	public WebElement getReserveRoom() {
		return reserveroom;
	}
	
	@FindBy(how = How.ID, using = "date")
	private WebElement checkin;

	public WebElement getCheckin() {
		return checkin;
	}
	
	@FindBy(how = How.XPATH, using = "//button[text()='Done']")
	private WebElement done;

	public WebElement getDone() {
		return done;
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'15')]")
	private WebElement date;

	public WebElement getDate() {
		return date;
	}
	
	@FindBy(how = How.ID, using = "term")
	private WebElement stay;

	public WebElement getStay() {
		return stay;
	}
	
	@FindBy(how = How.ID, using = "head-count")
	private WebElement guest;

	public WebElement getGuest() {
		return guest;
	}
	
	@FindBy(how = How.ID, using = "breakfast")
	private WebElement checkBox;

	public WebElement getCheckBox() {
		return checkBox;
	}
	
	@FindBy(how = How.NAME, using = "username")
	private WebElement customerName;

	public WebElement getName() {
		return customerName;
	}
	
	@FindBy(how = How.NAME, using = "contact")
	private WebElement confirm;

	public WebElement getConfirmation() {
		return confirm;
	}
	
	@FindBy(how = How.NAME, using = "comment")
	private WebElement specialRequest;

	public WebElement getRequest() {
		return specialRequest;
	}
		
	@FindBy(how = How.XPATH, using = "//button[text()='Confirm Reservation']")
	private WebElement confirmReserve;

	public WebElement getConfirmReserve() {
		return confirmReserve;
	}
	
	@FindBy(how = How.XPATH, using = "//button[text()='Submit Reservation']")
	private WebElement submitreservel;

	public WebElement getSubmitReserve() {
		return submitreservel;
	}
	
	@FindBy(how = How.XPATH, using = "//button[text()='Close']")
	private WebElement close;

	public WebElement getCloseEnd() {
		return close;
	}
	
	
	
	
}