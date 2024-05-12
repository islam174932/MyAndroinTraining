package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import testing.BaseTest;

import java.sql.SQLException;

public class CheckoutPage extends BaseTest {

    protected MobileElement checkout;

    public void initializeElementsAndClickCheckoutButton() {
        try {

            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                            + "new UiSelector().text(\"CHECKOUT\"))"));

            checkout = (MobileElement) driver.findElement(MobileBy.AccessibilityId("test-CHECKOUT"));

            click(checkout); // This line clicks the checkout button
        } catch (WebDriverException e) {
            System.err.println("Failed to initialize elements and click checkout button: " + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void fillTheInformation() {


        MobileElement firstName = (MobileElement) driver.findElement(MobileBy.AccessibilityId("test-First Name"));
        MobileElement lastName = (MobileElement) driver.findElement(MobileBy.AccessibilityId("test-Last Name"));
        MobileElement postcode = (MobileElement) driver.findElement(MobileBy.AccessibilityId("test-Zip/Postal Code"));
        try {
            sleep();
            sendKey(firstName, "Eslam");
            sendKey(lastName, "Gamal");
            sendKey(postcode, "1089");
        } catch (WebDriverException | InterruptedException e) {
            System.err.println("Failed to fill the information: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public logoutPage clickContinue () throws InterruptedException {
        MobileElement Continue = (MobileElement) driver.findElement(MobileBy.AccessibilityId("test-CONTINUE"));
         click(Continue);
         sleep();
         return new logoutPage();
    }









}


