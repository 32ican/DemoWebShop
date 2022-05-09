package pages;

import com.sun.org.apache.bcel.internal.generic.LADD;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    // register button
    @FindBy(xpath = "//a[@href=\"/register\"]")
    private WebElement registerBtn;

    // login button
    @FindBy (xpath = "//a[@href=\"/login\"]")
    private WebElement loginBtn;

    // navigate to computers menu
    @FindBy(xpath = "//a[@href=\"/computers\"]")
    private List<WebElement> computerMenu;

    @FindBy(xpath= "//a[@href=\"/desktops\"]")
    private List<WebElement> desktops;


    public void clickOnRegiser (){
        registerBtn.click();
    }

    public void clicklogIn(){
        loginBtn.click();
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    // Navigate to Computers > Desktops
    public void navigateToComputersDesktops(){
        actions = new Actions(driver);
        actions.moveToElement(computerMenu.get(0)).
                moveToElement(desktops.get(0)).click().build().perform();
    }


}
