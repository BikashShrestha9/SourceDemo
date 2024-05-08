package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

import static org.example.BasePage.driver;

public class DesktopPage extends Utility{
    //List<WebElement> listofelement= driver.findElements(By.xpath("//div[@class='ite-grid]/h2"));

    public static void listoFItemHeader(){
        List<WebElement> listofelement= driver.findElements(By.xpath("//h2[@class='product-title']"));
        //div[@class='item-grid']//div[@class='buttons']/button[1]
        //List<WebElement> listofelement= driver.findElements(By.xpath("//div[@class='item-grid']//div[@class='buttons']/button[1]"));
        //System.out.println(listofelement.size());
        //Set<String> list=driver.getWindowHandles();
        for(WebElement element:listofelement){
            element.getText();
            System.out.println(element.getText());
            Assert.assertNotNull(element.getText(), "one of the product does not have title");

        }
    }

}
