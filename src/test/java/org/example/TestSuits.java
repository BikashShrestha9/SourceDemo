package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestSuits extends BaseTest{
BrowserManager browserManager=new BrowserManager();
HomePage homePage=new HomePage();
LogInPage logInPage=new LogInPage();
RegistrationValues registrationValues=new RegistrationValues();
RegistrationVerifyPage regverify= new RegistrationVerifyPage();
CameraAndPhotoPage cameraAndPhotoPage=new CameraAndPhotoPage();
LeciaCameraPage leciaCameraPage=new LeciaCameraPage();
ProductMailToFriendPage productMailToFriendPage=new ProductMailToFriendPage();
BuildOwnComputerPage buildOwnComputerPage=new BuildOwnComputerPage();
DesktopPage desktopPage=new DesktopPage();
NewRelease newRelease=new NewRelease();
SearchedPage searchedPage=new SearchedPage();


//    @Test(priority = 1)
//    public void verifyUserShouldAbleToRegister(){
//        //setEmailAddress(new Date());
//        //opening registration page
//        homePage.registerPage();
//        //passing the registration details
//        registrationValues.registrationDetails();
//        //clicking on registration button
//        clickOnElement(By.id("register-button"));
//        //verifying successful registration
//        regverify.verifySuccessfulRegistration();
//    }
//
//    @Test(priority = 2)
//    public void userShouldBeAbleToLogin(){
//        homePage.registerPage();
//        //passing the registration details
//        registrationValues.registrationDetails();
//        //clicking on registration button
//        clickOnElement(By.id("register-button"));
//        //verifying successful registration
//        regverify.verifySuccessfulRegistration();
//        //clicking on login button
//        homePage.loginPage();
//        //passing log in details
//        logInPage.enterLoginDetails();
//
//    }
//    @Test(priority = 4)
//    public void referAProductToFriend(){
//        //opening registration page
//        homePage.registerPage();
//        //passing registration details
//        registrationValues.registrationDetails();
//        //clicking on registration button
//        clickOnElement(By.id("register-button"));
//        // verifying registration is successfull
//        regverify.verifySuccessfulRegistration();
//        //opening camera and photo page
//        homePage.cameraAndPhotoPage();
//        //opening referring camera lecia t mirror page
//        cameraAndPhotoPage.leciaTMirrorlessCamera();
//        //referring friend with email address
//        leciaCameraPage.emailAFriend();
//        //passing msg
//        productMailToFriendPage.enterFriendEmailAndPersonalMsg();
//    }
//    @Test(priority = 3)
//    public void buildComputer(){
//        //opening building your own computer page
//        homePage.buildComputer();
//        //selecting computer parts
//        buildOwnComputerPage.selectComputerParts();
//
//    }
//    @Test
//    public void listOfDesktopElement(){
//        //open home page
//
//        //hoover over computer
//        homePage.desktopPage();
//
//        desktopPage.listoFItemHeader();
//
//    }

    //testing currency display
    @Test
    public void currencyCheck(){
        //clicking on currency button
        clickOnElement(By.id("customerCurrency"));
        homePage.selectCurrency();
    }

    //testing facebook link
    @Test
    public void verifyFacebookPage() throws InterruptedException {
        //storing window handle in the local variable parent
        String parent=homePage.getHomePageWindowHandle();
        //System.out.println(parent);
        //clickOnElement(By.linkText("Facebook"));
        //clicking on facebook icon
        homePage.clickOnFacebook();
        //retrieving all current window handles and storing in the set of list
        Set<String> list=driver.getWindowHandles();
        //retrieving current window url
        String urlName=driver.getCurrentUrl();
        System.out.println(urlName);

        //looping through the window handles list
        for(String s:list){
            // giving condition if parent not one of the list
            if(!parent.equals(s)){
                //swapping the second window
                driver.switchTo().window(s);
                //verifying that current url have suffix Facebook
                String curentUrl=driver.getCurrentUrl();
                System.out.println(curentUrl);
                Assert.assertTrue(curentUrl.endsWith("nopCommerce"),"URL does not have a webpage word");

                //driver.switchTo().alert().dismiss();
                //dismissing the popup window
                driver.findElement(By.xpath("//div[@class='x1exxf4d x13fuv20 x178xt8z x1l90r2v x1pi30zi x1swvt13']//span[@class='x193iq5w xeuugli x13faqbe x1vvkbs xlh3980 xvmahel x1n0sxbx x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x4zkp8e x3x7a5m x6prxxf xvq8zen x1s688f x1dem4cn']/span[1]")).click();
                waitingTime(50);
                //dismissing facebook login popup
                driver.findElement(By.xpath("//div[@class='x92rtbv x10l6tqk x1tk7jg1 x1vjfegm']/div[1]")).click();
                //storing facebook main page header in the local variable
                String actual=driver.findElement(By.xpath("//div[@class='x1e56ztr x1xmf6yo']/span/h1")).getText();
                //String expected="NopCommerce ";
                //verifying actual message with expected message
                Assert.assertEquals(actual,loadProperty.getValue("facebookMainPageHeader"),"didn't match the message");
                //closing current window
                driver.findElement(By.)
                driver.close();
                //moving to parent window or main window
                driver.switchTo().window(parent);
            }
            //Storing main page header in the local variable
            String mainPageActualMsg =driver.findElement(By.xpath("//div[@class='topic-block']/div/h2")).getText();
            // declaring expected message
            String expectedMsg="Welcome to our store";
            // verifying actual and expected message
            Assert.assertEquals(mainPageActualMsg, expectedMsg, "You may not be in the main page because main page message does not match");
        }
    }
    @Test
    public void verifyTwitterPage(){
        homePage.clickOnTwitter();
    }

//testing for new release comments
    @Test
    public void newReleaseCommentVerify() {
        homePage.clickOnElement(By.linkText("nopCommerce new release!"));
        try {
            waitingTime(9000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        newRelease.writeCommentTitleAndComments();
        clickOnElement(By.name("add-comment"));
        newRelease.verifyMessageAfterPosting();
        newRelease.toFindMyCommentLastOne();
    }

    //testing for empty searched alert message
    @Test
    public void toVerifyEmptySearchAlert(){
        //clickOnElement(By.xpath("//div[@class='search-box store-search-box']/form/button"));
        clickOnHMPageSearchButton();
        try {
            waitingTime(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        alertText();
        verifyAlertText(loadProperty.getValue("alertMsg"));
        acceptAlert();
    }

    //testing for empty vote button click alert message

    @Test
    public void verifyVoteAlert(){
        clickOnElement(By.id("vote-poll-1"));
        alertText();
        verifyAlertText(loadProperty.getValue("voteAlertExpectedMsg"));
        acceptAlert();
    }

    //testing for search items titles have prefix searched word
@Test
    public void toVerifySearchedText(){
        sendValue(By.id("small-searchterms"),loadProperty.getValue("searchItem"));
        clickOnHMPageSearchButton();
        searchedPage.searchItems();
    }

    //testing missing add to cart
@Test
    public void toVerifyMissingAddToCart(){
        homePage.cameraAndPhotoPage();
        cameraAndPhotoPage.addToCartButtonsList();
    }

}
