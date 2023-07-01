package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.ddg;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SearchWithDuckDuckGoPageObjectTest {
    private WebDriver driver;
    private DdgMainPage mainPage;

    @Test
    public void searchPhraseWithDuckDuckGo() {
        driver.get("https://duckduckgo.com/");

        final String phrase = "zielona papuga";

        mainPage.enterSearchPhrase(phrase);
    }

    @BeforeEach
    public void beforeEach() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        this.mainPage = new DdgMainPage(driver);
    }

    @AfterEach
    public void afterEach() {
//        this.driver.quit(); // todo uncomment to close browser and driver
    }
}
