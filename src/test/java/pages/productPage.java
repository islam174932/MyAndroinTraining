package pages;

import io.appium.java_client.MobileElement;
import testing.BaseTest;

public class productPage extends BaseTest {


    MobileElement addToCartElement = (MobileElement) driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]");
    MobileElement addToCartElement2 = (MobileElement) driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[2]"); // Corrected XPath

    MobileElement cartIconElement = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc='test-Cart']" +
            "/android.view.ViewGroup/android.widget.ImageView");

    public void checkProducts() throws InterruptedException {
        try {
            sleep();
            click(addToCartElement);
            sleep();
            click(addToCartElement2);
            sleep();
            click(cartIconElement);
            sleep();
        } catch (Exception e) {
            // Handle any exceptions that might occur during the interaction
            System.err.println("Exception occurred: " + e.getMessage());
        }
    }


}