package oldTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

public class KeyPressesTest extends BaseTest {
    @Test
    public void keyPresses() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/key_presses");

        WebElement inputField = driver.findElement(By.id("target"));
        inputField.sendKeys("k");

        WebElement resultField = driver.findElement(By.id("result"));

        Assert.assertTrue("Non matching results", resultField.getText().toLowerCase().contains("k"));

        Thread.sleep(3000);
    }
}
