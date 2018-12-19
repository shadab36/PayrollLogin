package browserSetup;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"."},
plugin ={
		"pretty", "html:target/cucumber-report","json:target/cucumber.json", "usage:target/usage.jsonx", "junit:target/cucumber.xml"})

	
public class TestRun {
	@BeforeClass
	public static void beforeClass() throws Exception {

		BrowserSetup.before_Class();
	}

	@AfterClass
	public static void afterClass() throws Exception {
		BrowserSetup.after_Class();
	}

}