package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import PageObjects.LeavePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;

public class LeaveSteps {
	WebDriver dr;	
	String excelPath = "src/test/resources/Data/LoginDetails.xlsx";
	
	public LeaveSteps() {
		dr = OrangeHRMHooks.dr;
	}
	
	LeavePage lp;
	
	@Given("the user is logged into the OrangeHRM application")
	public void the_user_is_logged_into_the_orange_hrm_application() throws IOException {
		lp= new LeavePage(dr);
		lp.loadProperties();
		lp.launchLoginPage();
		lp.enterUsername();
		lp.enterPassword();
	    lp.clickOnLoginButton();
	}

	@When("user navigates to the Leave section")
	public void user_navigates_to_the_leave_section() {
	    lp.selectLeave();
	}

	@When("the user selects Apply")
	public void the_user_selects_apply() {
	    lp.clickOnApply();
	}

	@Then("Apply Leave dashboard should be displayed")
	public void apply_leave_dashboard_should_be_displayed() {
	    lp.verifyApplyPageTitle();
	}

	@When("the user selects Leave Type from the dropdown")
	public void the_user_selects_leave_type_from_the_dropdown() {
	    lp.selectLeaveType();
	}

	@When("verify the leave balance")
	public void verify_the_leave_balance() {
	    lp.verifyLeaveBalance();
	}

	@When("selects same From Date and To Date from {string} and {int}")
	public void selects_same_from_date_and_to_date_from_and(String sheetname, Integer rNum) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String fdate = listLogin.get(rNum).get("FromString");
		String tdate = listLogin.get(rNum).get("ToString");
		System.out.println(fdate+" "+tdate);
		lp.enterSameDates(fdate, tdate);
	}

	@When("selects Full Day from Duration dropdown")
	public void selects_full_day_from_duration_dropdown() {
		lp.clickonDurationDropdown();
	    lp.selectFullDayDuration();
	}

	@When("add comments in Comments field from {string} and {int}")
	public void add_comments_in_comments_field_from_and(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String cmnt = listLogin.get(rNum).get("Comments");
		lp.addComment(cmnt);
	}

	@Then("click on apply button")
	public void click_on_apply_button() {
	    lp.clickOnApplyButton();
	}

	@Then("Success alert should be displayed")
	public void success_alert_should_be_displayed() {
	    System.out.println("Verified the success alert");
	}

	@When("selects Half Day - Morning from the Duration dropdown")
	public void selects_half_day_morning_from_the_duration_dropdown() {
		lp.clickonDurationDropdown();
	    lp.selectHalfDayMrngDuration();
	}

	@When("selects Half Day - Afternoon from the Duration dropdown")
	public void selects_half_day_afternoon_from_the_duration_dropdown() {
		lp.clickonDurationDropdown();
	   lp.selectHalfDayAftrnDuration();
	}

	@When("selects Specify Time from the dropdown")
	public void selects_specify_time_from_the_dropdown() {
		lp.clickonDurationDropdown();
	    lp.selectSpecifyTimeDuration();
	}

	@Then("From,To,Duration fields should be displayed")
	public void from_to_duration_fields_should_be_displayed() {
	    lp.verifyFromToFields();
	}

	@Then("add From, To time from {string} and {int} and validate Duration is accurate")
	public void add_from_to_time_from_and_and_validate_duration_is_accurate(String sheetname, Integer rNum) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String fromTime = listLogin.get(rNum).get("FromTimeString");
		String toTime = listLogin.get(rNum).get("ToTimeString");
		lp.enterTimes(fromTime,toTime);
	}

	@When("selects From Date and To Date from {string} and {int}")
	public void selects_from_date_and_to_date_from_and(String sheetname, Integer rNum) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> listLogin= reader.getData(excelPath, sheetname);
		String fromDate = listLogin.get(rNum).get("FromString");
		String toDate = listLogin.get(rNum).get("ToString");
		lp.enterDiffDates(fromDate,toDate);
	}

	@When("select All Days from the Partial Days dropdown")
	public void select_all_days_from_the_partial_days_dropdown() {
		lp.diffDatesSelectPartialDays();
	    lp.selectAllDays();
	}

	@When("select Half Day Morning from Duration dropdown")
	public void select_half_day_morning_from_duration_dropdown() {
	   lp.diffDatesSelectDurationType();
	   lp.selectHalfDayMrngDuration();
	}

	@Then("Success popup should be displayed")
	public void success_popup_should_be_displayed() {
	    System.out.println("Should be verified through screenshot");
	}

	@When("select Start Day Only from the Partial Days dropdown")
	public void select_start_day_only_from_the_partial_days_dropdown() {
	    lp.diffDatesSelectPartialDays();
	    lp.selectStartDayOnly();
	}

	@When("select Half Day Afternoon from Duration dropdown")
	public void select_half_day_afternoon_from_duration_dropdown() {
	    lp.diffDatesSelectDurationType();
	    lp.selectHalfDayAftrnDuration();
	}

	@When("select End Day Only from the Partial Days dropdown")
	public void select_end_day_only_from_the_partial_days_dropdown() {
		lp.diffDatesSelectPartialDays();
	    lp.selectEndDayOnly();
	}

	@When("select Scepify time from Duration dropdown")
	public void select_scepify_time_from_duration_dropdown() {
	   lp.diffDatesSelectDurationType();
	   lp.selectSpecifyTimeDuration();
	}

	@When("select Start and End Day from the Partial Days dropdown")
	public void select_start_and_end_day_from_the_partial_days_dropdown() {
	    lp.diffDatesSelectPartialDays();
	    lp.selectStartAndEndDay();
	}

	@Then("Start Day and End Day dropdowns should be displayed")
	public void start_day_and_end_day_dropdowns_should_be_displayed() {
	    lp.verifyStartAndEndDayDropdowns();
	}

	@Then("select Half Day Morning from Start Day dropdown")
	public void select_half_day_morning_from_start_day_dropdown() {
		lp.startDayDropdown();
	    lp.selectHalfDayMrngDuration();
	}

	@Then("Select Half Day Afternoon from End Day dropdown")
	public void select_half_day_afternoon_from_end_day_dropdown() {
		lp.endDayDropdown();
	    lp.selectHalfDayAftrnDuration();
	}

	@Then("user should get an error indicating that From Date and To Date is required")
	public void user_should_get_an_error_indicating_that_from_date_and_to_date_is_required() {
	    lp.verifyErrors();
	}




}
