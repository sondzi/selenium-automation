package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlicHomePage extends BaseHelper {

    @FindBy(className = "fa-search")
    WebElement magnifyingGlassIcon;

    @FindBy(id = "search-field-head")
    WebElement unesiPojamField;

    @FindBy(xpath = "/html/body/header/div[1]/div/div[3]/form/button")
    WebElement traziButton;

    WebDriver driver;
    public BlicHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToBlicHP(){
        driver.get("https://www.blic.rs/");
    }

    private void clickOnMagnifyingGlass() throws InterruptedException {
        wdWait.until(ExpectedConditions.elementToBeClickable(magnifyingGlassIcon));

        Thread.sleep(500);
        magnifyingGlassIcon.click();
    }

    private void enterSearchTerm(String term) throws InterruptedException {
        wdWait.until(ExpectedConditions.visibilityOf(unesiPojamField));
        unesiPojamField.sendKeys(term);
    }

    private void clickOnTraziButton(){
        traziButton.click();
    }

    public void blicSearch(String term) throws InterruptedException {
        navigateToBlicHP();
        clickOnMagnifyingGlass();
        enterSearchTerm(term);
        clickOnTraziButton();
    }
}
