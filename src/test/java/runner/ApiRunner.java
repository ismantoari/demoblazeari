package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepDef"},
        features = {"src/test/resources"},
        plugin = {"pretty","html:reports/ApiCucumber.html","json:reports/ApiCucumber.json"},
        tags = "@api"
)

public class ApiRunner {
}