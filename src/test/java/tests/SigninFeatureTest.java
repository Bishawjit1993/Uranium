package tests;



import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import net.sourceforge.htmlunit.corejs.javascript.ErrorReporter;


public class SigninFeatureTest extends TestBase {

	@BeforeClass
	public void clasSetUp() {
		menuBar.signinLink.click();
	}

	@Test
	public void testSigninWithValidCredentials() {
		signinPage.signin(getProperty("email"), getProperty("password"));
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("profile"));

		// cleanUp
		menuBar.logoutLink.click();
		menuBar.signinLink.click();
	}
	@Test
	public void testSigninWithInvalidEmailAndValidPassword() {
		signinPage.signin("Invalid@email.com",getProperty("password"));
		String errorMessage = signinPage.errorElementList.get(0).getText();
		Assert.assertEquals(errorMessage, "* Email or Password is incorrect.");
	}
	@Test
	public void testSigninWithvalidEmailAndInvalidPassword() {
		signinPage.signin(getProperty("email"), "37262782");
		String errorMessage = signinPage.errorElementList.get(1).getText();
		Assert.assertEquals(errorMessage, "*");
	}
	
	@Test
	public void testSigninWithInvalidEmailAndIvalidPassword() {
		signinPage.signin("invalidemail@gmail.com", "19733973");
		String errorMessage = signinPage.errorElementList.get(0).getText() + signinPage.errorElementList.get(1).getText();
		Assert.assertEquals(errorMessage, "* Email or Password is incorrect.*");
	}
	@Test
	public void testSigninWithvalidEmailAndEmptyPassword() {
		signinPage.signin(getProperty("email"), "");
		String errorMessage = signinPage.errorElementList.get(1).getText();
		Assert.assertEquals(errorMessage, "* Password can not be empty.");
	}
	
	@Test
	public void testSigninWithEmptyEmailAndEmptyPassword() {
		signinPage.signin("", "");
		String errorMessage = signinPage.errorElementList.get(0).getText() + signinPage.errorElementList.get(1).getText();
		Assert.assertEquals(errorMessage, "* Email can not be empty.* Password can not be empty.");
	}
	

	@AfterClass
	public void classTearDown() {
		menuBar.jobSearchLink.click();
	}

}
