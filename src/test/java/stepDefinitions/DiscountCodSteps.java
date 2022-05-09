package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.RegisterPage;
import pages.ShoppingCartPage;
import utilities.TestBase;

import java.util.concurrent.TimeUnit;

public class DiscountCodSteps extends TestBase{

    HomePage homePage = new HomePage(driver);
    RegisterPage registerPage = new RegisterPage(driver);
    ShoppingCartPage cartPage = new ShoppingCartPage(driver);


    @When("^user go to shopping cart$")
    public void user_go_to_shopping_cart() throws Throwable {
        cartPage.clickShoppingCart();
    }

    @And("^give the discount code \"([^\"]*)\"$")
    public void give_the_discount_code(String code) throws Throwable {
            cartPage.applyCoupon(code);
    }


    // assertion that confiramtion message will appear that the discount was applied
    @Then("^user could see a confirmation message contains: \"([^\"]*)\"$")
    public void user_could_see_a_confirmation_message_contains_something(String message) throws Throwable {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(cartPage.getApplyCouponMsg().contains(message));
    }

    // assert that the discount is 20% / (disount / total sould be -0.2)
    @And("^the discount is 20%$")
    public void the_discount_is_20() throws Throwable {
       Assert.assertEquals(cartPage.discountPortion(), -0.2);
    }
}
