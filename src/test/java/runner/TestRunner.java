package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
/*
* Cucumber Options tag is used to provide a link between the feature files and step definition files.
* Each step of the feature file is mapped to a corresponding method on the step definition file.
* */

@CucumberOptions(
// change the test features by update
        features = {"src/test/java/features/FindDealer.feature"},
        glue = "stepDefinitions"

)
public class TestRunner {
}
