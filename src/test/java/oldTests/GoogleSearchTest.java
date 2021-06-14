package oldTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseTest;

import java.util.Locale;

public class GoogleSearchTest extends BaseTest {
    @Test
    public void googleSearch() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Reddit");

        wdWait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("rcnt")));
        WebElement searchResults = driver.findElement(By.id("rcnt"));

        Assert.assertTrue("Term not found", searchResults.getText().contains("Reddit"));

        Thread.sleep(3000);
    }
}
