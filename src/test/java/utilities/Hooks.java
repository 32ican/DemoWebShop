package utilities;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import pages.RegisterPage;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class Hooks extends TestBase {



    @Before
    public void openBrowser() throws IOException {

            String browser = getProp("browser");

            // to open chrome browser
        if (browser.equalsIgnoreCase("chrome")) {
                  instantiateChrome();
        }
            // to open firefox browser

        else if (browser.equalsIgnoreCase("firefox")) {
                  instantiateFireFox();
        }
           // to open Microsoft Edge browser
        else if(browser.equalsIgnoreCase("edge")){
                  instantiateEdge();
        }
    }

                // take Screenshot if a step failed
    @AfterStep
    public void addScreenshot (Scenario scenario) throws IOException {
        if (scenario.isFailed()){
           File sourcePath =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
           scenario.attach(fileContent,"image/png", "image");
        }
    }

    @After
    public void closeDriver()  {
        HomePage homepage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        try {
            if (registerPage.getLogoutBtn().isDisplayed()) {
                registerPage.clickLogOut();
                driver.quit();
            }
        }
        catch (Exception e){
            driver.quit();
        }

    }

}