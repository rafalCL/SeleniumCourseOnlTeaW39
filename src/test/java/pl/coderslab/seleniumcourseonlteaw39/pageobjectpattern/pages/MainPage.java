package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn() {
        WebElement signInButton = driver.findElement(By.cssSelector("a.user_login.navigation-link"));
        signInButton.click();
    }
}
