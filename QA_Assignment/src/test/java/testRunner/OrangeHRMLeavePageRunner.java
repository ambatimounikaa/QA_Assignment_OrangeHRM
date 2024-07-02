package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (features="src/test/resources/featurefiles/leave_page.feature",
				  glue ="stepDefinitions",
				  plugin= {"pretty","html:target/html-reports/report.html"},
				  //to get json report "json:target/cucumber-reports/Cucumber.json"
				  monochrome=true)

public class OrangeHRMLeavePageRunner {

}
