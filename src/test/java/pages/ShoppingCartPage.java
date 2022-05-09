package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage extends BasePage{

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    // Web elements:

//     Shopping cart
    @FindBy (linkText = "Shopping cart")
    private List<WebElement> cartBtn;

    // coupon text field
    @FindBy (xpath = "//input[@name=\"discountcouponcode\"]")
    private WebElement couponTxtField;

    // apply coupon button
    @FindBy (name = "applydiscountcouponcode")
    private WebElement applyCouponBtn;

    // confirmation message that coupon code was applied
    @FindBy (xpath = "//div[@class=\"message\"]")
    private WebElement couponMsg;

    // list of product price rows: index(0) = total price, index(3) = discount
    @FindBy(className = "product-price")
    private List<WebElement> productPrice;

    // Checkout button
    @FindBy(id = "checkout")
    private WebElement chechoutBtn;

    @FindBy (id = "terms-of-service-warning-box")
    private WebElement termsOfServiceWrnBox;

    // agree with the terms of use check box
    @FindBy(id = "termsofservice")
    private WebElement agreeCheckBox;

    // Methods:

    public void clickShoppingCart(){
        cartBtn.get(0).click();
    }

    public void applyCoupon(String code){
        couponTxtField.sendKeys(code);
        applyCouponBtn.click();
    }

    public String getApplyCouponMsg(){
        return couponMsg.getText();
    }

    // discount value in percentage
    public double discountPortion(){
        String discount = productPrice.get(3).getText();
        String total = productPrice.get(0).getText();
        return Double.parseDouble(discount) / Double.parseDouble(total);
    }

    public void clickChechout(){
        chechoutBtn.click();
    }

    // This method returns the warining message that user must accept terms of service before proceeding chechout process
    public String getTermsOfServiceWarningMsg(){
        return termsOfServiceWrnBox.getText();
    }

    public void agreeWithTermsOfService(){
        agreeCheckBox.click();
    }
}
