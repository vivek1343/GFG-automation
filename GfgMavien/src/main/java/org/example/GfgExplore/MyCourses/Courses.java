package org.example.GfgExplore.MyCourses;

import org.example.FlowsClass.CourseFlow;
import org.example.Scroll.scroll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.util.List;

public class Courses {
    WebDriver driver;
    public Courses(WebDriver driver)
    {
        this.driver=driver;
    }
    public void freecourses() throws InterruptedException
    {
        System.out.println("inside the free course part");
        driver.findElement(By.xpath("//*/a[text()=\"Free Courses\"]")).click();
        Thread.sleep(3000);
        scroll sc=new scroll(driver);
        sc.scrollDown(300);
        this.driver.findElement(By.xpath("//*[@id=\"free-courses-content\"]/div/a")).click();
        this.driver.findElement(By.xpath("//*[@id=\"__next\"]" +
                "/div/div[3]/div[1]/div/div[2]/form/div/div/input")).sendKeys("java");
        Thread.sleep(4000);
        this.driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[1]/div/div[2]/form/div/div/button")).click();
        System.out.println("successfully automated");
    }
    public void registered () throws InterruptedException
    {
        System.out.println("inside the registered courses part");
        driver.findElement(By.xpath("//*/a[text()=\"Registered Courses\"]")).click();
        Thread.sleep(3000);
        this.driver.findElement(By.xpath("//a[text()=\"Pay Online\"]")).click();
        System.out.println("successfully automated");
    }
    public void enrolled (CourseFlow ob) throws InterruptedException {
        System.out.println("inside the enrolled courses part");
        driver.findElement(By.xpath("//*/a[text()=\"Enrolled Courses\"]")).click();
        Thread.sleep(2000);
        scroll sc=new scroll(driver);
        sc.scrollByPage();
        WebElement course = this.driver.findElement(By.cssSelector(".button-text"));
        course.click();
        Thread.sleep(4000);
        List<WebElement> data = this.driver.findElements(By.xpath("//p[contains(@class,\"batch_title__XImuz\")]"));
        for (WebElement val : data)
        {
            if(ob.getChapter().equalsIgnoreCase(val.getText())) {
                scroll s1=new scroll(driver);
                s1.scrollByVisibleElement(val);
                val.click();
                break;
            }
        }
        Thread.sleep(2000);
        List<WebElement> content=driver.findElements(By.xpath("//div[contains(@class,\" progress scrollable_content\")]/a"));
        for(WebElement name:content){
            if(name.getText().equals(ob.getVideoname()))
            {
                Thread.sleep(1000);
                scroll s2=new scroll(driver);
                s2.scrollByVisibleElement(name);
                name.click();
                break;
            }
        }

    }
}
