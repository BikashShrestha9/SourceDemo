package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class NewRelease extends Utility {

// to verify message is posted
    public void verifyMessageAfterPosting(){
        String actualMessage=getTextFromElement(By.className("result"));
        if(driver.findElement(By.className("result")).isEnabled()){
            Assert.assertEquals(actualMessage,loadProperty.getValue("expectedCommentConfirmationMsg"), "Message does not match your comment may not be listed");
        }

    }
    //write comment title and comments on the comment page
    public void writeCommentTitleAndComments(){
        sendValue(By.id("AddNewComment_CommentTitle"),loadProperty.getValue("newReleaseCommentTitle"));
        sendValue(By.className("enter-comment-text"),loadProperty.getValue("newReleaseComment"));
    }

    //check that posted message is the lat one on the list
    public void toFindMyCommentLastOne(){
        List<WebElement> comments = driver.findElements(By.xpath("//div[@class='comment-list']//p"));
        //System.out.println(comments.size());
        WebElement el= comments.get(comments.size()-1);
        String actualComment=el.getText();
        Assert.assertEquals(actualComment,loadProperty.getValue("newReleaseComment"),"Your comment is not the last one");
        System.out.println(actualComment);
    }
}
