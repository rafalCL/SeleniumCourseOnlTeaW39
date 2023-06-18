package pl.coderslab.seleniumcourseonlteaw39.examples;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchWithDuckDuckGoTest {
    @Test
    public void searchWithDdg() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");
        WebElement searchInputBox = driver.findElement(By.id("search_form_input_homepage"));
        searchInputBox.sendKeys("w pustyni i w puszczy");
        WebElement searchButton = driver.findElement(By.id("search_button_homepage"));
        searchButton.click();
//        driver.quit();
    }
}
