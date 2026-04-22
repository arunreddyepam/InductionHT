package org.example.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomTestListener implements ITestListener {

    private static PrintWriter writer;
    private static final String LOG_FILE = "test-output/custom-test-log.txt";

    private String getTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    private void log(String message) {
        System.out.println(message);
        if (writer != null) {
            writer.println(message);
            writer.flush();
        }
    }

    @Override
    public void onStart(ITestContext context) {
        try {
            writer = new PrintWriter(new FileWriter(LOG_FILE, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        log("==========================================================");
        log("[" + getTimestamp() + "] TEST SUITE STARTED: " + context.getName());
        log("==========================================================");
    }

    @Override
    public void onTestStart(ITestResult result) {
        log("[" + getTimestamp() + "] TEST STARTED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log("[" + getTimestamp() + "] TEST PASSED: " + result.getMethod().getMethodName()
                + " | Duration: " + (result.getEndMillis() - result.getStartMillis()) + " ms");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log("[" + getTimestamp() + "] TEST FAILED: " + result.getMethod().getMethodName());
        log("   Reason: " + result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log("[" + getTimestamp() + "] TEST SKIPPED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log("[" + getTimestamp() + "] TEST FAILED (Within Success %): "
                + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        log("==========================================================");
        log("[" + getTimestamp() + "] TEST SUITE FINISHED: " + context.getName());
        log("Passed: " + context.getPassedTests().size()
                + " | Failed: " + context.getFailedTests().size()
                + " | Skipped: " + context.getSkippedTests().size());
        log("==========================================================");
        if (writer != null) {
            writer.close();
        }
    }
}
