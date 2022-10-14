package org.example.GfgExplore.Myprofile;

import org.example.FlowsClass.ProfileFlow;
import org.example.Screenshot.Screenshot;
import org.example.Scroll.scroll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class profile {
    WebDriver driver;
    public profile(WebDriver driver) throws InterruptedException {
        this.driver=driver;
        this.driver.findElement(By.xpath("//div/a/span[text()=\"Profile\"]")).click();
        Thread.sleep(2000);
    }
    public void Progress(ProfileFlow ob)
    {
        try
        {
            WebElement heatMap=this.driver.findElement(By.cssSelector(".heatmap-year-select.browser-default"));
            Select se=new Select(heatMap);
            se.selectByValue(ob.getYear());
            if(heatMap.isDisplayed()) {
                Thread.sleep(2000);
                Screenshot sc=new Screenshot(driver);
                sc.capture("progress");

            }
            problems(ob.getDifficulty(),ob.getProblemName());
            Institutions college=new Institutions(driver);
            college.search(ob);
        }
        catch (Exception e)
        {
            System.out.println("Error ----"+e);
        }

    }
    public void problems(String difficulty,String problemName) throws InterruptedException {
        scroll sc=new scroll(driver);
        sc.scrollByVisibleElement(driver.findElement(By.cssSelector(".solved_problem_section")));
        List<WebElement> list=driver.findElements(By.xpath("//ul[@class=\"tabs tabs-fixed-width linksTypeProblem\"]/li"));
        for(WebElement i:list)
        {
            if(i.getText().toLowerCase(Locale.ROOT).contains(difficulty))
            {
                i.click();
                break;
            }
        }
        switch (difficulty)
        {
            case("school"):{
                List<WebElement> list1 = driver.findElements(By.xpath("//div[@id=\"school\"]/ul/li"));
                for (WebElement i : list1) {
                    System.out.println(i.getText());
                }
            }
            case("basic"):
            {
                List<WebElement> list1 = driver.findElements(By.xpath("//div[@id=\"basic\"]/ul/li"));
                for (WebElement i : list1) {
                    if(i.getText().toLowerCase().contains(problemName))
                    {
                        sc.scrollByVisibleElement(i);
                        i.click();
                        break;
                    }
                }
            }
            case("easy"):
            {
                Thread.sleep(2000);
                List<WebElement> list1 = driver.findElements(By.xpath("//div[@id=\"easy\"]/ul/li"));
                for (WebElement i : list1) {
                    if(i.getText().toLowerCase().contains(problemName))
                    {
                        sc.scrollByVisibleElement(i);
                        i.click();
                        break;
                    }
                }
            }
            case("medium"):
            {
                List<WebElement> list1 = driver.findElements(By.xpath("//div[@id=\"medium\"]/ul/li"));
                for (WebElement i : list1) {
                    if(i.getText().toLowerCase().contains(problemName))
                    {
                        sc.scrollByVisibleElement(i);
                        i.click();
                        break;
                    }
                }
            }
            case("hard"):
            {
                List<WebElement> list1 = driver.findElements(By.xpath("//div[@id=\"hard\"]/ul/li"));
                for (WebElement i : list1) {
                    if(i.getText().toLowerCase().contains(problemName))
                    {
                        sc.scrollByVisibleElement(i);
                        i.click();
                        break;
                    }
                }
            }
        }


    }
}
