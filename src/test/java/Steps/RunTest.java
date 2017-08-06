package Steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by admin on 28/07/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = ".", format = {"pretty", "html:target/cucumber-report-html", "json:target/cucumber-json"})
public class RunTest {
}
