package tests;


import org.junit.Assert;
import org.junit.Test;
import pages.DonesiHomePage;
import pages.ItalianRestaurant;
import pages.RestaurantsPage;

public class DonesiRestaurantTest extends BaseTest {

    @Test
    public void findAndCountRestaurants() throws InterruptedException {
        String address = "Kneza Mihaila 7";

        DonesiHomePage homePage = new DonesiHomePage(driver);
        homePage.enterAddress(address);

        RestaurantsPage restaurantsPage = new RestaurantsPage(driver);
        restaurantsPage.numberOfItalianRestaurants();

        ItalianRestaurant italianRestaurant = new ItalianRestaurant(driver);
        italianRestaurant.chooseOrder();

        int allRestaurantsNumber = Integer.parseInt(restaurantsPage.allRestaurantsNum);
        int italianRestaurantsNumber = Integer.parseInt(restaurantsPage.italianRestaurantsNum);
        int italianRestaurantsList = restaurantsPage.numberOfItalianRestaurantsInList;

//        Assert.assertTrue(allRestaurantsNumber > italianRestaurantsNumber);
//        Assert.assertEquals(italianRestaurantsList, italianRestaurantsNumber);


        Thread.sleep(3000);
    }

    @Test
    public void orderFromItaRestaurant() throws InterruptedException {
        ItalianRestaurant italianRestaurant = new ItalianRestaurant(driver);
        italianRestaurant.chooseOrder();

        Thread.sleep(3000);
    }
}
