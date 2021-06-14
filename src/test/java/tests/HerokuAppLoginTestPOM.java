package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HerokuAppLoginPage;

public class HerokuAppLoginTestPOM extends BaseTest {
    @Test
    public void unsuccessfulLoginTest() throws InterruptedException {
        String username = "toma";
        String password = "SuperSecretPassword!";

        HerokuAppLoginPage loginPage = new HerokuAppLoginPage(driver);
        loginPage.login(username, password);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
        WebElement redBanner = driver.findElement(By.id("flash"));

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("fa-sign-in")));
        WebElement loginButton = driver.findElement(By.className("fa-sign-in"));

        Assert.assertTrue(redBanner.getText().contains("Your username is invalid!"));
        Assert.assertTrue(loginButton.getText().contains("Login"));

        Thread.sleep(3000);
    }
    @Test
    public void successfullLoginTest() throws InterruptedException {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        HerokuAppLoginPage loginPage = new HerokuAppLoginPage(driver);

        loginPage.login(username, password);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
        WebElement greenBanner = driver.findElement(By.id("flash"));

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("icon-signout")));
        WebElement logoutButton = driver.findElement(By.className("icon-signout"));

        Assert.assertTrue(greenBanner.getText().contains("You logged into a secure area!"));
        Assert.assertTrue(logoutButton.getText().contains("Logout"));

        Thread.sleep(3000);


    }

}
