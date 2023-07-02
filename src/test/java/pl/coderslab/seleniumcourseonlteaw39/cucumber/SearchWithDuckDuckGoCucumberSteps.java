package pl.coderslab.seleniumcourseonlteaw39.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.ddg.DdgMainPage;
import pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.ddg.DdgSearchResultsPage;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.fail;

public class SearchWithDuckDuckGoCucumberSteps {
    private WebDriver driver;
    private DdgMainPage mainPage;
    private DdgSearchResultsPage resultsPage;

    @Given("^([^ ]+) opened in web browser$")
    public void openInBrowser(String url) {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        this.mainPage = new DdgMainPage(driver);
        this.resultsPage = new DdgSearchResultsPage(driver);

        driver.get(url);
    }

    @When("Phrase {string} entered in search input box")
    public void searchPhraseEnteredInSearchInput(String phrase) {
        // when
        mainPage.enterSearchPhrase(phrase);
    }

    @And("Search button clicked")
    public void clickSearchButton() {
        mainPage.clickSearchButton();
    }

    @Then("First {int} results contain phrase {string}")
    public void checkSearchResults(int count, String phrase) {
        String phraseLowerCase = phrase.toLowerCase();
        List<String> searchResults = resultsPage.getSearchResults();
        for (int i = 0; i < count; i++) {
            String resultLowerCase = searchResults.get(i).toLowerCase();
            if(!resultLowerCase.contains(phraseLowerCase)) {
                fail(String.format("Phrase %s NOT found in result: %s", phrase, resultLowerCase));
            }
        }
    }
}
