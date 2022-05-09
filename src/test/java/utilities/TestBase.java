package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase{

    public static WebDriver driver;

    // src/main/resources
    String chromePath = "\\src\\\\main\\\\resources\\\\chromedriver.exe";
    String fireFoxPath = "\\src\\\\main\\\\resources\\\\geckodriver.exe";
    String edgePath = "\\src\\\\main\\\\resources\\\\msedgedriver.exe";


    public String getProp(String name) throws IOException {

        FileInputStream stream = new FileInputStream(System.getProperty("user.dir") +
                "\\src\\\\main\\\\resources\\\\global.properties");
        Properties prop = new Properties();
        prop.load(stream);
        String url = prop.getProperty("url");
        String browser = prop.getProperty("browser");
        if(name.equalsIgnoreCase("browser")){
            return browser;
        }
        else if(name.equalsIgnoreCase("url")){
            return url;
        }
        else {return null;}

    }

    public void instantiateChrome() throws IOException {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(getProp("url"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void instantiateFireFox () throws IOException {
        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir") + fireFoxPath);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(getProp("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void instantiateEdge () throws IOException {
        System.setProperty("webdriver.edge.driver",
                System.getProperty("user.dir") + edgePath);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(getProp("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public void explicitWait(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
         element = wait.until(
                ExpectedConditions.visibilityOf(element));
    }
}
