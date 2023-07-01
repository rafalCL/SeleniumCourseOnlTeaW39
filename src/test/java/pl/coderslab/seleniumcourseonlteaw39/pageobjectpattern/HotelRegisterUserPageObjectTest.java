package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.seleniumcourseonlteaw39.Utils;
import pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.pages.AuthenticationPage;
import pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.pages.CreateAnAccountPage;
import pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.pages.MainPage;
import pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.pages.MyAccountPage;

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
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignIn();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        final String randomEmail = Utils.randomEmail();
        authenticationPage.provideEmailAndClickCreateAnAccount(randomEmail);

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        assertTrue(createAnAccountPage.areMandatoryFormFieldsVisibleAndEnabled());
        assertEquals(randomEmail, createAnAccountPage.getEmail());

        UserData userData = new UserData()
                .setFirstName("Ala")
                .setLastName("Makota")
                .setPassword("haslo123")
                .setSignUpForNewsletter(true);

        createAnAccountPage.fillForm(userData);
        createAnAccountPage.clickRegister();

        // then
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        assertTrue(myAccountPage.isDisplayedAccountCreationSuccessPanel());
    }
}
