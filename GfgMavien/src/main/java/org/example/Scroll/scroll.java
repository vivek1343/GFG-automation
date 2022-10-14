package org.example.Scroll;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class scroll {
    WebDriver driver;
    JavascriptExecutor js;
    public scroll(WebDriver driver)
    {
        this.driver=driver;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        this.js=js;
    }
    public void scrollDown(int pixel)
    {
        String s=Integer.toString(pixel);
        js.executeScript("window.scrollBy(0,"+s+")");
    }
    public void scrollByVisibleElement(WebElement element)
    {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void scrollByPage()
    {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void scrollHorizontal(WebElement element)
    {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

}
