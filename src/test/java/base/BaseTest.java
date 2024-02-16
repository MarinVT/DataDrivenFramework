package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

// Acts as a parent class for all test cases
public class BaseTest {

    /* Initializing all things below
        WebDriver
        Properties
        Logs
        ExtentReports
     */

    public static WebDriver driver;
    public static Properties configProperties = new Properties();
    public static Properties ORproperties = new Properties();
    public static FileInputStream fileInputStream;

    @BeforeSuite
    public void setUp() {

        if (driver == null) {

            try {
                fileInputStream = new FileInputStream("src/test/resources/properties/Config.properties");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            try {
                configProperties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fileInputStream = new FileInputStream("src/test/resources/properties/OR.properties");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            try {
                ORproperties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (configProperties.getProperty("browserName").equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().deleteAllCookies();

            } else if (configProperties.getProperty("browserName").equals("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("/usr/lib/firefox/firefox");
                driver = new FirefoxDriver(options);
                driver.manage().deleteAllCookies();
            } else {
                System.out.println("Browser is not Chrome or Firefox!!!!!");
            }

            driver.get(configProperties.getProperty("testsiteurl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        }

    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }

}
