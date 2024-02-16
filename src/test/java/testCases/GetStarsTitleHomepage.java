package testCases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetStarsTitleHomepage extends BaseTest {

    @Test
    public void getStarCategory() {
        boolean isCategoryListed = driver.findElement(By.xpath(ORproperties.getProperty("starSigns"))).isDisplayed();
        Assert.assertTrue(isCategoryListed, "Category is missing on the homepage"); // Test OK
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
