package pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testing.BaseTest;

public class logoutPage extends BaseTest {

    public LoginPage logout() {
        try {
            // Find the main menu element
            MobileElement mainMenu = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc='test-Menu']");
            click(mainMenu);

            // Explicitly wait for the logout button to be clickable
            WebDriverWait wait = new WebDriverWait(driver, 10);
            MobileElement logoutButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc='test-LOGOUT']")));
            click(logoutButton);
        } catch (NoSuchElementException e) {
            // Handle NoSuchElementException
            System.out.println("Element not found: " + e.getMessage());
        } catch (Exception e) {
            // Handle any other exception
            System.out.println("An error occurred: " + e.getMessage());
        }
        return new LoginPage();
    }
}


