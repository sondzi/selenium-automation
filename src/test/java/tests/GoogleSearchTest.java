package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.GoogleHomePage;

import java.util.Locale;

public class GoogleSearchTest extends BaseTest {
    @Test
    public void googleSearchTest(){
        String searchTerm = "bloodborne";

        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.googleSearch(searchTerm);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("rcnt")));
        WebElement searchResults = driver.findElement(By.id("rcnt"));

        Assert.assertTrue("Word not present in results", searchResults.getText().toLowerCase().contains(searchTerm));
    }

}
