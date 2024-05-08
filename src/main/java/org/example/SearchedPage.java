package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchedPage extends Utility{

    public void searchItems(){
        //List<WebElement> productsTitle=getTextFromElement(By.xpath("//div[@class='details']/h2/a"));
        List<WebElement> productsTitle=driver.findElements(By.xpath("//div[@class='details']/h2/a"));
        //ArrayList<String> products=getTextFromElement(By.xpath("//div[@class='details']/h2/a"));
        for(WebElement element:productsTitle){
            String title=element.getText();
            System.out.println(title);
            Assert.assertTrue(title.startsWith(loadProperty.getValue("searchItem")),"Searched text does not match");
        }


    }
}
