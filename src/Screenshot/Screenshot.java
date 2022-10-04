package Screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Screenshot {
    WebDriver driver;
    public Screenshot(WebDriver driver)
    {
        this.driver=driver;

    }
    public void capture(String name) {
        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(f, new File("/Users/vivek.sagal/Documents/screenshots/Screenshot/"+name+".jpg"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
