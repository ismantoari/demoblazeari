package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:reports/WebCucumber.html","json:reports/WebCucumber.json"},
        features ={"src/test/resources"},
        tags = "@web",
        glue = {"stepDef"}

)

public class RunnerWebTest {

}