package GfgExplore;

import GfgExplore.MyCourses.Courses;
import Screenshot.Screenshot;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ExploringProfile {
    WebDriver driver;
    ExploringProfile(WebDriver driver)
    {
        this.driver=driver;

    }
   void Myaccount(String val) throws InterruptedException {
       this.driver.findElement(By.id("userProfileId")).click();
       Thread.sleep(1000);
       myAccountGet(val);
    }
    void myAccountGet(String val)throws InterruptedException
    {
        this.driver.findElement(By.xpath("//span[text()=\""+val+"\"]")).click();
        Thread.sleep(1000);
        if(val.equals("My Courses"))
        {
            System.out.println("Courses page successfully launched");
            Courses c=new Courses(driver);
            try {
                c.enrolled();
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        else if (val.equals("My Profile")) {

            Progress("2021");
        }

    }
    void Progress(String year)throws InterruptedException
    {
        this.driver.findElement(By.xpath("//div/a/span[text()=\"Profile\"]")).click();
        Thread.sleep(2000);
        WebElement heatMap=this.driver.findElement(By.cssSelector(".heatmap-year-select.browser-default"));
        Select se=new Select(heatMap);
        se.selectByValue(year);
        if(heatMap.isDisplayed()) {
            Screenshot sc=new Screenshot(driver);
            sc.capture("progress");
            driver.close();
        }
    }
    
}
