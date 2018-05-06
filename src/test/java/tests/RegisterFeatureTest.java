package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class RegisterFeatureTest extends TestBase {
	@BeforeClass
	public void classSetup() {
		menuBar.registerLink.click();
	}

	@Test
	public void testFirstNameWithOneChar() {
		registerPage.writeAndSubmit(registerPage.firstNameField, "a");
		String errorMessage = registerPage.errorElementList.get(0).getText();
		Assert.assertEquals(errorMessage, "* FirstName can not be less than 2 character.");
	}
	
	@Test
	public void testGenderWithSeclectedOption() {
		registerPage.randomlySelectFromDropDown(registerPage.genderDropDownElement);
		String errorMessage = registerPage.errorElementList.get(2).getText();
		Assert.assertEquals(errorMessage, "*");
	}

	@AfterClass
	public void classTearDown() {
		menuBar.jobSearchLink.click();
	}

}
