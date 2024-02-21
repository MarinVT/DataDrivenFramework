package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtil extends BaseTest {

    public static String screenshotPath;
    public static String screenshotName;

    public static void captureScreenshot() throws IOException {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Date d = new Date();
        screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

        FileUtils.copyFile(scrFile,
                new File(System.getProperty("/target/surefire-reports/html/") + screenshotName));
        FileUtils.copyFile(scrFile,
                new File("./reports/" + screenshotName));

    }

}
