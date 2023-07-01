package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    @FindBy(css = "p.alert.alert-success")
    WebElement accountCreationSuccessfulPanel;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayedAccountCreationSuccessPanel() {
        String panelText = accountCreationSuccessfulPanel.getText();

        return accountCreationSuccessfulPanel.isDisplayed() &&
                "Your account has been created.".equals(panelText);
    }
}
