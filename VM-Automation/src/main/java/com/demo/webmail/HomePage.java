package com.demo.webmail;

import static org.testng.Assert.assertEquals;

import org.apache.tools.ant.util.WeakishReference.HardReference;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.vmuat.apiBase.Base;


public class HomePage extends Base{
	public HomePage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[@aria-label = 'Mail']")
	private WebElement homePageIdentifier;
	
	/*
	 * @FindBy(how = How.XPATH, using = "//head//title") private WebElement
	 * titleIdentifier;
	 */
	
	
	@FindBy(how = How.XPATH, using = "//div[@aria-label = 'User settings']//span[contains(@class, 'presence') and not(contains(@style, 'display: none'))]")
	private WebElement avatarIdentifier;
	
	@FindBy(how = How.XPATH, using = "//div[@aria-label = 'Sign out']")
	private WebElement logoutIdentifier;
	
	
	public HomePage checkHomePage(){
		verifyDisplayed(homePageIdentifier);
		return this;
	}
	
	public HomePage getHomePage() {
		return new HomePage(driver, node, test);
	}
	
	
	public LoginPage logout() {
		click(avatarIdentifier);
		click(logoutIdentifier);
		return new LoginPage(driver, node, test);
	}
	
	public void verifyExactTitle(String expected) {
		if(verifyTitle(expected)) {
			System.out.println("Verification sucessfull: Page title: \"" + expected + "\"");
		}else {
			
		}
	}
	
}
