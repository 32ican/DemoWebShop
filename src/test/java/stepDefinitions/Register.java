package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.RegisterPage;
import utilities.TestBase;

public class Register extends TestBase {

    private HomePage homepage;
    private RegisterPage registerPage;


    @Given("^user at home page and clicks on register$")
    public void user_at_home_page_and_clicks_on_register() throws Throwable {
        homepage = new HomePage(driver);
        homepage.clickOnRegiser();
    }

    @When("^user enters (.+), (.+), (.+) and (.+)$")
    public void user_enters_and(String firstname, String lastname, String email, String password) throws Throwable {
       registerPage = new RegisterPage(driver);
       registerPage.entersData(firstname, lastname, email, password);
    }

    @Then("^User could register successfully$")
    public void user_could_register_successfully_and_confirmation_message_should_appear() throws Throwable {
            registerPage.clickRegister();
    }

    @And("^confirmation message should appear$")
    public void confirmation_messaage_should_appear (){
      Assert.assertTrue(registerPage.getConfirmationMessage().getText().contains("Your registration completed"));
    }


    // unhappy scenario
    @When("^user enters same data \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void user_enters_same_data_something_something_something_something_something
            (String firstname, String lastname, String email, String password) throws Throwable {
            registerPage = new RegisterPage(driver);
            registerPage.entersData(firstname, lastname, email, password);
    }

    @Then("^user could not register with same data$")
    public void user_could_not_register() throws Throwable {
            registerPage.clickRegister();
    }

    @And("error message should appear")
    public void error_message_should_appear(){
        System.out.println(registerPage.getErrorMessage().getText());
        Assert.assertTrue(registerPage.getErrorMessage().getText().contains("The specified email already exists"));
    }
}
