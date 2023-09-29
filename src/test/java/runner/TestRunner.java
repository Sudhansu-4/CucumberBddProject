package runner;


//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
       // features = "src/test/java/features/Customers.feature",
        //features = {"src/test/java/features/Customers.feature","src/test/java/features/LoginUser.feature"}
        features = "src/test/java/features",
        glue = {"StepDefination", "utility"}, // Corrected package names
        dryRun = false,
        monochrome = true,
        tags = "@ray",
        plugin = {"pretty","html:target/cucumber-html-report","json:cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
