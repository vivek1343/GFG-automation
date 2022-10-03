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
       MyProfile(val);
    }
    void MyProfile(String val)throws InterruptedException
    {
        this.driver.findElement(By.xpath("//span[text()=\""+val+"\"]")).click();
        Thread.sleep(1000);
        Progress();
    }
    void Progress()throws InterruptedException
    {
        this.driver.findElement(By.xpath("//div/a/span[text()=\"Profile\"]")).click();
        Thread.sleep(2000);
        WebElement year=this.driver.findElement(By.cssSelector(".heatmap-year-select.browser-default"));
        Select se=new Select(year);
        se.selectByValue("2021");
        if(year.isDisplayed()) {
            System.out.println("Progress");
            driver.close();
        }
    }
    void MyCourses()
    {
        WebElement next = this.driver.findElement(By.xpath("//li[contains(@id," +
                "\"userProfileId\")]/ul/li/a/span[contains(@class,\"gfg-icon gfg-icon_courses\")]"));
        next.click();
        System.out.println("Courses page successfully launched");
    }
    void freecourses () throws InterruptedException
    {
        System.out.println("inside the free course part");
        this.driver.findElement(By.xpath("//li/a[contains(@data-id,\"2\")]")).click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) (this.driver);
        js.executeScript("window.scrollBy(0,350)", "");
        this.driver.findElement(By.xpath("//*[@id=\"free-courses-content\"]/div/a")).click();
        this.driver.findElement(By.xpath("//*[@id=\"__next\"]" +
                "/div/div[3]/div[1]/div/div[2]/form/div/div/input")).sendKeys("java");
        Thread.sleep(4000);
        this.driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[1]/div/div[2]/form/div/div/button")).click();
        System.out.println("successfully automated");
    }
    void registered () throws InterruptedException
    {
        System.out.println("inside the registered courses part");
        this.driver.findElement(By.xpath("//li/a[contains(@data-id,\"0\")]")).click();
        Thread.sleep(3000);
        this.driver.findElement(By.xpath("//a[text()=\"Pay Online\"]")).click();
        System.out.println("successfully automated");
    }
    void enrolled () throws InterruptedException {
        System.out.println("inside the enrolled courses part");
        WebElement course = this.driver.findElement(By.cssSelector(".button-text"));
        course.click();
        Thread.sleep(4000);
        List<WebElement> data = this.driver.findElements(By.xpath("//p[contains(@class,\"batch_title__XImuz\")]"));
        for (WebElement val : data)
        {
            if("Introduction".equals(val.getText())) {
                val.click();
                break;
            }
        }
        List<WebElement> content=driver.findElements(By.xpath("//div[contains(@class,\" progress scrollable_content\")]/a"));
        for(WebElement name:content){if(name.getText().equals("Order of Growth"))name.click();break;}

    }
}
