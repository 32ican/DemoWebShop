package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Web elements:

    // select country
    @FindBy (id = "BillingNewAddress_CountryId")
    private WebElement country;

    /* List of error messages
        index(0) = Country    index(1) = City      index(2) = Street address
        index (3) = postal code     index (4) = phone
     */
    @FindBy (className = "field-validation-error")
    private List<WebElement> dataRequiredErrorMsg;

    // Continue button after filling the billing address
    @FindBy (xpath = "//input[@onclick=\"Billing.save()\"]")
    private WebElement billingContinueBtn;

    // continue button after choosing shipping address
    @FindBy (xpath = "//input[@onclick=\"Shipping.save()\"]")
    private WebElement shippingAddressContinuebBtn;

    // continue button after shipping method
    @FindBy (xpath = "//input[@onclick=\"ShippingMethod.save()\"]")
    private WebElement shippingMethodContinuebBtn;

    // continue button after payment method
    @FindBy (xpath = "//input[@onclick=\"PaymentMethod.save()\"]")
    private WebElement paymentMethodContinuebBtn;

    // continue button after payment information
    @FindBy (xpath = "//input[@onclick=\"PaymentInfo.save()\"]")
    private WebElement paymenInfoContinuebBtn;

    // payment method credit cart
    @FindBy (id = "paymentmethod_2")
    private WebElement creditCard;

    // confirm button
    @FindBy(xpath = "//input[@onclick=\"ConfirmOrder.save()\"]")
    private WebElement confirmBtn;

    // selcet visa
    @FindBy (id = "CreditCardType")
    private WebElement cardType;

    // card holder name text field
    @FindBy (id = "CardholderName")
    private WebElement cardHolderTxt;

    // card number text field
    @FindBy (id = "CardNumber")
    private WebElement cardnumberTxt;

    // Expire Month
    @FindBy (id = "ExpireMonth")
    private WebElement expireMonth;

    // ExpireYear
    @FindBy (id = "ExpireYear")
    private WebElement expireyear;

    @FindBy(id = "CardCode")
    private WebElement cardCode;

    //city text field
    @FindBy(id = "BillingNewAddress_City")
    private WebElement cityTex;

    //address
    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement address1Txt;

    // zip or postal code
    @FindBy (id = "BillingNewAddress_ZipPostalCode")
    private WebElement zipCodeTxt;

    // phone number
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement phoneTXT;

    // confirmation message that order has been successfully processed
    @FindBy (xpath = "//strong")
    private WebElement orderConfirmationMsg;


    // Methods:

    public String getDataRequiredErrorMsg(){
        return dataRequiredErrorMsg.get(0).getText();
    }

    public void selectCountry(String countryName){
        select = new Select(country);
        select.selectByVisibleText(countryName);
    }

    public void enterCity(String city){
        cityTex.sendKeys(city);
    }

    public void enterAddress(String address){
        address1Txt.sendKeys(address);
    }

    public void enterZipCode(String zip){
        zipCodeTxt.sendKeys(zip);
    }

    public void enterPhone(String phone){
        phoneTXT.sendKeys(phone);
    }

    public void continueToShippingAddress(){
        billingContinueBtn.click();
    }

    public void continueToShippingMethod(){
        shippingAddressContinuebBtn.click();
    }

    public void continueToPaymentMethod(){
        shippingMethodContinuebBtn.click();
    }

    public void continueToPaymentInfo(){
        paymentMethodContinuebBtn.click();
    }

    public void continueToConfirm(){
        paymenInfoContinuebBtn.click();
    }

    public void choosePaymentMethod (){
        creditCard.click();
    }

    public void confirmOrder(){
        confirmBtn.click();
    }

    // choose credit card and enter its information
    public void enterPaymentInfo(String type, String name, String number, String month, String year, String code){
        creditCard.click();
        continueToPaymentInfo();
        select = new Select(cardType);
        select.selectByVisibleText(type);
        cardHolderTxt.sendKeys(name);
        cardnumberTxt.sendKeys(number);
        select = new Select(expireMonth);
        select.selectByVisibleText(month);
        select = new Select(expireyear);
        select.selectByVisibleText(year);
        cardCode.sendKeys(code);
        continueToConfirm();
        confirmOrder();
    }

    public String getOrderConfirmationMsg(){
        return orderConfirmationMsg.getText();
    }

    public WebElement getOrderComfirmationMsgElemnt(){
        return orderConfirmationMsg;
    }
}
