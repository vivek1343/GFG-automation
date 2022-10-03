import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class hovering {
    WebDriver driver;
    hovering(WebDriver driver)
    {
        this.driver=driver;
    }
    void Mainheader(String val) throws InterruptedException
    {
        WebElement hover=driver.findElement(By.xpath("//span[.=\""+val+"\"]"));
        hover(hover);
        Thread.sleep(2000);
        listcourses("For Students");
    }
   void listcourses(String ob) throws InterruptedException {
        List<WebElement> list=driver.findElements(By.xpath("//span[.=\"For Students\"]/parent::li/parent::ul"));
        for (WebElement topic:list)
        {
            if(ob.equals(topic.getText()))
            {
                hover(topic);
                break;
            }
        }
        getForStudents("CIP (Self-Paced)");
    }

    void getForStudents(String ob) throws InterruptedException {
        List<WebElement> list= driver.findElements(By.xpath("//span[text()=\"For Students\"]/parent::li/ul/li"));
        for(WebElement cour:list)
        {
            if(ob.equals(cour.getText()))
            {
                cour.click();
                break;
            }
        }
        System.out.println("Course selected");

    }
    void systemdesign() throws InterruptedException {
        driver.findElement(By.xpath("//div[1]/div[1]/ul[1]/li[1]/ul/li[1]/ul/li[1]/ul/li[2]/a")).click();
        driver.navigate().refresh();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"mainCourseCard\"]/div[1]/div/div[2]/div/div[2]/div/div/button")).click();
        System.out.println("Insisde the system design");
    }

    void Tutorials()
    {
        WebElement hover= driver.findElement(By.xpath("//span[.=\"Tutorials\"]"));
        hover(hover);
        listTutorial();
    }
    void listTutorial()
    {
        List<WebElement> list=driver.findElements(By.xpath("//li[contains(@class,\"header-main__list-item\")][2]/ul/li"));
        for (WebElement topic:list)
        {
            if("Student".equals(topic.getText()))
            {
                hover(topic);
                break;
            }
        }
        studentsList();
    }
    void studentsList()
    {
        List<WebElement> list= driver.findElements(By.xpath("//div[1]/div[1]/ul[1]/li[2]/ul/li[13]/ul/li"));
        for(WebElement val: list){if(val.getText().equals("Placement Course")){val.click(); break;}}


    }
    void hover(WebElement hover)
    {
        Actions action=new Actions(driver);
        action.moveToElement(hover).perform();
    }
}
