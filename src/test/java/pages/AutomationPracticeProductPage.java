package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import  org.openqa.selenium.support.ui.Select;

public class AutomationPracticeProductPage extends BaseHelper {

    @FindBy(id = "color_8")
    WebElement whiteColour;

    @FindBy(id = "group_1")
    WebElement allSizes;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button")
    WebElement addToCartButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a")
    WebElement proceedButton;

    WebDriver driver;
    public AutomationPracticeProductPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void pickSize(){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("group_1")));
        Select dropdownSizes = new Select(driver.findElement(By.id("group_1")));
        dropdownSizes.selectByVisibleText("L");
    }

    private void pickColour(){
        whiteColour.click();
    }

    private void addToCart(){
        addToCartButton.click();
    }

    private void proceedToCheckout(){
        wdWait.until(ExpectedConditions.visibilityOf(proceedButton));
//        proceedButton.click();
        js.executeScript("arguments[0].click();", proceedButton);
    }

    public void orderProduct(){
        pickSize();
        pickColour();
        addToCart();
        proceedToCheckout();
    }
}
