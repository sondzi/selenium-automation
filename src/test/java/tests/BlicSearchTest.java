package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BlicHomePage;

import java.util.List;

public class BlicSearchTest extends BaseTest {
    @Test
    public void blicSearchTest() throws InterruptedException {
        String term = "comtrade";

        BlicHomePage homePage = new BlicHomePage(driver);
        homePage.blicSearch(term);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("search__results")));
        WebElement searchResults = driver.findElement(By.className("search__results"));
        List<WebElement> articles = searchResults.findElements(By.tagName("article"));

        Assert.assertEquals("Not 24 articles", 24, articles.size());
        for(WebElement x:articles){
            System.out.println(x.getText() + System.lineSeparator());
        }
        Thread.sleep(3000);
    }
}
