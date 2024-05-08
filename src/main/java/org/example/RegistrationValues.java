package org.example;

import org.openqa.selenium.By;

import java.util.Date;

public class RegistrationValues extends  Utility{
    LoadProperty loadProperty=new LoadProperty();
    public void registrationDetails(){
        //Entering registration details
        //sendValue(By.id("FirstName"),loadProperty.getValue("firstName"));
        firstName().sendKeys(loadProperty.getValue("firstName"));
        sendValue(By.id("LastName"),loadProperty.getValue("lastName"));
        // selecting day of DOB
        selectByVisibleText(By.name("DateOfBirthDay"), "27");
        //selecting month
        selectByVisibleText(By.name("DateOfBirthMonth"), "May");
        //selecting year of DOB
        selectByVisibleText(By.name("DateOfBirthYear"),"1989");
        setEmailAddress(new Date());
        sendValue(By.id("Email"),getEmailAddress());
        sendValue(By.id("Password"), loadProperty.getValue("password"));
        sendValue(By.id("ConfirmPassword"), loadProperty.getValue("confirmPassword"));

    }


}
