package oldTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseTest;

public class HerokuAppLoginTest extends BaseTest {
    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.className("fa-sign-in"));
        loginButton.click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
        WebElement secureAreaBanner = driver.findElement(By.id("flash"));
        WebElement logoutButton = driver.findElement(By.className("icon-signout"));

        Assert.assertTrue("Banner not located", secureAreaBanner.getText().contains("You logged into a secure area!"));
        Assert.assertTrue("Logout button not located", logoutButton.getText().contains("Logout"));


        Thread.sleep(3000);
    }

    @Test
    public void loginWithInvalidCredentials(){
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmit");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.className("fa-sign-in"));
        loginButton.click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));

        WebElement invalidUsernameBanner = driver.findElement(By.id("flash"));
        WebElement button = driver.findElement(By.className("fa-sign-in"));
        Assert.assertTrue("Logged in with invalid credentials", invalidUsernameBanner.getText().contains("Your username is invalid!"));
        Assert.assertTrue("Login button not found", button.getText().contains("Login"));

    }
}
