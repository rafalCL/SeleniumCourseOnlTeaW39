package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.ddg;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class SearchWithDuckDuckGoPageObjectTest {
    private WebDriver driver;
    private DdgMainPage mainPage;
    private DdgSearchResultsPage resultsPage;

    @Test
    public void searchPhraseWithDuckDuckGo() {
        // given
        driver.get("https://duckduckgo.com/");

        final String phrase = "faraon";
        // when
        mainPage.enterSearchPhrase(phrase);
        mainPage.clickSearchButton();
        // then
        List<String> searchResults = resultsPage.getSearchResults();
        for (int i = 0; i < 3; i++) {
            String resultLowerCase = searchResults.get(i).toLowerCase();
            if(!resultLowerCase.contains(phrase)) {
                fail(String.format("Phrase %s NOT found in result: %s", phrase, resultLowerCase));
            }
        }
    }

    @BeforeEach
    public void beforeEach() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        this.mainPage = new DdgMainPage(driver);
        this.resultsPage = new DdgSearchResultsPage(driver);
    }

    @AfterEach
    public void afterEach() {
//        this.driver.quit(); // todo uncomment to close browser and driver
    }
}
