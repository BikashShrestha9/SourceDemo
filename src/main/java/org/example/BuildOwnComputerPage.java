package org.example;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class BuildOwnComputerPage extends Utility {
    HomePage homePage=new HomePage();
    public void selectComputerParts(){
        homePage.buildComputer();
        selectByValue(By.id("product_attribute_1"), "2");

        //selecting RAM for the computer
        selectByValue(By.id("product_attribute_2"), "4");
        //selecting HDD for the computer
        clickOnElement(By.id("product_attribute_3_7"));
        //selecting OS for the computer
        clickOnElement(By.id("product_attribute_4_9"));
        //deselecting first item
        clickOnElement(By.id("product_attribute_5_10"));
        //selecting software for the computer
        clickOnElement(By.id("product_attribute_5_11"));

        //adding to the cart
        clickOnElement(By.id("add-to-cart-button-1"));
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //navigating to the cart page
        clickOnElement(By.className(("cart-label")));
    }

}
