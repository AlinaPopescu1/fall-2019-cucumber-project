package com.cybertek.library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JqueryPage extends PageBase {

    @FindBy (css = "iframe.demo-frame")
            public WebElement iframe;

    @FindBy (xpath = "//div[@id='draggable']")
            public WebElement sourceDrag;

    @FindBy (xpath = "//div[@id='droppable']")
    public WebElement targetDrop;

//
//            driver.get("https://jqueryui.com/droppable/");
//        Thread.sleep(4000);
//    WebElement iframeElement = driver.findElement(By.cssSelector("iframe.demo-frame"));
//        driver.switchTo().frame(iframeElement);
//    WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
//    WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));
//
//        new Actions(driver).dragAndDrop(draggable, droppable).build().perform();
}
