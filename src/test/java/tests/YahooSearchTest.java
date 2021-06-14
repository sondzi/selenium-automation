package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.YahooHomePage;

public class YahooSearchTest extends BaseTest {
    @Test
    public void yahooSearch(){
        String term = "elden ring";

        YahooHomePage homePage = new YahooHomePage(driver);
        homePage.yahooSearch(term);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("results")));
        WebElement searchResults = driver.findElement(By.id("results"));

        Assert.assertTrue(searchResults.getText().toLowerCase().contains("announced"));
    }
}
