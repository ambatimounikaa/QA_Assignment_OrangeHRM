package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.*;
import java.io.*;
import java.time.Duration;

public class LoginPage {
	WebDriver dr;
	String urlLink ="";

	public LoginPage(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(how=How.XPATH,using ="//input[@name='username']")
	WebElement username;
	
	@FindBy(how=How.XPATH,using ="//input[@name='password'] ")
	WebElement password;
	
	@FindBy(how=How.XPATH,using = "//button[@type='submit']")
	WebElement loginButton;
	
	@FindBy(how=How.XPATH,using="//div[@role='alert']/div/p")
	WebElement invalidCredentials;
	
	@FindBy(how=How.XPATH,using="//div[@class='oxd-form-row']/div/span")
	WebElement invalidField;
	
	@FindBy(how=How.XPATH,using="//div[@class='oxd-form-row']/div/span")
	List<WebElement> invalidFields;
	
	@FindBy(how=How.XPATH,using ="//div[@class='orangehrm-login-forgot']/p")
	WebElement forgotPasswordLink;
	
	@FindBy(how=How.XPATH,using="//button[@type='submit']")
	WebElement resetPasswordButton;
	
	@FindBy(how=How.TAG_NAME,using="h6")
	WebElement heading;
	
	@FindBy(how=How.XPATH,using="//button[@type='button']")
	WebElement cancelButton;
	
	@FindBy(how=How.TAG_NAME,using="h5")
	WebElement headingOne;
	
	
	
	//using java properties file to read common values
	public void loadProperties() throws IOException {
		Properties p = new Properties();
		FileInputStream fin = new FileInputStream("C:\\Users\\ambat\\eclipse-workspace\\QA_Assignment\\src\\test\\resources\\config\\OrangeHRM.properties");
		p.load(fin);
		urlLink = p.getProperty("url");
	}
	
	public void launchLoginPage() {
		dr.get(urlLink);
		String s = dr.getTitle();
		Assert.assertEquals(s, "OrangeHRM");
		System.out.println("User is on the login page");
	}
	
	public void enterUsername(String userName) {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(userName);
	}
	
	public void enterPassword(String passWord) {
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
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor)dr;
		js.executeScript("window.scrollBy(0,200);");
	}
	public void verifyInvalidCredentials() {
		WebDriverWait w = new WebDriverWait(dr,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(invalidCredentials));
		Assert.assertEquals(true,invalidCredentials.isDisplayed());
	}
	
	public void verifyRequiredFields() {
		int s = invalidFields.size();
		Assert.assertEquals(2, s);
		System.out.println("User got alert message indicating Invalid credentials");

	}
	
	public void verifyUsernameRequired() {
		Assert.assertEquals(true, invalidField.isDisplayed());
		System.out.println("User got error message indicating that username is Required");
	}
	
	public void verifyPasswordRequired() {
		Assert.assertEquals(true, invalidField.isDisplayed());
		System.out.println("User got error message indicating that password is Required");
	}
	public void clickOnforgotPasswordLink() {
		WebDriverWait wait = new WebDriverWait(dr,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(forgotPasswordLink));
		forgotPasswordLink.click();
	}
	
	public void verifyResetPasswordSuccess() {
		WebDriverWait wait = new WebDriverWait(dr,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(heading));
		String actual = heading.getText();
		String expected = "Reset Password link sent successfully";
		Assert.assertEquals(actual,expected);
		System.out.println(expected);
	}
	
	public void verifyLoginPage() {
		WebDriverWait wait = new WebDriverWait(dr,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(headingOne));
		boolean s =headingOne.isDisplayed();
		if(s==true)
		System.out.println("User successfully redirected back to Login page");
	}
	
	public void clickOnResetPasswordButton() {
		resetPasswordButton.click();
		System.out.println("Reset password button is clicked");
	}
	
	public void verifyResetPasswordPage() {
		WebDriverWait wait = new WebDriverWait(dr,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(heading));
		boolean s =heading.isDisplayed();
		if(s==true)
		System.out.println("User successfully redirected to the Reset Password page");
	}
	
	public void clickOnCancelButton() throws InterruptedException {
		cancelButton.click();
		Thread.sleep(2000);
		System.out.println("Clicked on Cancel button");
	}
	
}
