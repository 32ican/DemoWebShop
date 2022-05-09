package pages;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.TestBase;

public class OrderCheckoutSteps extends TestBase {

   private HomePage homePage = new HomePage(driver);
   private Products product = new Products(driver);
   private ShoppingCartPage cartpage = new ShoppingCartPage(driver);
   private CheckoutPage checkout = new CheckoutPage(driver);


    @When("^user navigate to computers and select desktops$")
    public void user_navigate_to_computers_and_select_desktops() throws Throwable {
        homePage.navigateToComputersDesktops();
    }

    @And("^user add the simple computer with slow processor to the shopping cart$")
    public void user_add_the_simple_computer_with_slow_processor_to_the_shopping_cart() throws Throwable {
        product.navigateToSimpleComputer();
        product.addSimpleComputerToCart();
    }

    @And("^user navigate to shopping cart and check it out$")
    public void user_navigate_to_shopping_cart_and_check_it_out() throws Throwable {
        cartpage.clickShoppingCart();
        cartpage.agreeWithTermsOfService();
        cartpage.clickChechout();
    }

    @And("^add the address and continue$")
    public void add_the_address_and_continue(DataTable dataTable) throws Throwable {
        String country = dataTable.row(1).get(0);
        String city = dataTable.row(1).get(1);
        String street = dataTable.row(1).get(2);
        String zipCode = dataTable.row(1).get(3);
        String phone = dataTable.row(1).get(4);

        checkout.selectCountry(country);
        checkout.enterCity(city);
        checkout.enterAddress(street);
        checkout.enterZipCode(zipCode);
        checkout.enterPhone(phone);
        checkout.continueToShippingAddress();
    }

    @And("^continue to payment method and enter the payment information:$")
    public void continue_to_payment_method_and_enter_the_payment_information(DataTable cardInfo) throws Throwable {
            String type = cardInfo.cell(0, 1);
            String name = cardInfo.cell(1, 1);
            String number = cardInfo.cell(2, 1);
            String exMonth = cardInfo.cell(3, 1);
            String exYear = cardInfo.cell(4, 1);
            String code = cardInfo.cell(5, 1);

            checkout.continueToShippingMethod();
            checkout.continueToPaymentMethod();
            checkout.choosePaymentMethod();
            checkout.continueToPaymentInfo();
            checkout.enterPaymentInfo(type, name, number, exMonth, exYear, code);
    }


    // assert verification message that order has successfully processed!
    @Then("^user could see confirmation message: \"([^\"]*)\"$")
    public void user_could_see_confirmation_message_something(String comfirmMsg) throws Throwable {
        explicitWait(checkout.getOrderComfirmationMsgElemnt());
        Assert.assertEquals(checkout.getOrderConfirmationMsg(), comfirmMsg);
    }

}
