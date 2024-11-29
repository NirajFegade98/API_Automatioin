package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailRetry implements IRetryAnalyzer{

    private int retryCount = 0;
    private static final int maxCount = 2;


    @Override
    public boolean retry(ITestResult iTestResult) {

        if(retryCount < maxCount)
        {
            retryCount++;
            return true;
        }
        return false;
    }
}