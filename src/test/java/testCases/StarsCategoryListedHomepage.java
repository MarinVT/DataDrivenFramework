package testCases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StarsCategoryListedHomepage extends BaseTest {

    @Test
    public void getStarCategory() {
        logger.debug("Inside Get category test");
        driver.findElement(By.xpath(ORproperties.getProperty("starSigns")));

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        logger.debug("Test is PASSED");
    }

}
