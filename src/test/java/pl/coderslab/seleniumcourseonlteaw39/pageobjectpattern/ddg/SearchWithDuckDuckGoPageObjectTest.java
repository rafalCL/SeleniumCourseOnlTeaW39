package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.ddg;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SearchWithDuckDuckGoPageObjectTest {
    private WebDriver driver;

    @Test
    public void searchPhraseWithDuckDuckGo() {
        // todo implement test
    }

    @BeforeEach
    public void beforeEach() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    @AfterEach
    public void afterEach() {
//        this.driver.quit(); // todo uncomment to close browser and driver
    }
}
