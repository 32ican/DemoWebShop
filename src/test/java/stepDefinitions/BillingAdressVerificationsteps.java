package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.ShoppingCartPage;
import utilities.TestBase;

public class BillingAdressVerificationsteps extends TestBase {

    ShoppingCartPage cartPage = new ShoppingCartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @And("^agree the terms of service$")
    public void agree_the_terms_of_service() throws Throwable {
        cartPage.agreeWithTermsOfService();
    }

    @And("^click on check out$")
    public void click_on_check_out() throws Throwable {
        cartPage.clickChechout();
    }

    @When("^user click on continue without selecting a country$")
    public void user_click_on_continue_without_selecting_a_country() throws Throwable {
        checkoutPage.continueToShippingAddress();
    }

    // assert that error message: data is required will appear
    @Then("^error message will appear that: \"([^\"]*)\"$")
    public void error_message_will_appear_that_something(String errorMsg) throws Throwable {
        Assert.assertTrue(checkoutPage.getDataRequiredErrorMsg().contains(errorMsg));
    }


    @When("^user select country \"([^\"]*)\" and click on continue$")
    public void user_select_a_country_something_and_click_on_continue(String country) throws Throwable {
        checkoutPage.selectCountry(country);
        checkoutPage.continueToShippingAddress();
    }

    @When("^user select Country and fill the City as follows$")
    public void user_select_country_and_fill_the_city_as_follows(DataTable dataTable) throws Throwable {
        checkoutPage.selectCountry(dataTable.cell(1,0));
        checkoutPage.enterCity(dataTable.cell(1,1));
        checkoutPage.continueToShippingAddress();
    }


    @When("^user fill the address as follows and click continue$")
    public void user_fill_the_address_something_and_click_continue(DataTable dataTable) throws Throwable {
        checkoutPage.selectCountry(dataTable.cell(1,0));
        checkoutPage.enterCity(dataTable.cell(1,1));
        checkoutPage.enterAddress(dataTable.cell(1,2));
        checkoutPage.continueToShippingAddress();
    }

    @When("^user fill the zip code and click on continue$")
    public void user_fill_the_zip_code_something_and_click_on_continue(DataTable dataTable) throws Throwable {
        checkoutPage.selectCountry(dataTable.cell(1,0));
        checkoutPage.enterCity(dataTable.cell(1,1));
        checkoutPage.enterAddress(dataTable.cell(1,2));
        checkoutPage.enterZipCode(dataTable.cell(1,3));
        checkoutPage.continueToShippingAddress();
    }

}
