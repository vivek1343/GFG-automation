package org.example.GfgExplore;

import org.example.FlowsClass.CourseFlow;
import org.example.FlowsClass.ProfileFlow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {

        File file = new File("/Users/vivek.sagal/IdeaProjects/GfgMavien/src/main/java/org/example/Testcases");
        Scanner sc = new Scanner(file);
        ArrayList<String> a = new ArrayList<>();
        String ans = "";
        while (sc.hasNextLine()) {
            a.add(sc.nextLine());
        }
        ArrayList<String> tests = new ArrayList<>();
        for (String i : a) {
            if (i.isEmpty()) {
                tests.add(ans.substring(0, ans.length() - 1));
                ans = "";
            } else {
                ans += i + " ";
            }
        }
        tests.add(ans.substring(0, ans.length() - 1));

        for (String i : tests)
        {
            String arr[] = i.split(" ");
            WebDriver driver=launch();
            if (arr[0].toLowerCase().contains("explore"))
            {
                ExploringProfile explore = new ExploringProfile(driver);
                if (arr[1].toLowerCase().contains("myprofile"))
                {
                    ProfileFlow pfob = new ProfileFlow(arr);
                    explore.myprofile("My Profile", pfob);
                }
                else if (arr[1].toLowerCase().contains("mycourses"))
                {
                    CourseFlow cf=new CourseFlow(arr);
                    explore.mycourses("My Courses", cf);
                }
            }
            driver.close();
        }
    }

    static WebDriver launch()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/vivek.sagal/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://auth.geeksforgeeks.org/?to=https://www.geeksforgeeks.org/");
        try {
            login acc = new login(driver);
            acc.ThroughEmail("sagalavivek@gmail.com");
            driver.manage().window().maximize();

        } catch (Exception e) {
            System.out.println(e);
        }
        return driver;
    }

}