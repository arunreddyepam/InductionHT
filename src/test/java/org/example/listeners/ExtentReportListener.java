package org.example.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Cross-Browser Parallel Test Report");
            spark.config().setReportName("Login Test - Chrome | Firefox | Edge");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Application", "The-Internet Herokuapp");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester", "Automation Team");
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
        ExtentTest extentTest = extent.createTest(
                result.getMethod().getMethodName() + " [" + browser + "]");
        extentTest.assignCategory(browser);
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test PASSED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "Test FAILED: " + result.getMethod().getMethodName());
        test.get().log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test SKIPPED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
            System.out.println("\n>> HTML Report generated at: test-output/ExtentReport.html");
        }
    }
}
