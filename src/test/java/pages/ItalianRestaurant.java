package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItalianRestaurant extends BaseHelper {

    @FindBy(className = "shop-listing-content")
    WebElement allItaRestaurants;

    @FindBy(id = "menu-list-content")
    WebElement allMeals;

    @FindBy(xpath = "/html/body/div[2]/main/section[2]/div/div/div/div/div/div[1]/div[3]/div[2]/div[1]/span")
    WebElement minimumDelivery;

    @FindBy(xpath = "/html/body/div[2]/main/section[2]/div/div/div/div/div/div[1]/div[3]/div[2]/div[3]/span")
    WebElement deliveryCost;

    @FindBy(className = "cc-modal-header__name")
    WebElement mealName;

    @FindBy(className = "cc-modal-header__total")
    WebElement mealPrice;

    @FindBy(className = "cc-controls-quantity-input")
    WebElement mealQuantity;

    @FindBy(className = "cc-controls-quantity-increase")
    WebElement qtyIncrease;

    @FindBy(className = "cc-modal-footer-controls-submit__button")
    WebElement dodajteUKorpuButton;

    @FindBy(className = "cookie-consent-accept-all")
    WebElement cookie;

    @FindBy(className = "cc-modal")
    WebElement productPopup;

    @FindBy(className = "cart-total-price")
    WebElement cartTotalPrice;

    @FindBy(className = "cart-product-list")
    WebElement cartAllItems;

    //variables
    private List<WebElement> listOfItaRestaurants;
    private List<WebElement> allProducts;
    public List<Meal> addedMeals;
    private List<WebElement> cartItems;

    public String minimumDeliveryText;
    public String deliveryCostText;

    WebDriver driver;
    public ItalianRestaurant(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToRestaurant(){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("shop-listing-content")));
        listOfItaRestaurants = allItaRestaurants.findElements(By.className("shops-listings-shops-list-item"));

        Random rnd = new Random();
        int index = rnd.nextInt(listOfItaRestaurants.size());
        WebElement itaRestaurant = listOfItaRestaurants.get(index);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("cookie-consent-accept-all")));
        cookie.click();

        js.executeScript("arguments[0].scrollIntoView();", itaRestaurant);
        wdWait.until(ExpectedConditions.visibilityOf(itaRestaurant));
        itaRestaurant.click();
    }

    private void setUp(){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu-list-content")));
        allProducts = allMeals.findElements(By.tagName("li"));
//        System.out.println("Size of list with all meals: " + allProducts.size());
        minimumDeliveryText = minimumDelivery.getText();
        System.out.println("Minimum delivery: " + minimumDeliveryText);
        deliveryCostText = deliveryCost.getText();
        System.out.println("Delivery cost: " + deliveryCostText);

        addedMeals = new ArrayList<>();
    }

    private void selectProduct(boolean shouldIAdd){
        Meal addedMeal = new Meal();
        Random rnd = new Random();
        int index = rnd.nextInt(allProducts.size());
        WebElement randomProduct = allProducts.get(index);

        js.executeScript("arguments[0].scrollIntoView();", randomProduct);
        wdWait.until(ExpectedConditions.visibilityOf(randomProduct));
//        System.out.println("Random product index: " + index);
//        System.out.println("Random product name and details: " + randomProduct.getText());
        js.executeScript("arguments[0].click();", randomProduct);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("cc-modal")));
        addedMeal.name = mealName.getText();
        addedMeal.price = mealPrice.getText();
        addedMeal.quantity = mealQuantity.getText();
        System.out.println("Meal name: " + addedMeal.name);
        System.out.println("Meal price: " + addedMeal.price);
        System.out.println("Meal quantity: " + addedMeal.quantity);

        addedMeals.add(addedMeal);
        //how to print object :(

        wdWait.until(ExpectedConditions.visibilityOf(productPopup));
        if(shouldIAdd == true) {
//            qtyIncrease.click();
            js.executeScript("arguments[0].click();", qtyIncrease);
            wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("cc-controls-quantity-increase"), "1"));
        }
        dodajteUKorpuButton.click();

//        Random rand = new Random();
//        int random2x = rand.nextInt(index);


            cartItems = cartAllItems.findElements(By.className("cart-product-list-item"));
        for(int i = 0; i < cartItems.size(); i++){
            System.out.println("Item in basket: " + cartItems.get(i).getText());
        }
    }


    private void chooseRandomMeal(){
        Random rand = new Random();

        int brojJela = rand.nextInt(4) + 2;

        int luckyIndex = rand.nextInt(brojJela);

        System.out.println("Random broj jela: " + brojJela);
        System.out.println("LuckyIndex: " + luckyIndex);

        for(int i = 0; i < brojJela; i++) {
            boolean shouldAddTwice = i == luckyIndex;

            selectProduct(shouldAddTwice);
        }
    }

    public void chooseOrder(){
        navigateToRestaurant();
        setUp();
        chooseRandomMeal();
    }

}
