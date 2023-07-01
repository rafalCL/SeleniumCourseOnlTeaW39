package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
    private WebDriver driver;
    private MainPage mainPage;
    private AuthenticationPage authenticationPage;
    private CreateAnAccountPage createAnAccountPage;
    private MyAccountPage myAccountPage;

    @Test
    public void shouldCreateUserAccount() {
        // given
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        // when
        mainPage.clickSignIn();

        final String randomEmail = Utils.randomEmail();
        authenticationPage.provideEmailAndClickCreateAnAccount(randomEmail);

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
        assertTrue(myAccountPage.isDisplayedAccountCreationSuccessPanel());
    }

    @BeforeEach
    public void beforeEach() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        this.mainPage = new MainPage(driver);
        this.authenticationPage = new AuthenticationPage(driver);
        this.createAnAccountPage = new CreateAnAccountPage(driver);
        this.myAccountPage = new MyAccountPage(driver);
    }

    @AfterEach
    public void afterEach() {
//        driver.quit();
    }
}
