import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class login {
    WebDriver driver;
    login(WebDriver driver)
    {
        this.driver=driver;
    }
    void ThroughUserName(String username) throws InterruptedException {
        driver.findElement(By.id("luser")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys("nature1234");
        driver.findElement(By.cssSelector(".btn.btn-green.signin-button")).submit();
        System.out.println("Login successfull");
        Thread.sleep(4000);

    }
    void ThroughEmail(String email) throws InterruptedException {
        driver.findElement(By.id("luser")).sendKeys(email);
        driver.findElement(By.cssSelector("#password")).sendKeys("nature1234");
        driver.findElement(By.cssSelector(".btn.btn-green.signin-button")).submit();
        System.out.println("Login successfull");
        Thread.sleep(4000);
    }
}
