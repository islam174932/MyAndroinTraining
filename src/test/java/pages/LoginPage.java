package pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testing.BaseTest;

public class LoginPage extends BaseTest {

    MobileElement loginButton = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='LOGIN']");
    public void Login(String username, String password) throws InterruptedException {

        MobileElement usernameElement = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc='test-Username']");
        sendKey(usernameElement, username);
        sleep();
        MobileElement passwordElement = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc='test-Password']");
        sendKey(passwordElement, password);
        sleep();
        MobileElement loginButton = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='LOGIN']");
        loginButton.click();
    }

    public void ClickEnter() throws InterruptedException {
        click(loginButton);
    }
}




