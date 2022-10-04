package GfgExplore;

import GfgExplore.ExploringProfile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.setProperty("webdriver.chrome.driver", "/Users/vivek.sagal/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://auth.geeksforgeeks.org/?to=https://www.geeksforgeeks.org/");
        login acc=new login(driver);
        acc.ThroughEmail("sagalavivek@gmail.com");
        driver.manage().window().maximize();
        ExploringProfile explore=new ExploringProfile(driver);
        explore.Myaccount("My Courses");
        driver.close();
    }
}