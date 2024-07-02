package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import PageObjects.LoginPage;
import utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver dr;	
	String excelPath = "src/test/resources/Data/LoginDetails.xlsx";
	
	public LoginSteps() {
		dr = OrangeHRMHooks.dr;
	}
	
	LoginPage lp ;
	
	@Given("The user is on the OrangeHRM Loginpage")
	public void the_user_is_on_the_orange_hrm_loginpage() throws IOException {
		lp = new LoginPage(dr);
		lp.loadProperties();
	    lp.launchLoginPage();
	}

	@When("the user enter {string} and {int} to get the valid username and password")
	public void the_user_enter_and_to_get_the_valid_username_and_password(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String uname = listLogin.get(rNum).get("Username");
		String pwrd = listLogin.get(rNum).get("Password");
		System.out.println(uname+" "+pwrd);
		if(uname!=null || pwrd!=null) {
		lp.enterUsername(uname);
		lp.enterPassword(pwrd);
		}
	}

	@When("click on the login button")
	public void click_on_the_login_button() {
	    lp.clickOnLoginButton();
	}

	@Then("user should be redirected to the OrangeHRM dashboard")
	public void user_should_be_redirected_to_the_orange_hrm_dashboard() {
	   lp.verifyDashboard();
	}


	@When("the user enter the {string} and {int} to get the valid username and invalid password")
	public void the_user_enter_the_and_to_get_the_valid_username_and_invalid_password(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String uname = listLogin.get(rNum).get("Username");
		String pwrd = listLogin.get(rNum).get("Password");
		lp.enterUsername(uname);
		lp.enterPassword(pwrd);
	}

	@Then("the user should see an error message indicating invalid Credentials")
	public void the_user_should_see_an_error_message_indicating_invalid_credentials() {
		lp.verifyInvalidCredentials();
	}

	@When("the user enter the {string} and {int} to get invalid username and any password")
	public void the_user_enter_the_and_to_get_invalid_username_and_any_password(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String uname = listLogin.get(rNum).get("Username");
		String pwrd = listLogin.get(rNum).get("Password");
		lp.enterUsername(uname);
		lp.enterPassword(pwrd);
	}
	
	@When("the user leaves the username and password fields blank")
	public void the_user_leaves_the_username_and_password_fields_blank() {
		lp.enterUsername("");
		lp.enterPassword("");
	}

	@Then("the user should see the error messages indicating that both fields are required")
	public void the_user_should_see_the_error_messages_indicating_that_both_fields_are_required() {
		lp.verifyRequiredFields();
	}

	@When("the user leave the username field blank and enter {string} and {int} to get password")
	public void the_user_leave_the_username_field_blank_and_enter_and_to_get_password(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String pwrd = listLogin.get(rNum).get("Password");
		lp.enterUsername("");
		lp.enterPassword(pwrd);
	}

	@Then("the user should see the error message indicating that username is required")
	public void the_user_should_see_the_error_message_indicating_that_username_is_required() {
		lp.verifyUsernameRequired();
	}

	@When("the user enters the {string} and {int} to get valid username and leave the password field blank")
	public void the_user_enters_the_and_to_get_valid_username_and_leave_the_password_field_blank(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String uname = listLogin.get(rNum).get("Username");
		String pwrd = listLogin.get(rNum).get("Password");
		lp.enterUsername(uname);
		lp.enterPassword(pwrd);
	}

	@Then("the user should see the error message indicating that password is required")
	public void the_user_should_see_the_error_message_indicating_that_password_is_required() {
		lp.verifyPasswordRequired();
	}
	
	@When("the user click on Forgot your password? link")
	public void the_user_click_on_forgot_your_password_link() {
	   lp.scrollDown();
	   lp.clickOnforgotPasswordLink();
	}

	@Then("the user should be redirected to the reset password page")
	public void the_user_should_be_redirected_to_the_reset_password_page() {
	    lp.verifyResetPasswordPage();
	}

	@Then("user enters {string} and {int} to get the username")
	public void user_enters_and_to_get_the_username(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String uname = listLogin.get(rNum).get("Username");
		lp.enterUsername(uname);
	}

	@Then("click on the Reset Password button")
	public void click_on_the_reset_password_button() {
	    lp.clickOnResetPasswordButton();
	}

	@Then("the user should get a message indicating that Reset password link is sent successfully")
	public void the_user_should_get_a_message_indicating_that_reset_password_link_is_sent_successfully() {
		lp.verifyResetPasswordSuccess();
	}
	
	@Then("leave the username field blank and click on the Reset button")
	public void leave_the_username_field_blank_and_click_on_the_reset_button() {
	    lp.clickOnResetPasswordButton();
	}

	@Then("the user should get an error indicating username is required")
	public void the_user_should_get_an_error_indicating_username_is_required() {
	    lp.verifyUsernameRequired();
	}

	@Then("click on the Cancel button")
	public void click_on_the_cancel_button() throws InterruptedException {
	    lp.clickOnCancelButton();
	}

	@Then("the user should be redirected back to the login page")
	public void the_user_should_be_redirected_back_to_the_login_page() {
	    lp.verifyLoginPage();
	}


}
