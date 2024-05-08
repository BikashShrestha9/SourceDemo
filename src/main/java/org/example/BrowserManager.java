package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BrowserManager extends  Utility {
    LoadProperty loadProperty= new LoadProperty();
    String browser =loadProperty.getValue("browser");
    //String browser = System.getProperty("browser");
    public void openBrowser (){
        //driver=new ChromeDriver();
        //checking the browser value passed from test data and opening the browser
        if(browser.equalsIgnoreCase("chrome")){
            System.out.println("Your browser is Chrome");
            driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Edge")){
            System.out.println("Your browser is Edge");
            driver= new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("Firefox")){
            System.out.println("Your browser is Firefox");
            driver=new FirefoxDriver();
        }
        else{
            System.out.println("Your browser is wrong "+browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(loadProperty.getValue("url"));

    }
    //closing the browser
    public void closeBrowser(){
        //driver.quit();
    }


}
