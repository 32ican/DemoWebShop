package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FirstName")
    WebElement firstNameTxtField;

    @FindBy(id = "LastName")
    WebElement lastNameTxtField;

    @FindBy(id = "Email")
    WebElement emailTxtField;

    @FindBy(id = "Password")
    WebElement passwordTxtField;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordNameTxtField;

    @FindBy(id = "register-button")
    WebElement registerBtn;

    // confirmation message that user registered successfully
    @FindBy (xpath = "//div[@class=\"result\"]")
    WebElement confirmationMessage;

    // log out btn
    @FindBy(linkText = "Log out")
    WebElement logoutBtn;

    // error message when try to register with registered data
    @FindBy (xpath = "//div[@class=\"validation-summary-errors\"]")
    WebElement errorMessage;


    public void entersData(String firstName, String lastName, String email, String password){
        firstNameTxtField.sendKeys(firstName);
        lastNameTxtField.sendKeys(lastName);
        emailTxtField.sendKeys(email);
        passwordTxtField.sendKeys(password);
        confirmPasswordNameTxtField.sendKeys(password);
    }

    public void enterEmailAndPassword(String email, String password){
        emailTxtField.sendKeys(email);
        passwordTxtField.sendKeys(password);
    }

    public void clickRegister(){
        registerBtn.click();
    }

    public void clickLogOut(){
        logoutBtn.click();
    }

    // getter
    public WebElement getConfirmationMessage() {
        return confirmationMessage;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getLogoutBtn() {
        return logoutBtn;
    }



}
