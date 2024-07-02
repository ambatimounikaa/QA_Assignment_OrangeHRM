package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import PageObjects.MyInfoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;

public class MyInfoSteps {
	
	WebDriver dr;	
	String excelPath = "src/test/resources/Data/LoginDetails.xlsx";
	
	public MyInfoSteps() {
		dr = OrangeHRMHooks.dr;
	}
	
	MyInfoPage mp;
	
	@Given("the User is logged into the OrangeHRM application")
	public void the_user_is_logged_into_the_orange_hrm_application() throws IOException {
		mp= new MyInfoPage(dr);
		mp.loadProperties();
		mp.launchLoginPage();
		mp.enterUsername();
		mp.enterPassword();
	    mp.clickOnLoginButton();
	}
	
	@When("user navigates to the My Info section")
	public void user_navigates_to_the_my_info_section() {
	   mp.clickOnMyInfo();
	}

	@Then("PIM dashboard should be displayed")
	public void pim_dashboard_should_be_displayed() {
	    mp.verifyMyInfoPage();
	}

	@When("the user selects Personal Details")
	public void the_user_selects_personal_details() {
	    mp.clickOnPersonalDetails();
	}

	@Then("Personal Details dashboard should be displayed")
	public void personal_details_dashboard_should_be_displayed() {
	   mp.verifyPersonalDetailsDashboard();
	}

	@Then("enter Employee Full Name from {string} and {int}")
	public void enter_employee_full_name_from_and(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String fname = listLogin.get(rNum).get("Firstname");
		String lname = listLogin.get(rNum).get("Lastname");
		mp.enterFirstname(fname);
		mp.enterLastname(lname);
	}

	@Then("enter Employee Id and Other Id from {string} and {int}")
	public void enter_employee_id_and_other_id_from_and(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String eid = listLogin.get(rNum).get("EmployeeId");
		String oid = listLogin.get(rNum).get("OtherIdString");
		mp.enterEmployeeId(eid);
	    mp.enterOtherId(oid);
	}

	@Then("enter Drivers License Number from {string} and {int}")
	public void enter_drivers_license_number_from_and(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String i = listLogin.get(rNum).get("DrivingLNum");
		mp.enterLicenseNumber(i);
	}

	@Then("enter License Expiry Date from {string} and {int}")
	public void enter_license_expiry_date_from_and(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String edate = listLogin.get(rNum).get("LExpiryDate");
		mp.enterLicenseExpiryDate(edate);
	}

	@Then("select Nationality from the dropdown")
	public void select_nationality_from_the_dropdown() {
	    mp.selectNationality();
	}

	@Then("enter Date of Birth from {string} and {int}")
	public void enter_date_of_birth_from_and(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String dob = listLogin.get(rNum).get("DateOfBirth");
		mp.enterDob(dob);
	}

	@Then("click on Save")
	public void click_on_save() {
	   mp.clickOnSaveButton();
	}

	@Then("user should get the Success alert")
	public void user_should_get_the_success_alert() {
	   //This should be verified using screenshot
	}

	@Then("empty the Employee Full Name")
	public void empty_the_employee_full_name() {
	    mp.emptyEmployeeFullName();
	}

	@Then("the user should get an error indicating both First Name and Last Name are required")
	public void the_user_should_get_an_error_indicating_both_first_name_and_last_name_are_required() {
	    mp.verifyErrorsofPersonalDetails();
	}

	@When("the user selects Contact Details")
	public void the_user_selects_contact_details() {
	    mp.clickOnContactDetails();
	}

	@Then("Contact Details dashboard should be displayed")
	public void contact_details_dashboard_should_be_displayed() {
	   mp.verifyContactDetailsDashboard();
	}

	@Then("enter Street {int}, Street {int} and City from {string} and {int}")
	public void enter_street_street_and_city_from_and(Integer int1, Integer int2, String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String streetOne = listLogin.get(rNum).get("Street1");
		String streetTwo = listLogin.get(rNum).get("Street2");
		String city = listLogin.get(rNum).get("City");
		mp.enterStreetOne(streetOne);
		mp.enterStreetTwo(streetTwo);
		mp.enterCity(city);
	}

	@Then("enter State, Zip from {string} and {int} and Country from dropdown")
	public void enter_state_zip_from_and_and_country_from_dropdown(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String zip= listLogin.get(rNum).get("ZipCode");
	    mp.enterZip(zip);
	}

	@Then("enter Work Email and Other Email from {string} and {int}")
	public void enter_work_email_and_other_email_from_and(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String workEmail= listLogin.get(rNum).get("WorkEmail");
		String otherEmail = listLogin.get(rNum).get("OtherEmail");
		mp.enterWorkEmail(workEmail);
		mp.enterOtherEmail(otherEmail);
	}

	@Then("enter invalid Work Email from {string} and {int}")
	public void enter_invalid_work_email_from_and(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String email= listLogin.get(rNum).get("WorkEmail");
	    mp.enterInvalidEmail(email);
	}

	@Then("the user should get an error indicating Expected Format is different")
	public void the_user_should_get_an_error_indicating_expected_format_is_different() {
	    
	}

	@When("the user selects Emergency Contacts")
	public void the_user_selects_emergency_contacts() {
	    mp.clickOnEmergencyContacts();
	}

	@Then("Emergency Contacts should be displayed")
	public void emergency_contacts_should_be_displayed() {
		 mp.verifyEmergencyContactsDashboard();
	}

	@Then("click on Add button")
	public void click_on_add_button() {
	   mp.clickOnAddButton();
	}

	@Then("Save Emergency Contact should be displayed")
	public void save_emergency_contact_should_be_displayed() {
	    mp.verifySaveEmergencyContact();
	}

	@Then("enter Name and Relationship from {string} and {int}")
	public void enter_name_and_relationship_from_and(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String name= listLogin.get(rNum).get("Name");
		String relationship = listLogin.get(rNum).get("Relationship");
		mp.enterName(name);
		mp.enterRelationship(relationship);
	}

	@Then("Enter Mobile from {string} and {int}")
	public void enter_mobile_from_and(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String mobile= listLogin.get(rNum).get("Mobile");
		mp.enterMobile(mobile);
	}

	@Then("clear Name, Relationship and Mobile fields")
	public void clear_name_relationship_and_mobile_fields() {
	    mp.clearEmergencyContactsFields();
	    
	}

	@Then("the user should get an error indicating Name, Relationship and At least one phone number are required")
	public void the_user_should_get_an_error_indicating_name_relationship_and_at_least_one_phone_number_are_required() {
	   mp.verifyErrorsofEmergencyContacts();
	}



}
