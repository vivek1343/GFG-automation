package org.example.GfgExplore.Myprofile;

import org.example.Actions.actions;
import org.example.FlowsClass.ProfileFlow;
import org.example.Scroll.scroll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Organizations {
    WebDriver driver;
    public Organizations(WebDriver driver)
    {
        this.driver=driver;
        this.driver.findElement(By.xpath("//div/a/span[text()=\"Organizations\"]")).click();
    }
    public void searchOrganization(ProfileFlow ob) throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder=\"Search An Organization\"]")).sendKeys(ob.getOrgName().substring(0,3));
        Thread.sleep(2000);
        List<WebElement> companyNames=driver.findElements(By.xpath("//*[@id=\"college_results\"]/li"));
        for(WebElement company:companyNames)
        {
            if(company.getText().equalsIgnoreCase(ob.getOrgName()))
            {
                Thread.sleep(1000);
                company.click();
                break;
            }
        }
        searchOrganizationByPages(ob);
    }
    public void searchOrganizationByPages(ProfileFlow ob) throws InterruptedException {
        scroll s = new scroll(driver);
        boolean flag=false;
        while (!flag)
        {
            Thread.sleep(2000);
            List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"organization_name_div\"]"));
            for (WebElement element : list) {
                if (element.getText().equalsIgnoreCase(ob.getOrgName())) {
                    s.scrollByVisibleElement(element);
                    element.click();
                    flag=true;
                    break;
                }
            }
            s.scrollByPage();
            driver.findElement(By.xpath("//li[@class=\"active\"]/" +
                    "a[@class=\"pageBtn\"]/parent::li/following-sibling::li[1]")).click();
        }
        driver.findElement(By.xpath("//div/a/span[text()=\"Logout "+ob.getUserName()+"\"]")).click();
    }
}
