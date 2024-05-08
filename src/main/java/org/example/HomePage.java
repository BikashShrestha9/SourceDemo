package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePage extends Utility{
    //navigating to register page from home page
    public void registerPage(){
     clickOnElement(By.linkText("Register"));
    }
    //navigating to login page from home page
    public void loginPage() {
        clickOnElement(By.xpath("//a[@class='ico-login']"));

    }
    public void referToFriend(){
        clickOnElement(By.className(""));
    }
    public void buildComputer(){
        clickOnElement(By.xpath("//div[@class='product-grid home-page-product-grid']/div[2]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
    }
    // navigating to camera and photo page from home page
    public void cameraAndPhotoPage(){
        hooverOverElement(By.xpath("//div/ul[@class='top-menu notmobile']/li[2]/a"),By.xpath("//div/ul[@class='top-menu notmobile']/li[2]/ul/li[1]/a"));
    }
    public void desktopPage(){
        hooverOverElement(By.xpath("//ul[@class='top-menu notmobile']/li/a"),By.xpath("//ul[@class='top-menu notmobile']/li/ul/li/a"));
    }
    public void selectCurrency(){
        //clickOnElement(By.id("customerCurrency"));
        selectByVisibleText(By.id("customerCurrency"),loadProperty.getValue("selectCurrency"));
        List<WebElement> list=driver.findElements(By.xpath("//div[@class='prices']/span"));
        for(WebElement s:list){
            String k = s.getText();
            System.out.println(k);
            if(loadProperty.getValue("selectCurrency").equals("US Dollar")){
                Assert.assertTrue(k.startsWith("$"), "Your currency sign does not match");
            }
            else if (loadProperty.getValue("selectCurrency").equals("Euro")){
                Assert.assertTrue(k.startsWith("€"),"Your currency sign doe snot match");
            }

        }
    }
    public String getHomePageWindowHandle(){
        return driver.getWindowHandle();
    }

    public void clickOnFacebook(){
        clickOnElement(By.linkText("Facebook"));
    }
    public void clickOnTwitter(){
        clickOnElement(By.linkText("Twitter"));
    }


}
