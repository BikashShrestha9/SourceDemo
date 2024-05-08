package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegistrationVerifyPage extends Utility {
    //instantiate LoadProperty class
    LoadProperty loadProperty=new LoadProperty();
    //instantiate LogInPage class
    LogInPage logInPage=new LogInPage();

    public void verifySuccessfulRegistration(){
        //actual message storing in the local variable
        String actualMsg=getTextFromElement(By.xpath("//div[@class='result']"));
        //comparing expected and actual message
        Assert.assertEquals(loadProperty.getValue("regVerifyMsg"),actualMsg, "You are not Register successfully");
        logOut();
    }
    //checking if user is logged in after registration if it is user will click on continue button
    // else user will click on login button
    public void continueOrLogin(){
        //locating logout button and storing in WebElement local variable
        WebElement element = driver.findElement(By.className("ico-logout"));

        //checking if logout button is active
        if (element.isDisplayed()) {
            //click on continue button if logout button is active
            click(By.className("button-1 register-continue-button"));
        }
        //click on login button if above condition is not satisfied
        else{
            clickOnElement(By.xpath("//a[@class='ico-login']"));
            //passing log in credentials
            logInPage.enterLoginDetails();
        }
    }

    //lout out after registration
    public void logOut(){
        WebElement element = driver.findElement(By.className("ico-logout"));
        //checking if logout button is active
        if (element.isDisplayed()) {
            //click on log out button if active
            element.click();
        }
    }

}
