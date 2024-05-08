package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CameraAndPhotoPage extends Utility{
    public void leciaTMirrorlessCamera(){
        //navigating to the lecia T Mirroless Digital camera page
        clickOnElement(By.linkText("Leica T Mirrorless Digital Camera"));
    }

    public void addToCartButtonsList(){
        List<WebElement> elementList=driver.findElements(By.xpath("//div[@class='buttons']/button[1]"));
        //System.out.println(elementList.get(0).getText());
        for(WebElement element:elementList){
            String text = element.getText();
            Assert.assertTrue(text.contains("ADD TO CART"), "All item have a add to cart buttons");
            //System.out.println(text);
//            if(text.matches("ADD TO CARD")){
//                System.out.println("All items have add to cart");
//            }
//                System.out.println("All items does not have add to cart");
            //text.matches("ADD TO CARD");
            //System.out.println("All items have add to cart");
        }
    }
}
