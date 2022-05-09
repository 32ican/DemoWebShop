package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions","utilities"},
        tags = "@Smoke or @Regression",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/cucumber-reports/rerun.txt"
        })


public class RunnerTestNG extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }

}
