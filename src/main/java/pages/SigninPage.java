package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class SigninPage extends PageBase {
	@FindBy(name = "Email")
	private WebElement emailField;

	@FindBy(name = "Password")
	private WebElement passwordField;

	@FindBy(name = "submit")
	private WebElement signinButton;
	@FindBy(id="error")
	public List< WebElement > errorElementList;

	// supporting methods

	public void signin(String email, String password) {
		emailField.clear();
		emailField.sendKeys(email);
		passwordField.clear();
		passwordField.sendKeys(password);
		signinButton.click();
	}

}
