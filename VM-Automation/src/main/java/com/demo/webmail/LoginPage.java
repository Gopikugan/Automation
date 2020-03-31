package com.demo.webmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.vmuat.apiBase.Base;

public class LoginPage extends Base{
	
	public LoginPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='lgnDiv']")					private WebElement loginPageIdentifier;
	@FindBy(how = How.XPATH, using = "//input[@id='username']")				private WebElement usernameIdentifier;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")				private WebElement passwordIdentifier;
	@FindBy(how = How.XPATH, using = "//div[@class='signinbutton']")		private WebElement loginbuttonIdentifier;
	
	@FindBy(how = How.XPATH, using = "//div[@id= 'signInErrorDiv']")		private WebElement signInErrorIdentifier;
	
	public LoginPage checkLoginPage(){
		verifyDisplayed(loginPageIdentifier);
		return this;
	}
	
	public LoginPage enterUserName(String username){
		clearAndType(usernameIdentifier, username);
		return this;
	}

	public LoginPage enterPassword(String password){
		clearAndType(passwordIdentifier, password);
		return this;
	}
	
	public HomePage clickLogin() {
		click(loginbuttonIdentifier);
		return new HomePage(driver, node, test);		
	}
	
	public String getErrorMessage() {
		return getElementText(signInErrorIdentifier).toString();
	}
	
	public LoginPage getLoginPage() {
		return new LoginPage(driver, node, test);
	}
	
	
	/*
	 * 
	 * 
	 * Login related functions
	 * 
	 * 
	 */
	
	
	public LoginPage setLoginDetails(String uname, String pwd){
		return getLoginPage()
				.checkLoginPage()
				.enterUserName(uname)
				.enterPassword(pwd);
	}
	
	public HomePage getHomePage() {
		return getLoginPage()
				.clickLogin();
	}
	
	public void verifyErrorMsg(String expected) {
		Assert.assertEquals(getErrorMessage(), expected);
		
	}
	public void verifyErrorMsg() {
		String text = getErrorMessage();
		if(!text.isEmpty()) {
			System.out.println("Verification sucessfull: Error message : \"" + text + "\"");
		}
		
	}
	
	
}
