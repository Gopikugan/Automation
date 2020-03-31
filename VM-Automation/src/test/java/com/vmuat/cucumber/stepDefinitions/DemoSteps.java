package com.vmuat.cucumber.stepDefinitions;

import java.util.Map;

import com.demo.webmail.HomePage;
import com.demo.webmail.LoginPage;
import com.vmuat.apiBase.Base;
import com.vmuat.manager.ConfigurationManager;
import com.vmuat.manager.PageObjectManager;
import com.vmuat.manager.TestContext;
import com.vmuat.salesforce.GenericFunction;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoSteps {
	
	
	private LoginPage loginpage;
	private HomePage homepage;
	
	@Given("user already in login page")
	public void user_already_in_login_page() {
		// Code for Navigate to login page
		loginpage = new GenericFunction().startApplication("https://outlook.prodapt.com/", "Demo Test Case", "Demo Description", "Gopinath", "Catagory")
				.getWebMailLoginPage();
		loginpage = loginpage.checkLoginPage();
	}
	
	@When("user try to login with valid credentials")
	public void user_try_to_login_with_valid_credentials(DataTable dataTable) {
		
		for (Map<String, String> data : dataTable.asMaps()) {
			loginpage = loginpage.checkLoginPage()
								.setLoginDetails(data.get("username"), data.get("password"));
		}
		homepage = loginpage.clickLogin();
	}

	@Then("application should navigate to inbox page")
	public void application_should_navigate_to_inbox_page() {
		homepage = homepage.checkHomePage();
	}

	@Then("verify the title of inbox page")
	public void verify_the_title_of_inbox_page(DataTable dataTable) {
		for (Map<String, String> data : dataTable.asMaps()) {
			homepage.getHomePage().verifyExactTitle(data.get("title"));
		}
	}

	@When("user try to login with invalid credentials {string} and {string}")
	public void user_try_to_login_with_invalid_credentials(String username, String password) {
		loginpage.checkLoginPage()
				.setLoginDetails(username, password)
				.clickLogin();
	}

	@Then("verify appropirate error message gets displayed")
	public void appropirate_error_message_should_get_displayed() {
	    loginpage.getLoginPage()
	    		.verifyErrorMsg();
	}
	
	

	
}
