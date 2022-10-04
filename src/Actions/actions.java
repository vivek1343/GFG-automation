package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class actions {
    WebDriver driver;
    Actions action;

    public actions(WebDriver driver)
    {
        this.driver=driver;
        this.action=new Actions(driver);

    }
    public void performHover(WebElement hover)
    {
        action.moveToElement(hover).perform();
    }
    public void doubleClick(WebElement element)
    {
        action.doubleClick(element).perform();
    }
    public void rightClick(WebElement element)
    {
        action.contextClick(element).perform();
    }
}
