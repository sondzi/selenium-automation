package oldTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseTest;

public class YahooSearchTest extends BaseTest {
    @Test

    public void yahooSearch(){
        driver.get("https://www.yahoo.com/");

        WebElement searchBar = driver.findElement(By.id("ybar-sbq"));
        searchBar.sendKeys("blic");

        WebElement searchButton = driver.findElement(By.id("ybar-search"));
        searchButton.click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("results")));
        WebElement searchResults = driver.findElement(By.id("results"));

        Assert.assertTrue("Term not found", searchResults.getText().contains("blic"));
    }

}
