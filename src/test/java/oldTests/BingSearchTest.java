package oldTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseTest;

public class BingSearchTest extends BaseTest {
    @Test
    public void bingSearch() throws InterruptedException {
        driver.get("https://www.bing.com/");

        WebElement searchBox = driver.findElement(By.id("sb_form_q"));
        searchBox.sendKeys("Microsoft");

        WebElement searchButton = driver.findElement(By.className("tooltip"));
        searchButton.click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("b_results")));
        WebElement searchResults = driver.findElement(By.id("b_results"));

        Assert.assertTrue("Term not found", searchResults.getText().contains("Microsoft"));

        Thread.sleep(3000);
    }
}
