package core;

import helper.Helper;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ExtentReport;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeSuite
    public void config()
    {
        System.out.println("in config of base test");
        String subfolderpath = System.getProperty("user.dir") + "/reports/" + Helper.TimeStamp();
        Helper.createFolder(subfolderpath);
        ExtentReport.initializeExtentReport(subfolderpath + "/" + "API_Execution_Automation.html");
    }

    @AfterMethod(alwaysRun = true)

    public void getResult(ITestResult result) {
        if(ExtentReport.extentreport != null)
        {
            if (result.getStatus() == ITestResult.SUCCESS) {

                ExtentReport.extentlog.pass("Test Case : " + result.getName() + " is passed ");

            } else if (result.getStatus() == ITestResult.FAILURE) {

                ExtentReport.extentlog.fail("Test case : " + result.getName() + " is failed ");

                ExtentReport.extentlog.fail("Test case is failed due to:  " + result.getThrowable());

            } else if (result.getStatus() == ITestResult.SKIP) {

                ExtentReport.extentlog.skip("Test case is Skiped " + result.getName());

            }
        }

    }


    @AfterSuite(alwaysRun = true)

    public void endReport() {

        //ExtentReport.extentreport.flush();

        ExtentReport.extentreport.flush();

        //Logging.setinstanceNull();

    }
}


