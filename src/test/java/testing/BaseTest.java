package testing;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class BaseTest {


    protected static AppiumDriver driver;
    protected static ExtentReports extent;
   protected ExtentTest test;
    protected static final Logger logger = LogManager.getLogger(LoginTestCase.class);
    @BeforeClass
    public void initializeDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 5");
        capabilities.setCapability("avd", "Pixel_5");
        capabilities.setCapability("avdLaunchTimeout", 300000);
        capabilities.setCapability(MobileCapabilityType.APP, "D:/Demo/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");


        // Provide the Appium server URL
        URL url = new URL("http://127.0.0.1:4724");

        // Initialize the AppiumDriver
        driver = new AndroidDriver (url, capabilities);

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\User\\Desktop\\Reports\\ExtentReport.html");

        // Create an instance of ExtentReports and attach ExtentHtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Initialize PageFactory after driver is initialized


    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("@BeforeMethod: This runs before each test method.");
    }

    public static void sleep() throws InterruptedException {
        Thread.sleep(3000);
    }

    public void click(MobileElement e) throws InterruptedException {
        e.click();
        sleep();


    }

    public static void sendKey(MobileElement element, String input) throws InterruptedException {
        element.sendKeys(input);
        sleep();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            sleep();
            driver.quit();
            extent.flush();
        }
    }

    // Method to take a screenshot
    public void takeScreenshot(String fileName) {
        // Convert driver to TakesScreenshot
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

        // Capture screenshot as File
        File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);

        try {
            // Define the destination folder to save the screenshot
            String destinationFolder = "C:\\Users\\User\\Desktop\\screenShoot\\";

            // Create the destination folder if it doesn't exist
            File folder = new File(destinationFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Define the destination file path
            String destinationFilePath = destinationFolder + fileName + ".png";

            // Copy the screenshot file to the destination folder
            Files.copy(screenshotFile.toPath(), new File(destinationFilePath).toPath());

            System.out.println("Screenshot captured: " + destinationFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return now.format(formatter);
    }

    public void startRecording() throws MalformedURLException {
        try {
            ((CanRecordScreen) driver).startRecordingScreen();
            System.out.println("Screen recording started.");
        } catch (Exception e) {
            System.out.println("Error starting screen recording: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void stopRecording() throws IOException {
        try {
            String media = ((CanRecordScreen) driver).stopRecordingScreen();
            String dirPath = "C:\\Users\\User\\Desktop\\screenShoot";
            String timestamp = Long.toString(new Date().getTime());
            File videoDir = new File(dirPath);
            FileOutputStream stream = null;

            if (!videoDir.exists()) {
                videoDir.mkdirs();
            }
            stream = new FileOutputStream(videoDir + File.separator + timestamp + ".mp4");
            stream.write(Base64.decodeBase64(media));
            System.out.println("Screen recording stopped and saved to: " + videoDir.getAbsolutePath());

            if (stream != null) {
                stream.close();
            }
        } catch (Exception e) {
            System.out.println("Error stopping screen recording: " + e.getMessage());
            e.printStackTrace();
        }
    }

    JSONObject getCredentials(String type) throws IOException, ParseException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\User\\myPorjectAndroid\\src\\main\\resources\\Data\\Users.json");
        JSONObject credentials = (JSONObject) parser.parse(reader);
        return (JSONObject) credentials.get(type);
    }




}




























