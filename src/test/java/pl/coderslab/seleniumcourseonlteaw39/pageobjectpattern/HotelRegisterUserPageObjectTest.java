package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.seleniumcourseonlteaw39.Utils;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Zadanie 1
//Funkcje
//Będąc na stronie rejestracji nowego użytkownika
// https://hotel-testlab.coderslab.pl/en/,
// wyszukaj wszystkie pola oraz zweryfikuj
// za pomocą odpowiednich metod czy są one widoczne, aby wpisać tam wartości.
//First Name
//Last Name
//Email
//Password
//Potwierdź rejestrację nowego użytkownika (wcześniej sprawdzając, czy przycisk jest widoczny).

public class HotelRegisterUserPageObjectTest {
    @Test
    public void selectAndFillElements() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        // given
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        // when
        WebElement signInButton = driver.findElement(By.cssSelector("a.user_login.navigation-link"));
        signInButton.click();

        WebElement emailInputBox = driver.findElement(By.id("email_create"));
        String randomEmail = Utils.randomEmail();
        emailInputBox.sendKeys(randomEmail);
        WebElement createAnAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAnAccountButton.click();

        WebElement firstNameInputBox  = driver.findElement(By.id("customer_firstname"));
        Utils.assertVisibleAndEnabled(firstNameInputBox);
        firstNameInputBox.sendKeys("Ala");

        WebElement lastNameInputBox  = driver.findElement(By.id("customer_lastname"));
        Utils.assertVisibleAndEnabled(lastNameInputBox);
        lastNameInputBox.sendKeys("Makota");

        WebElement customerEmailInputBox  = driver.findElement(By.id("email"));
        Utils.assertVisibleAndEnabled(customerEmailInputBox);

        WebElement passwordInputBox  = driver.findElement(By.id("passwd"));
        Utils.assertVisibleAndEnabled(passwordInputBox);
        passwordInputBox.sendKeys("haslo123");

        WebElement registerButton  = driver.findElement(By.id("submitAccount"));
        registerButton.click();
        // then
        WebElement accountCreationSuccessfulPanel = driver.findElement(By.cssSelector("p.alert.alert-success"));
        assertTrue(accountCreationSuccessfulPanel.isDisplayed());
        String panelText = accountCreationSuccessfulPanel.getText();
        assertEquals("Your account has been created.", panelText);
    }
}
