package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LeavePage {
	WebDriver dr;
	String urlLink="",userName,passWord;

	public LeavePage(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(how=How.XPATH,using ="//input[@name='username']")
	WebElement username;
	
	@FindBy(how=How.XPATH,using ="//input[@name='password'] ")
	WebElement password;
	
	@FindBy(how=How.XPATH,using = "//button[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//ul[@class ='oxd-main-menu']/li[3]")
	WebElement leaveElement;
	
	@FindBy(xpath="//div[@class='oxd-topbar-body']/nav/ul/li[1]")
	WebElement selectApply;
	
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
	WebElement applyPage;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	List<WebElement> dropdownList;
	
	@FindBy(xpath="//div[@role='listbox']/div[2]")
	WebElement leaveType;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-leave-balance-text']")
	WebElement leaveBalance;
	
	@FindBy(xpath="//div[@class='oxd-date-input']/input")
	List<WebElement> dates;

	@FindBy(xpath="//div[@role='listbox']/div[1]")
	WebElement fullDay;
	
	@FindBy(xpath="//div[@role='listbox']/div[2]")
	WebElement halfDayMorning;
	
	@FindBy(xpath="//div[@role='listbox']/div[3]")
	WebElement halfDayAfternoon;
	
	@FindBy(xpath="//div[@role='listbox']/div[4]")
	WebElement specifyTime;
	
	@FindBy(xpath="//label[@class='oxd-label oxd-input-field-required']")
	List<WebElement> labels;
	
	@FindBy(xpath="//div[@role='listbox']/div")
	List<WebElement> partialdaysdropdown;
	
	/*@FindBy(xpath="//div[@role='listbox']/div[2]")
	WebElement allDay;
	
	@FindBy(xpath="//div[@role='listbox']/div[3]")
	WebElement startDayOnly;
	
	@FindBy(xpath="//div[@role='listbox']/div[4]")
	WebElement endDayOnly;
	
	@FindBy(xpath="//div[@role='listbox']/div[5]")
	WebElement startAndEndDay;*/
	
	@FindBy(xpath="//input[@placeholder='hh:mm']")
	List<WebElement> timeList;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-leave-duration']")
	WebElement duration;
	
	@FindBy(xpath="//div[@class='oxd-date-input']/input")
	List<WebElement> datesInputs;
	
	@FindBy(xpath="//div[@class='oxd-form-row']/div/div/div/div[2]/textarea")
	WebElement comment;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement applyButton;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	List<WebElement> requiredErros;
	
	//using java properties file to read common values
	public void loadProperties() throws IOException {
		Properties p = new Properties();
		FileInputStream fin = new FileInputStream("C:\\Users\\ambat\\eclipse-workspace\\QA_Assignment\\src\\test\\resources\\config\\OrangeHRM.properties");
		p.load(fin);
		urlLink = p.getProperty("url");
		userName = p.getProperty("uname");
		passWord = p.getProperty("pwrd");
	}
		
	public void launchLoginPage() {
		dr.get(urlLink);
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String s = dr.getTitle();
		Assert.assertEquals(s, "OrangeHRM");
		System.out.println("User is on the login page");
	}
		
	public void enterUsername() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(userName);
	}
		
	public void enterPassword() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(passWord);
	}
		
	public void clickOnLoginButton() {
		loginButton.click();
		System.out.println("Clicked on login button");
	}
	
	public void selectLeave() {
		leaveElement.click();
	}
	
	public void clickOnApply() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(selectApply));
		selectApply.click();
	}
	
	public void verifyApplyPageTitle() {
		Assert.assertEquals(true,applyPage.isDisplayed());
		System.out.println("User is one the Apply Page");
	}
	
	public void selectLeaveType() {
		dropdownList.get(0).click();
		leaveType.click();
	}
	
	public void verifyLeaveBalance() {
		String s = leaveBalance.getText();
		if(s.equals("0:00 Day(s)"))
			System.out.println("Leaves not available");
		else
			System.out.println("Leaves available");
	}
	
	public void enterSameDates(String fromDate, String toDate) {
		WebElement e = dates.get(0);
		e.click();
		e.clear();
		e.sendKeys(fromDate);
		WebElement e1 = dates.get(1);
		e1.click();
		e1.click();
	}
	
	public void enterDiffDates(String fromDate,String toDate){
		WebElement e = dates.get(0);
		e.click();
		e.clear();
		e.sendKeys(fromDate);
		e.click();
		WebElement e1 = dates.get(1);
		e1.click();
		e1.sendKeys(Keys.CONTROL + "a");
		e1.sendKeys(Keys.DELETE);
		e1.sendKeys(toDate);
		e1.click();
		
	}
	
	public void clickonDurationDropdown() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(dropdownList.get(1)));
		dropdownList.get(1).click();
	}
	
	public void startDayDropdown() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(dropdownList.get(2)));
		dropdownList.get(2).click();
	}
	
	public void endDayDropdown() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(dropdownList.get(3)));
		dropdownList.get(3).click();
	}
	
	
	public void selectFullDayDuration() {
		fullDay.click();
	}
	
	public void selectHalfDayMrngDuration() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(halfDayMorning));
		halfDayMorning.click();
	}
	
	public void selectHalfDayAftrnDuration() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(halfDayAfternoon));
		halfDayAfternoon.click();
	}
	
	public void selectSpecifyTimeDuration() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(specifyTime));
		specifyTime.click();
	}
	
	public void verifyFromToFields() {
		int s = labels.size();
		Assert.assertEquals(5, s);
	}
	
	
	public void verifyDuration() {
		Assert.assertEquals(true,duration.isDisplayed());
	}
	
	public void diffDatesSelectPartialDays() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(dropdownList.get(1)));
		WebElement e =dropdownList.get(1);
		e.click();
		System.out.println("Clicked on partial link dropdown");
	}
	
	
	public void selectAllDays() {
		JavascriptExecutor js = (JavascriptExecutor)dr;
		js.executeScript("window.scrollBy(0,250)");
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(partialdaysdropdown.get(1)));
		//dropdownList.get(1).click();
		//allDays.click();
		partialdaysdropdown.get(1).click();
	}
	
	public void selectStartDayOnly() {
		JavascriptExecutor js = (JavascriptExecutor)dr;
		js.executeScript("window.scrollBy(0,250)");
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(partialdaysdropdown.get(2)));
		//dropdownList.get(1).click();
		//startDayOnly.click();
		partialdaysdropdown.get(2).click();
	}
	
	public void selectEndDayOnly() {
		JavascriptExecutor js = (JavascriptExecutor)dr;
		js.executeScript("window.scrollBy(0,250)");
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(partialdaysdropdown.get(3)));
		//dropdownList.get(1).click();
		//endDayOnly.click();
		partialdaysdropdown.get(2).click();
	}
	
	public void selectStartAndEndDay() {
		JavascriptExecutor js = (JavascriptExecutor)dr;
		js.executeScript("window.scrollBy(0,250)");
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(partialdaysdropdown.get(4)));
		//dropdownList.get(1).click();
		//startAndEndDay.click();
		partialdaysdropdown.get(4).click();
	}
	public void verifyStartAndEndDayDropdowns() {
		int s = labels.size();
		Assert.assertEquals(s, 5);
	}
	
	public void diffDatesSelectDurationType() {
		dropdownList.get(2).click();
	}
	
	public void enterTimes(String fromTime, String toTime) {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(timeList.get(0)));
		WebElement e = timeList.get(0);
		e.click();
		e.sendKeys(Keys.CONTROL+"a");
		e.sendKeys(Keys.DELETE);
		e.sendKeys(fromTime);
		e.click();
		
		WebElement e1 = timeList.get(1);
		e1.click();
		e1.sendKeys(Keys.CONTROL+"a");
		e1.sendKeys(Keys.DELETE);
		e1.sendKeys(toTime);
		e1.click();
	}
	
	public void addComment(String text) {
		comment.sendKeys(text);
	}
	
	public void verifyApplyPage() {
		Assert.assertEquals(true, applyPage.isDisplayed());
		System.out.println("Apply leave page is displayed");
	}
	
	public void fromDateDropdown(String date) {
		WebElement e = datesInputs.get(0);
		e.sendKeys(date);
	}
	
	public void toDateDropdown(String date) {
		WebElement e = datesInputs.get(1);
		e.sendKeys(date);
	}
	
	public void clickOnApplyButton() {
		applyButton.click();
	}
	
	public void verifyErrors() {
		int s = requiredErros.size();
		Assert.assertEquals(s, 2);
	}
}
