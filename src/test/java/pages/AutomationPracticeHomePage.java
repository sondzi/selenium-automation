package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutomationPracticeHomePage extends BaseHelper {

    @FindBy(className = "blockbestsellers")
    WebElement bestSellersButton;

    @FindBy(id = "blockbestsellers")
    WebElement allBestSellers;


    WebDriver driver;
    public AutomationPracticeHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToSite(){
        driver.get("http://automationpractice.com/index.php");
    }

    private void clickOnBestSellers(){
        bestSellersButton.click();
    }

    private void pickAProduct(){
        List<WebElement> listBestSellers = allBestSellers.findElements(By.tagName("li"));
        WebElement thirdElement = listBestSellers.get(2);
        WebElement moreClick = thirdElement.findElement(By.className("lnk_view"));
//        moreClick.click();
        js.executeScript("arguments[0].click();", moreClick);

    }

    public void pickBestSeller(){
        navigateToSite();
        clickOnBestSellers();
        pickAProduct();
    }

}
