package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.seleniumcourseonlteaw39.Utils;

import java.time.Duration;

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
        authenticationPage.provideEmailAndClickCreateAnAccount(Utils.randomEmail());

        UserData userData = new UserData()
                .setFirstName("Ala")
                .setLastName("Makota")
                .setPassword("haslo123");

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        assertTrue(createAnAccountPage.areMandatoryFormFieldsVisibleAndEnabled());
        createAnAccountPage.fillForm(userData);
        createAnAccountPage.clickRegister();

        // then
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        assertTrue(myAccountPage.isDisplayedAccountCreationSuccessPanel());
    }
}
