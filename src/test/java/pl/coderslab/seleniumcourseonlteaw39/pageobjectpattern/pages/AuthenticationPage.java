package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {
    private final WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void provideEmailAndClickCreateAnAccount(String email) {
        WebElement emailInputBox = driver.findElement(By.id("email_create"));
        emailInputBox.clear();
        emailInputBox.sendKeys(email);
        WebElement createAnAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAnAccountButton.click();
    }
}
