package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (features="src/test/resources/featurefiles/MyInfo_page.feature",
				  glue ="stepDefinitions",
				  plugin= {"pretty","json:target/cucumber-reports/MyInfoReport.json"},
				  monochrome=true)
public class OrangeHRMMyInfoPage {

}
