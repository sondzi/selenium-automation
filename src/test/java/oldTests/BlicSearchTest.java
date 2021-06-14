package oldTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseTest;

public class BlicSearchTest extends BaseTest {
    @Test
    public void blicSearch() throws InterruptedException {
        driver.get("https://www.blic.rs/");

        WebElement searchIcon = driver.findElement(By.className("fa-search"));
        searchIcon.click();

        WebElement searchBar = driver.findElement(By.id("search-field-head"));
        searchBar.sendKeys("korona");

        WebElement searchButton = driver.findElement(By.className("fa-angle-double-right"));
        searchButton.click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("search__results")));
        WebElement searchResults = driver.findElement(By.className("search__results"));

        Assert.assertTrue(searchResults.getText().toLowerCase().contains("korona"));

        Thread.sleep(3000);
    }
}
