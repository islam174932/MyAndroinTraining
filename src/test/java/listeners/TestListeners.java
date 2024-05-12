package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        // Log the start of the test
        System.out.println("Test started: " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        // Log the successful execution of the test
        System.out.println("Test passed: " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        // Log the failure of the test
        System.out.println("Test failed: " + iTestResult.getName());
        // You can add more actions here, such as taking a screenshot
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        // Log the skipped test
        System.out.println("Test skipped: " + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        // Log the test which failed within success percentage
        System.out.println("Test failed within success percentage: " + iTestResult.getName());
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        // Log the start of the test suite
        System.out.println("Test suite started: " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        // Log the finish of the test suite
        System.out.println("Test suite finished: " + iTestContext.getName());
    }
}

