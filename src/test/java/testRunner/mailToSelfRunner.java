package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Features",
        glue = "",
        plugin = { "pretty", "html:src/main/resources/report.html",
        }

)
public class mailToSelfRunner {


}
