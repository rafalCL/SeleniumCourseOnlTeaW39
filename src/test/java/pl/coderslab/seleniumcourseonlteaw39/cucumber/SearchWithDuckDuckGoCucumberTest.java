package pl.coderslab.seleniumcourseonlteaw39.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/search_with_duck_duck_go.feature",
        plugin = {"pretty","html:out"})
public class SearchWithDuckDuckGoCucumberTest {
}
