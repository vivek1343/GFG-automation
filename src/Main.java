import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
        int val=2;
        if(val==1) {
            ExploringProfile explore=new ExploringProfile(driver);
            explore.Myaccount("My Profile");
        }
        if(val==2)
        {
            hovering hover=new hovering(driver);
            hover.Mainheader("Courses");
        }
    }
}