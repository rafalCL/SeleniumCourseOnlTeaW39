package pl.coderslab.seleniumcourseonlteaw39.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.ddg.DdgMainPage;

import java.time.Duration;

public class SearchWithDuckDuckGoCucumberSteps {
    private WebDriver driver;
    private DdgMainPage mainPage;

    @Given("https:\\/\\/duckduckgo.com\\/ opened in web browser")
    public void openInBrowser() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        this.mainPage = new DdgMainPage(driver);

        driver.get("https://duckduckgo.com/");
    }

    @When("Phrase 'Faraon' entered in search input box")
    public void searchPhraseEnteredInSearchInput() {
        final String phrase = "faraon";
        // when
        mainPage.enterSearchPhrase(phrase);
    }

    @And("Search button clicked")
    public void clickSearchButton() {
        mainPage.clickSearchButton();
    }
    //Then First 3 results contain phrase 'Faraon'

    //     @Test
    //    public void searchPhraseWithDuckDuckGo() {
    //        // given
    //        driver.get("https://duckduckgo.com/");
    //
    //        final String phrase = "faraon";
    //        // when
    //        mainPage.enterSearchPhrase(phrase);
    //        mainPage.clickSearchButton();
    //        // then
    //        List<String> searchResults = resultsPage.getSearchResults();
    //        for (int i = 0; i < 3; i++) {
    //            String resultLowerCase = searchResults.get(i).toLowerCase();
    //            if(!resultLowerCase.contains(phrase)) {
    //                fail(String.format("Phrase %s NOT found in result: %s", phrase, resultLowerCase));
    //            }
    //        }
    //    }
    //
    //    @BeforeEach
    //    public void beforeEach() {
    //        this.driver = new ChromeDriver();
    //        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    //        this.mainPage = new DdgMainPage(driver);
    //        this.resultsPage = new DdgSearchResultsPage(driver);
    //    }
    //
    //    @AfterEach
    //    public void afterEach() {
    ////        this.driver.quit(); // todo uncomment to close browser and driver
    //    }
}
