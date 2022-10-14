package org.example.GfgExplore;

import org.example.FlowsClass.CourseFlow;
import org.example.FlowsClass.ProfileFlow;
import org.example.GfgExplore.MyCourses.Courses;
import org.example.GfgExplore.Myprofile.profile;
import org.openqa.selenium.*;

import java.util.Locale;


public class ExploringProfile {
    WebDriver driver;

    ExploringProfile(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        this.driver.findElement(By.id("userProfileId")).click();
        Thread.sleep(1000);
    }

    void myprofile(String val, ProfileFlow ob) throws InterruptedException {

        this.driver.findElement(By.xpath("//span[text()=\"" + val + "\"]")).click();
        Thread.sleep(1000);
        profile p = new profile(driver);
        p.Progress( ob);
    }

    void mycourses(String val, CourseFlow ob) throws InterruptedException {
        this.driver.findElement(By.xpath("//span[text()=\"" + val + "\"]")).click();
        Thread.sleep(1000);
        System.out.println("Courses page successfully launched");
        Courses c = new Courses(driver);
        try {
            if(ob.getCourses().equalsIgnoreCase("enrolled"))
                c.enrolled(ob);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
