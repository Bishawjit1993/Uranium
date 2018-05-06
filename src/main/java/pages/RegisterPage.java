package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class RegisterPage extends PageBase {
	@FindBy(name = "FirstName")
	public WebElement firstNameField;

	@FindBy(name = "Gender")
	public WebElement genderDropDownElement;

	@FindBy(name = "submit")
	public WebElement submitButton;

	@FindBy(id = "error")
	public List<WebElement> errorElementList;

	// supporting methods
	public void writeAndSubmit(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
		submitButton.click();

	}
}
