package browserSetup.loginStep;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import ObjectRepository.LoginObject;
import browserSetup.BrowserSetup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import webApp.PerformAction;

public class Login_Step_definition extends BrowserSetup {
	PerformAction wait = new PerformAction();
	JavascriptExecutor js = (JavascriptExecutor) driver;

	// Open web site URl
	@Given("^Open the application url\\.$")
	public void open_the_website_url() throws Throwable {
		driver.get("https://staging.payrollpanda.my");
		Thread.sleep(2000);
	}

	@Then("^Enter email address as \"([^\"]*)\"\\.$")
	public void enter_user_email_address_as(String email) throws Throwable {

		webelement = driver.findElement(LoginObject.UserId);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys(email);
		wait.implictywait(driver);

	}

	@Then("^Enter the Password \"([^\"]*)\"\\.$")
	public void enter_the_Password(String passwd) throws Throwable {
		webelement = driver.findElement(LoginObject.userpass);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys(passwd);
		wait.implictywait(driver);

	}

	@Then("^Click on Login CTA\\.$")
	public void click_on_Login_button() throws Throwable {
		webelement = driver.findElement(LoginObject.login);
		wait.implictywait(driver);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(2000);
	}
	@Then("^Verify user email \"([^\"]*)\" validation message for Email Address\\.$")
	public void verify_user_email_validation_message_for_Email_Address(String email) throws Throwable {
		try {
			Object Email_validation = js
					.executeScript("return document.getElementsByClassName('js-email')[0].validationMessage");
			wait.implictywait(driver);
			System.out.println(Email_validation);
			wait.implictywait(driver);
			log.info("It's getting HTML5 validation message for email address using JS executor");
			 Assert.assertEquals(Email_validation, email);
			wait.implictywait(driver);
		} catch (NoSuchElementException NSEt) {

		}
		
	}
	@Then("^Verify user pass \"([^\"]*)\" validation message for Password\\.$")
	public void verify_user_pass_validation_message_for_Password(String pass) throws Throwable {
		try {
			Object password_valid = js
					.executeScript("return document.getElementsByClassName('js-password')[0].validationMessage");

			if (password_valid.equals(password_valid))
				wait.implictywait(driver);
			System.out.println(password_valid);
			wait.implictywait(driver);
			log.info("It's getting HTML5 validation message for email address using JS executor");
			 Assert.assertEquals(password_valid, pass);
			wait.implictywait(driver);
		} catch (NoSuchElementException NSEP) {

		}
	}
	
	@Then("^Verify user error \"([^\"]*)\" message for all invalid credentials\\.$")
	public void verify_user_error_message_for_all_invalid_credentials(String error) throws Throwable {
		try {
			String signin_error = driver.findElement(LoginObject.error_val).getText();
			wait.implictywait(driver);
			 Assert.assertEquals(error, signin_error);
			wait.implictywait(driver);
		} catch (NoSuchElementException NF) {

		}
	}
	@Then("^Verify the page title Go To Dashboard\\.$")
	public void verify_the_page_title_Go_To_Dashboard() throws Throwable {
		Thread.sleep(4000);
		String actualTitle = driver.getTitle();
		wait.implictywait(driver);
		String expectedTitle = "PayrollPanda: Dashboard";
		wait.implictywait(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		wait.implictywait(driver);
		Thread.sleep(2000);
	}

}
