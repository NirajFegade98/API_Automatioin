package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReport {



    public static ExtentReports extentreport;

    public static ExtentTest extentlog;


    public static void initializeExtentReport(String path) {
        if (extentreport == null)
        {
            File file = new File(path);
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
            sparkReporter.config().setTheme(Theme.DARK);
            extentreport = new ExtentReports();

            // Add system info or other properties here if needed
            extentreport.setSystemInfo("Environment", "QA");
            extentreport.setSystemInfo("User", System.getProperty("user.name"));

            extentreport.attachReporter(sparkReporter);
        }
    }
}