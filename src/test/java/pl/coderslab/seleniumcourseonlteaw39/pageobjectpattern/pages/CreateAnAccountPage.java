package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.coderslab.seleniumcourseonlteaw39.Utils;
import pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.UserData;

public class CreateAnAccountPage {
    private final WebDriver driver;

    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(UserData userData) {
        WebElement firstNameInputBox  = driver.findElement(By.id("customer_firstname"));
        firstNameInputBox.sendKeys(userData.getFirstName());

        WebElement lastNameInputBox  = driver.findElement(By.id("customer_lastname"));
        lastNameInputBox.sendKeys(userData.getLastName());

//        WebElement customerEmailInputBox  = driver.findElement(By.id("email"));
//        Utils.assertVisibleAndEnabled(customerEmailInputBox);

        WebElement passwordInputBox  = driver.findElement(By.id("passwd"));
        passwordInputBox.sendKeys(userData.getPassword());
    }

    public void clickRegister() {
        WebElement registerButton  = driver.findElement(By.id("submitAccount"));
        registerButton.click();
    }

    public boolean areMandatoryFormFieldsVisibleAndEnabled() {
        WebElement firstNameInputBox = driver.findElement(By.id("customer_firstname"));
        WebElement lastNameInputBox = driver.findElement(By.id("customer_lastname"));
        WebElement passwordInputBox = driver.findElement(By.id("passwd"));

        return Utils.isDisplayedAndEnabled(firstNameInputBox) &&
            Utils.isDisplayedAndEnabled(lastNameInputBox) &&
            Utils.isDisplayedAndEnabled(passwordInputBox);
    }
}
