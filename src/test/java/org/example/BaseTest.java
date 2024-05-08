package org.example;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {
    BrowserManager browserManager= new BrowserManager();
    @BeforeMethod
    public void setup(){
        browserManager.openBrowser();
    }
    @AfterMethod
    public void tearDown(ITestResult result){
        if(!result.isSuccess()){
            screenShot((result.getName()));
        }
        browserManager.closeBrowser();
    }
}
