package GfgExplore.MyCourses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Courses {
    WebDriver driver;
    public Courses(WebDriver driver)
    {
        this.driver=driver;
    }
    public void freecourses () throws InterruptedException
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
    public void registered () throws InterruptedException
    {
        System.out.println("inside the registered courses part");
        this.driver.findElement(By.xpath("//li/a[contains(@data-id,\"0\")]")).click();
        Thread.sleep(3000);
        this.driver.findElement(By.xpath("//a[text()=\"Pay Online\"]")).click();
        System.out.println("successfully automated");
    }
    public void enrolled () throws InterruptedException {
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
