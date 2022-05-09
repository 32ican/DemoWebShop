package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.Products;
import pages.RegisterPage;
import utilities.TestBase;

public class AddToCartSteps extends TestBase {

    RegisterPage registerPage = new RegisterPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    Products product = new Products(driver);


    @Given("^user logged in to his account with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_logged_in_to_his_account_with_username_something_and_password_something(String email, String password) throws Throwable {
        homePage.clicklogIn();
        registerPage.enterEmailAndPassword(email, password);
        loginPage.clickOnLogin();
    }

    @When("^user select a new product: simple computer$")
    public void user_could_select_a_new_product_simple_computer() throws Throwable {
        product.clickLaptop14inch();
    }


    @And("^add it to cart$")
    public void add_it_to_cart() throws Throwable {
        product.addLaptopToCart();
    }

    // assert that confirmation message that product added successfully to cart will appear
    @Then("^confirmation message: \"([^\"]*)\" should appear$")
    public void confirmation_message_something_should_appear(String confirmMsg) throws Throwable {
        Assert.assertTrue(product.getPorductAddedToCartMessage().contains(confirmMsg));
    }

}
