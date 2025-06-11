package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initReport() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("target/AutomationReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void startTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logFail(String message) {
        test.fail(message);
    }

    public static void logSkip(String message) {
        test.skip(message);
    }

    public static void flushReport() {
        extent.flush();
    }
}
