package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.coderslab.seleniumcourseonlteaw39.Utils;

public class CreateAnAccountPage {
    private final WebDriver driver;

    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(UserData userData) {
        WebElement firstNameInputBox  = driver.findElement(By.id("customer_firstname"));
        Utils.assertVisibleAndEnabled(firstNameInputBox);
        firstNameInputBox.sendKeys(userData.getFirstName());

        WebElement lastNameInputBox  = driver.findElement(By.id("customer_lastname"));
        Utils.assertVisibleAndEnabled(lastNameInputBox);
        lastNameInputBox.sendKeys(userData.getLastName());

//        WebElement customerEmailInputBox  = driver.findElement(By.id("email"));
//        Utils.assertVisibleAndEnabled(customerEmailInputBox);

        WebElement passwordInputBox  = driver.findElement(By.id("passwd"));
        Utils.assertVisibleAndEnabled(passwordInputBox);
        passwordInputBox.sendKeys(userData.getPassword());
    }
}
