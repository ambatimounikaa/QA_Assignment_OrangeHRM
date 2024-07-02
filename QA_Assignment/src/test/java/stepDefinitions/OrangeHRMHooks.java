package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class OrangeHRMHooks {
	static WebDriver dr=null;
	
	@Before
	public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ambat\\eclipse-workspace\\QA_Assignment\\Drivers\\chromedriver.exe");
        dr = new ChromeDriver();
        dr.manage().window().maximize();
    }

	@After
	public void takeScreenshotAfterScenario(Scenario scenario) throws IOException {
		File srcfile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		File destfile = new File(System.getProperty("user.dir")+"\\Screenshots\\"+scenario.getName()+".png");
		FileUtils.copyFile(srcfile, destfile);
		dr.quit();
	}
}
