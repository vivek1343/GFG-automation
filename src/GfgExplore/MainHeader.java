package GfgExplore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Actions.*;

import java.util.List;


public class MainHeader {
    WebDriver driver;
    actions a;
    MainHeader(WebDriver driver)
    {
        this.driver=driver;
        actions a=new actions(this.driver);
        this.a=a;
    }

    void Mainheader(String val) throws InterruptedException
    {
        WebElement hover=driver.findElement(By.xpath("//span[.=\""+val+"\"]"));
        a.performHover(hover);
        listcourses("For Students");
    }
   void listcourses(String ob) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> list=driver.findElements(By.xpath("//span[.=\"For Students\"]/parent::li/parent::ul"));
       for (WebElement topic:list)
       {
           if(ob.equals(topic.getText()))
           {
               a.performHover(topic);
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
                System.out.println("Course selected");
                driver.close();
                break;
            }
        }
    }
    void Tutorials()
    {
        WebElement hover= driver.findElement(By.xpath("//span[.=\"Tutorials\"]"));
        a.performHover(hover);
        listTutorial();
    }
    void listTutorial()
    {
        List<WebElement> list=driver.findElements(By.xpath("//li[contains(@class,\"header-main__list-item\")][2]/ul/li"));
        for (WebElement topic:list)
        {
            if("Student".equals(topic.getText()))
            {
                a.performHover(topic);
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

}
