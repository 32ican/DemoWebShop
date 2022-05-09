package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}


	@FindBy(xpath = "//input[@class=\"button-1 login-button\"]")
	private WebElement loginBtn;

	// login error message
	@FindBy(className = "validation-summary-errors")
	private WebElement errorMessage;

	public void clickOnLogin() {
		loginBtn.click();
	}

	public String getLoginErrorMessage(){
		return errorMessage.getText();

	}
	
	
}
