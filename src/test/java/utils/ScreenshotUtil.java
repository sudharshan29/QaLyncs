package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String testName) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src,
                    new File(System.getProperty("user.dir") + "/screenshots/" + testName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}