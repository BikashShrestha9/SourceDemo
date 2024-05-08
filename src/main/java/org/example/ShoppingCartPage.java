package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ShoppingCartPage extends Utility {
    LoadProperty loadProperty= new LoadProperty();

    public void verifyShoppingItem(){
        //checking expected message with actual message
        Assert.assertEquals(getTextFromElement(By.className("product-name")), loadProperty.getValue("buildComputerExpectedMsg"), "Message did not match therefore test failed");
    }
}

