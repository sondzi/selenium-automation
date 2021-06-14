package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DonesiHomePage extends BaseHelper {

    @FindBy(className = "address-form-component-search-input")
    WebElement unesiteVasuAdresuField;

    @FindBy(className = "address-form-component-list")
    WebElement addressesDropdown;

    @FindBy(xpath = "/html/body/div[2]/main/div/section[1]/div[2]/div/div/div/div/div[2]/form/div[2]/div[1]/div[2]/button")
    WebElement naruciteButton;

    @FindBy(className = "button-map-submit")
    WebElement nastaviteButton;

    WebDriver driver;
    public DonesiHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToHomePage(){
        driver.get("https://www.donesi.com/");
    }

    private void enterAddressInUnesiteVasuAdresu(String address){
        unesiteVasuAdresuField.sendKeys(address);
    }

    private void clickOnAddressInDropdown(){
        wdWait.until(ExpectedConditions.visibilityOf(addressesDropdown));
        List<WebElement> allAddressess = addressesDropdown.findElements(By.tagName("li"));
        WebElement myAddress = allAddressess.get(0);
        myAddress.click();
    }

    private void clickOnNaruciteButton(){
        naruciteButton.click();
    }

    private void clickOnNastaviteButton(){
        wdWait.until(ExpectedConditions.visibilityOf(nastaviteButton));
        nastaviteButton.click();
    }

    public void enterAddress(String address){
        navigateToHomePage();
        enterAddressInUnesiteVasuAdresu(address);
        clickOnAddressInDropdown();
        clickOnNaruciteButton();
        clickOnNastaviteButton();
    }

}
