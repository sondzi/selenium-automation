package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleHomePage extends BaseHelper {

    @FindBy(className = "gLFyf")
    WebElement searchField;

    @FindBy(name = "btnK")
    WebElement googleSearchButton;

    WebDriver driver;
    public GoogleHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToGoogle(){
        driver.get("https://www.google.com/");
    }
    private void enterSearchTerm(String term){
        searchField.sendKeys(term);
    }
    private void clickOnGoogleSearchButton(){
        wdWait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
        googleSearchButton.click();
    }

    public void googleSearch(String term){
        navigateToGoogle();
        enterSearchTerm(term);
        clickOnGoogleSearchButton();
    }
}
