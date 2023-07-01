package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private final WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayedAccountCreationSuccessPanel() {
        WebElement accountCreationSuccessfulPanel = driver.findElement(By.cssSelector("p.alert.alert-success"));
        String panelText = accountCreationSuccessfulPanel.getText();

        return accountCreationSuccessfulPanel.isDisplayed() &&
                "Your account has been created.".equals(panelText);
    }
}
