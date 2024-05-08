package org.example;

import org.openqa.selenium.By;

public class ProductMailToFriendPage extends Utility {

    public void enterFriendEmailAndPersonalMsg(){
        //passing value for the friend email
        sendValue(By.id("FriendEmail"), loadProperty.getValue("friendEmail"));
        //passing the value for message
        sendValue(By.id("PersonalMessage"), loadProperty.getValue("personalMsg"));
        //clicking the send button
        clickOnElement(By.xpath("//div[2][@class='buttons']/button[1]"));
    }

}
