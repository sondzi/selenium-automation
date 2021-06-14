package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class RestaurantsPage extends BaseHelper {

    public String allRestaurantsNum;
    public String italianRestaurantsNum;
    public int numberOfItalianRestaurantsInList;

    @FindBy(className = "shops-listing-counter")
    WebElement numberOfRestaurants;

    @FindBy(id = "italijanska-hrana")
    WebElement italianFoodCheckbox;

    @FindBy(className = "shops-listings-shops-list")
    WebElement italianRestaurants;

    WebDriver driver;
    public RestaurantsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void printNumberOfAllRestaurants(){
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("shops-listing-counter"), ""));
        allRestaurantsNum = numberOfRestaurants.getText();
        System.out.println("Number of all restaurants: " + allRestaurantsNum);

    }

    private void clickOnItalianFoodCheckbox(){
        js.executeScript("arguments[0].click()", italianFoodCheckbox);
    }

    private void printNumberOfItalianRestaurants(){
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("shops-listing-counter"), numberOfRestaurants.getText()));
        italianRestaurantsNum = numberOfRestaurants.getText();
        System.out.println("Number of Italian restaurants: " + italianRestaurantsNum);

        List<WebElement> listItalianRestaurants = italianRestaurants.findElements(By.className("shops-listings-shops-list-item"));
        numberOfItalianRestaurantsInList = listItalianRestaurants.size();
        System.out.println("Number of restaurants in list: " + numberOfItalianRestaurantsInList);
    }

    public void numberOfItalianRestaurants(){
        printNumberOfAllRestaurants();
        clickOnItalianFoodCheckbox();
        printNumberOfItalianRestaurants();
    }

}
