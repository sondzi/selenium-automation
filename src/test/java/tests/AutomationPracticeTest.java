package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.AutomationPracticeCheckoutPage;
import pages.AutomationPracticeHomePage;
import pages.AutomationPracticeProductPage;

public class AutomationPracticeTest extends BaseTest {

    @Test
    public void orderProduct() throws InterruptedException {
        String email = "lidojom570@itwbuy.com";
        String password = "blabla333";
        String city = "Maria";

        AutomationPracticeHomePage homePage = new AutomationPracticeHomePage(driver);
        homePage.pickBestSeller();

        AutomationPracticeProductPage productPage = new AutomationPracticeProductPage(driver);
        productPage.orderProduct();

        AutomationPracticeCheckoutPage checkoutPage = new AutomationPracticeCheckoutPage(driver);
        checkoutPage.order(email, password);

        double unitPrice = Double.parseDouble(checkoutPage.unitPrice);
        double totalPrice = Double.parseDouble(checkoutPage.totalPrice);

        Assert.assertTrue(unitPrice*4 == totalPrice);
        Assert.assertTrue(checkoutPage.city.contains(city));

        Thread.sleep(3000);
    }
}
