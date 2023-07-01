package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {
    @FindBy(id = "email_create")
    WebElement emailInputBox;
    @FindBy(id = "SubmitCreate")
    WebElement createAnAccountButton;

    public AuthenticationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void provideEmailAndClickCreateAnAccount(String email) {
        emailInputBox.clear();
        emailInputBox.sendKeys(email);
        createAnAccountButton.click();
    }
}
