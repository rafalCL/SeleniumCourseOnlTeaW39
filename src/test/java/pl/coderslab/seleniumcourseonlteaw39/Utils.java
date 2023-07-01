package pl.coderslab.seleniumcourseonlteaw39;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class Utils {
    public static String randomEmail() {
        return UUID.randomUUID().toString() + "@mail.pl";
    }

    public static void assertVisibleAndEnabled(WebElement elementToTest) {
        if(!elementToTest.isDisplayed() || !elementToTest.isEnabled()) {
            Assertions.fail("element NOT displayed OR NOT enabled");
        }
    }

    public static boolean isDisplayedAndEnabled(WebElement elementToTest) {
        return elementToTest.isDisplayed() && elementToTest.isEnabled();
    }

    public static void setCheckbox(WebElement checkbox, boolean isChecked) {
        if((checkbox.getAttribute("checked") == null && isChecked) ||
            (checkbox.getAttribute("checked") != null && !isChecked)) {
            checkbox.click();
        }
    }
}
