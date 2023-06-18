package pl.coderslab.seleniumcourseonlteaw39.selectors;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Na stronie https://hotel-testlab.coderslab.pl/en/ zidentyfikuj następująca pola/przyciski za pomocą lokalizatora By.id:
//(pole tekstowe) Hotel Location
//(przycisk) Search Now
//(pole tekstowe) Enter your e-mail (pole na dole stron)
//Po zidentyfikowaniu elementów wpisz następujące wartości w pola tekstowe:
//
//Hotel Location - Warsaw
//Enter your e-mail - test@test.com

public class Zad1Test {
    @Test
    public void selectAndFillElements() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement hotelLocationInputBox = driver.findElement(By.id("hotel_location"));
        hotelLocationInputBox.sendKeys("Warsaw");

        WebElement searchNowButton = driver.findElement(By.id("search_room_submit"));

        WebElement newsletterEmailInputBox = driver.findElement(By.id("newsletter-input"));
        newsletterEmailInputBox.sendKeys("test@test.com");
    }
}
