package org.example.GfgExplore.Myprofile;

import org.example.FlowsClass.ProfileFlow;
import org.example.Scroll.scroll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Institutions {
    WebDriver driver;
    public Institutions(WebDriver driver)
    {
        this.driver=driver;
        this.driver.findElement(By.xpath("//div/a/span[text()=\"Institutions\"]")).click();
    }
    public void search(ProfileFlow ob) throws InterruptedException {
        scroll s = new scroll(driver);
        boolean flag=false;
        while (!flag){
            List<WebElement> list = driver.findElements(By.xpath("//td[@class=\"institute_name_td\"]/a"));
            for (WebElement element : list) {
                if (element.getText().toLowerCase().contains(ob.getInstName())) {
                    s.scrollByVisibleElement(element);
                    element.click();
                    Thread.sleep(2000);
                    driver.navigate().back();
                    flag=true;
                    break;
                }
            }
            s.scrollByPage();
            driver.findElement(By.xpath("//li[@class=\"active\"]/" +
                    "a[@class=\"pageBtn\"]/parent::li/following-sibling::li[1]")).click();
        }
        Organizations company=new Organizations(driver);
        company.searchOrganization(ob);
    }

}
