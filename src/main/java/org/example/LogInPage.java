package org.example;

import org.openqa.selenium.By;

import java.util.Date;

public class LogInPage extends Utility {
    //instantiate Homepage class object
    HomePage homePage=new HomePage();
    //instantiate LoadProperty class
    LoadProperty loadProperty=new LoadProperty();
    public void enterLoginDetails(){
        //setting email address
        setEmailAddress(new Date());
        //passing value for email and password
        sendValue(By.id("Email"), getEmailAddress());
        sendValue(By.id("Password"), loadProperty.getValue("password"));
        clickOnElement(By.xpath("//button[@class ='button-1 login-button']"));
    }
}
