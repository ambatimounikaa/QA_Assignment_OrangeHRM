package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyInfoPage {
	
	WebDriver dr;
	String urlLink="",userName,passWord;

	public MyInfoPage(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(how=How.XPATH,using ="//input[@name='username']")
	WebElement username;
	
	@FindBy(how=How.XPATH,using ="//input[@name='password'] ")
	WebElement password;
	
	@FindBy(how=How.XPATH,using = "//button[@type='submit']")
	WebElement loginButton;
	
	@FindBy(how=How.TAG_NAME,using="h6")
	WebElement heading;
	
	@FindBy(xpath="//ul[@class='oxd-main-menu']/li[6]")
	WebElement myInfo;
	
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']/h6")
	WebElement myInfoPageHeading;
	
	@FindBy(xpath="//div[@role='tab'][1]")
	WebElement personalDetails;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/h6")
	WebElement personalDetailsDashboard;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastname;
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters']/div[1]/div[2]/input")
	List<WebElement> idAndNumbers;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	List<WebElement> dropdowns;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-up-fill oxd-select-text--arrow']")
	WebElement dropdownClose;
	
	
	@FindBy(xpath="//div[@role='listbox']/div")
	List<WebElement> dropdownValues;
	
	@FindBy(xpath="//input[@placeholder='yyyy-dd-mm']")
	List<WebElement> dates;
	
	@FindBy(xpath="//input[@value='1']")
	WebElement maleRadioButton;
	
	@FindBy(xpath="//input[@value='2']")
	WebElement femaleRadioButton;
	
	@FindBy(xpath="//div[@role='tab'][2]")
	WebElement contactDetails;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/h6")
	WebElement contactDetailsDashboard;
	
	@FindBy(xpath="//div[@role='tab'][3]")
	WebElement emergencyContacts;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/div/h6")
	WebElement emergencyContactsDashboard;
	
	@FindBy(xpath="//div[@class='orangehrm-action-header']/button")
	List<WebElement> buttons;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/h6")
	WebElement saveEmergencyContact;
	
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']/div[2]/input")
	List<WebElement> emergencyContactsInputs;
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters']/div/div[2]/input")
	List<WebElement> contactsDetailsInputs;
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	List<WebElement> errorsOfPersonalDetails;
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	List<WebElement> errorsOfContactDetails;
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	List<WebElement> errorsOfEmergencyContact;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;
	
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
		
		public void verifyDashboard() {
			WebDriverWait wait = new WebDriverWait(dr,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(heading));
			String s = heading.getText();
			Assert.assertEquals(s, "Dashboard");
		}
	
	public void clickOnMyInfo() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(myInfo));
		myInfo.click();
	}
	
	public void verifyMyInfoPage() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(myInfoPageHeading));
		Assert.assertEquals(true, myInfoPageHeading.isDisplayed());
	}
	
	public void clickOnPersonalDetails() {
		personalDetails.click();
	}
	
	public void verifyPersonalDetailsDashboard() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(personalDetailsDashboard));
		Assert.assertEquals(true, personalDetailsDashboard.isDisplayed());
	}
	
	public void enterFirstname(String fname) {
		firstname.click();
		firstname.sendKeys(Keys.CONTROL+"a");
		firstname.sendKeys(Keys.DELETE);
		firstname.sendKeys(fname);
	}
	
	public void enterLastname(String lname) {
		lastname.click();
		lastname.sendKeys(Keys.CONTROL+"a");
		lastname.sendKeys(Keys.DELETE);
		lastname.sendKeys(lname);
	}
	
	public void enterEmployeeId(String eid) {
		WebElement id = idAndNumbers.get(0);
		id.click();
		id.sendKeys(Keys.CONTROL+"a");
		id.sendKeys(Keys.DELETE);
		id.sendKeys(eid);
	}
	
	public void enterOtherId(String oid) {
		WebElement id = idAndNumbers.get(1);
		id.click();
		id.sendKeys(Keys.CONTROL+"a");
		id.sendKeys(Keys.DELETE);
		id.sendKeys(oid);
	}
	
	public void enterLicenseNumber(String lNum) {
		WebElement id = idAndNumbers.get(2);
		id.click();
		id.sendKeys(Keys.CONTROL+"a");
		id.sendKeys(Keys.DELETE);
		id.sendKeys(lNum);
	}
	
	public void enterLicenseExpiryDate(String d) {
		WebElement expiryDate = dates.get(0);
		expiryDate.click();
		expiryDate.sendKeys(Keys.CONTROL+"a");
		expiryDate.sendKeys(Keys.DELETE);
		expiryDate.sendKeys(d);
		expiryDate.click();
	}
	
	public void enterDob(String d) {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(dates.get(1)));
		WebElement dob = dates.get(1);
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].click();", dob);
		//dob.click();
		dob.sendKeys(Keys.CONTROL+"a");
		dob.sendKeys(Keys.DELETE);
		dob.sendKeys(d);
		dob.click();
	}
	
	public void selectNationality() {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		dropdowns.get(0).click();
		js.executeScript("arguments[0].scrollIntoView(true);",dropdownValues.get(82));
		dropdownValues.get(82).click();
		js.executeScript("window.scrollBy(0,-80)");
	}
	
	public void clickOnSaveButton() {
		save.click();
	}
	
	public void clickOnContactDetails() {
		contactDetails.click();
	}
	
	public void verifyContactDetailsDashboard() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(contactDetailsDashboard));
		Assert.assertEquals(true, contactDetailsDashboard.isDisplayed());
	}
	
	public void enterStreetOne(String street1) {
		WebElement e = contactsDetailsInputs.get(0);
		e.sendKeys(street1);
	}
	
	public void enterStreetTwo(String street2) {
		WebElement e = contactsDetailsInputs.get(1);
		e.sendKeys(street2);
	}
	
	public void enterCity(String city) {
		WebElement e = contactsDetailsInputs.get(2);
		e.sendKeys(city);
	}
	
	public void enterZip(String zip) {
		WebElement e = contactsDetailsInputs.get(4);
		e.sendKeys(Keys.CONTROL+"a");
		e.sendKeys(Keys.DELETE);
		e.sendKeys(zip);
	}
	
	public void enterState(String state) {
		WebElement e = contactsDetailsInputs.get(3);
		e.sendKeys(state);
	}
	
	public void enterWorkEmail(String wemail) {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("window.scrollBy(0,200)");
		WebElement e = contactsDetailsInputs.get(8);
		String s = wemail+"@orghrm.com";
		e.click();
		e.sendKeys(Keys.CONTROL+"a");
		e.sendKeys(Keys.DELETE);
		e.sendKeys(s);
	}
	
	public void enterInvalidEmail(String email) {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("window.scrollBy(0,200)");
		WebElement e = contactsDetailsInputs.get(8);
		e.click();
		e.sendKeys(Keys.CONTROL+"a");
		e.sendKeys(Keys.DELETE);
		e.sendKeys(email);
	}
	
	public void enterOtherEmail(String oemail) {
		WebElement e = contactsDetailsInputs.get(9);
		String s = oemail+"@orghrm.com";
		e.sendKeys(Keys.CONTROL+"a");
		e.sendKeys(Keys.DELETE);
		e.sendKeys(s);
	}
	
	public void clickOnEmergencyContacts() {
		emergencyContacts.click();
	}
	
	public void verifyEmergencyContactsDashboard() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(emergencyContactsDashboard));
		Assert.assertEquals(true, emergencyContactsDashboard.isDisplayed());
	}
	

	public void clickOnAddButton() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(buttons.get(0)));
		WebElement addButton = buttons.get(0);
		addButton.click();
	}
	
	public void enterName(String name) {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(emergencyContactsInputs.get(0)));
		WebElement n = emergencyContactsInputs.get(0);
		n.sendKeys(name);
	}
	
	public void enterRelationship(String relation) {
		WebElement n = emergencyContactsInputs.get(1);
		n.sendKeys(relation);
	}
	
	public void enterMobile(String mobile) {
		WebElement n = emergencyContactsInputs.get(3);
		n.sendKeys(Keys.CONTROL+"a");
		n.sendKeys(Keys.DELETE);
		n.sendKeys(mobile);
	}
	
	public void clickOneSaveButton() {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].click();",save);
		//save.click();
	}


	public void clearEmergencyContactsFields() {
		WebElement n = emergencyContactsInputs.get(0);
		n.sendKeys(Keys.CONTROL+"a");
		n.sendKeys(Keys.DELETE);
		WebElement n1 = emergencyContactsInputs.get(1);
		n1.sendKeys(Keys.CONTROL+"a");
		n1.sendKeys(Keys.DELETE);
		WebElement n2 = emergencyContactsInputs.get(3);
		n2.sendKeys(Keys.CONTROL+"a");
		n2.sendKeys(Keys.DELETE);
	}
	

	public void verifySaveEmergencyContact() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(saveEmergencyContact));
		Assert.assertEquals(true, saveEmergencyContact.isDisplayed());
	}


	public void emptyEmployeeFullName() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(15));
		w.until(ExpectedConditions.visibilityOf(firstname));
		firstname.click();
		firstname.sendKeys(Keys.CONTROL+"a");
		firstname.sendKeys(Keys.DELETE);
		lastname.click();
		lastname.sendKeys(Keys.CONTROL+"a");
		lastname.sendKeys(Keys.DELETE);
	}

	public void verifyErrorsofEmergencyContacts() {
		// TODO Auto-generated method stub
		int n = errorsOfEmergencyContact.size();
		for(WebElement i:errorsOfEmergencyContact)
		System.out.println(i.getText());
	}

	public void verifyErrorsofContactDetails() {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true);",firstname);
		int n = errorsOfContactDetails.size();
		for(WebElement i:errorsOfContactDetails)
			System.out.println(i.getText());
	}

	public void verifyErrorsofPersonalDetails() {
		// TODO Auto-generated method stub
		int n = errorsOfPersonalDetails.size();
		for(WebElement i:errorsOfPersonalDetails)
		System.out.println(i.getText());
	}


	
	
}
