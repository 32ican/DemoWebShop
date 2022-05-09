package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ShoppingCartPage;
import utilities.TestBase;

import java.util.concurrent.TimeUnit;

public class TermsOfServiceVerificationSteps extends TestBase {

    ShoppingCartPage cartPage = new ShoppingCartPage(driver);

    @When("^user try to check out the product$")
    public void user_try_to_check_out_the_product() throws Throwable {
        cartPage.clickChechout();
    }

    // assert that waring dialougue box will appear
    @Then("^warning box will appear contains: \"([^\"]*)\"$")
    public void warning_box_will_appear_contains_something(String warning) throws Throwable {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(cartPage.getTermsOfServiceWarningMsg().contains(warning));
    }
}
