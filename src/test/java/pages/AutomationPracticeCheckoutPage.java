package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AutomationPracticeCheckoutPage extends BaseHelper {

    @FindBy(id = "product_price_2_12_0")
    WebElement shirtPrice;

    @FindBy(id = "total_product_price_2_12_0")
    WebElement totalShirtPrice;

    @FindBy(className = "cart_quantity_input")
    WebElement unitQuantity;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span")
    WebElement proceedToCheckoutButton;

    // login page

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "passwd")
    WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    //address page

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/form/p/button")
    WebElement proceedButton;

    @FindBy(id = "address_invoice")
    WebElement billingInfo;

    @FindBy(id = "address_delivery")
    WebElement addressInfo;

    @FindBy(className = "address_city")
    WebElement address;

    //tos page
    @FindBy(id = "cgv")
    WebElement checkbox;

    //payment page
    @FindBy(className = "bankwire")
    WebElement bankWire;

    //confirm order page
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/form/p/button")
    WebElement confirmOrderButton;

    //variables
    public String unitPrice;
    public String totalPrice;
    public String city;
    public List<WebElement> billingInformation;
    public List<WebElement> addressInformation;
    public List<String> sameInfo;

    WebDriver driver;
    public AutomationPracticeCheckoutPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void increaseQuantity(){

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("order-detail-content")));
        unitQuantity.click();
        unitQuantity.sendKeys("4");

        unitPrice = shirtPrice.getText().replace("$", "").trim();
        System.out.println("Shirt price: " + shirtPrice.getText());

        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("total_product_price_2_12_0"), totalShirtPrice.getText()));
        totalPrice = totalShirtPrice.getText().replace("$", "").trim();
        System.out.println("Total price: " + totalShirtPrice.getText());


    }

    private void proceedToCheckout(){
        proceedToCheckoutButton.click();
    }

    private void login(String email, String password){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("login_form")));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);

        signInButton.click();
    }

    private void checkCredentialsProceed(){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("address_invoice")));

//        addressInformation = addressInfo.findElements(By.tagName("li"));
//        billingInformation = billingInfo.findElements(By.tagName("li"));
//
//        for(int i = 1; i < addressInformation.size()-1; i++){
//                if(addressInformation.get(i).getText() == billingInformation.get(i).getText()){
//                    sameInfo.add(addressInformation.get(i).getText());
//                }
//        }
//
//        System.out.println("Same info: " + sameInfo);
        city = address.getText();
        proceedButton.click();

    }

    private void checkTOS(){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("order_carrier_content")));
        checkbox.click();
        WebElement process = driver.findElement(By.className("standard-checkout"));
        process.click();
    }

    private void checkPayByBankWire(){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("cart_summary")));
        bankWire.click();
    }

    private void confirmOrder(){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("cheque-box")));
        confirmOrderButton.click();
    }

    public void order(String email, String password){
        increaseQuantity();
        proceedToCheckout();
        login(email, password);
        checkCredentialsProceed();
        checkTOS();
        checkPayByBankWire();
        confirmOrder();
    }

}
