package org.example;

import org.openqa.selenium.By;

public class LeciaCameraPage extends Utility {
    public void emailAFriend(){
        //navigating to the page where user can refer the product to the friend
        clickOnElement(By.className("email-a-friend"));
    }
}
