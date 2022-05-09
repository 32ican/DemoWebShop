package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.TestBase;

import java.util.List;

public class Products extends BasePage{


    public Products(WebDriver driver) {
        super(driver);
    }

    //Web elements:

    // select 14.1-inch laptop:
    @FindBy (linkText = "14.1-inch Laptop")
    private WebElement laptop14Insch;

    //  add laptop 14.1 inch to cart button
    @FindBy(id = "add-to-cart-button-31")
    private WebElement addLaptopToCart;

    // add simple computer to cart button
    @FindBy(id = "add-to-cart-button-75")
    private WebElement addComputerToCartBtn;


    // product added to cart successfully message:
    @FindBy (xpath = "//p[@class=\"content\"]")
    private WebElement productAddedMessage;

    // simple computer
    @FindBy(xpath = "//a[@href=\"/simple-computer\"][@title=\"Show details for Simple Computer\"]")
    private WebElement simpleComputer;

    // slow processor
    @FindBy(id = "product_attribute_75_5_31_96")
    private WebElement slowProcessor;



    // Methods:

    public void clickLaptop14inch(){
        laptop14Insch.click();
    }

    public void addLaptopToCart(){
        addLaptopToCart.click();
    }

    // get confirmation message that the lapto was add succesfully to the cart
    public String getPorductAddedToCartMessage(){
        return productAddedMessage.getText();
    }

    public void navigateToSimpleComputer(){
        simpleComputer.click();
        slowProcessor.click();
    }

    public void addSimpleComputerToCart(){
            addComputerToCartBtn.click();
    }

}
