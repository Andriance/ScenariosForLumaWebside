package Tests;

import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.ProductListPage;
import SetUp.SetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddingProductsAndProceedToCheckoutScenarioTests {
    @BeforeClass
    public void setUp() {
        SetUp.setup();
    }

    @Test(priority = 1)
    public void verifyIfYouAreOnTheCheckoutPage() {
        Assert.assertEquals(CheckoutPage.addingTwoProductsInCartAndProceedToCheckOut(), "https://magento.softwaretestingboard.com/checkout/#shipping");
    }

    @Test(priority = 2)
    public void verifyMessageForSuccessfullyAddedProductToTheCart() {
        Assert.assertTrue(ProductListPage.addProductToTheBasket());
    }

    @Test(priority = 3)
    public void verifyIfProductsAreSortByPriceInAscendingOrder() {
        Assert.assertTrue(ProductListPage.sortItemsByPriceInAscendingOrder());
    }

    @Test(priority = 4)
    public void verifyIfProductsAreSortByPriceInDescendingOrder() {
        Assert.assertTrue(ProductListPage.sortItemsByPriceInDescendingOrder());
    }

    @Test(priority = 5)
    public void verifyMessageForSuccessfullyAddedProductToTheWishlist() {
        Assert.assertEquals(ProductListPage.addProductToWishList(), "Arcadio Gym Short has been added to your Wish List. Click here to continue shopping.");
    }

    @Test(priority = 6)
    public void verifyTheNumberOfProductsInWishlist() {
        Assert.assertTrue(ProductListPage.numberOfProductsInWishList());
    }

    @Test(priority = 7)
    public void verifyIfInCategoryWomenBottomsShortsHaveCorrectProducts() {
        Assert.assertTrue(ProductListPage.presenceOfCorrectProductsInCategory());
    }

    @Test(priority = 8)
    public void verifyTheBadgeNumberOfTheBasket() {
        Assert.assertEquals(ProductListPage.badgeNumber(), "3");
    }

    @Test(priority = 9)
    public void verifyTheNumberOfProductsInCart() {
        Assert.assertEquals(ProductListPage.numberOfItemsInCart(), "3");
    }

    @Test(priority = 10)
    public void verifyTheTotalPriceInCart() {
        Assert.assertEquals(ProductListPage.totalSumInCart(), 195.00);
    }

    @Test(priority = 11)
    public void verifyTheMessageForEmptyBasket() {
        Assert.assertTrue(ProductListPage.emptyTheBasket());
    }

    @Test(priority = 12)
    public void verifyIfSearchBoxGivesCorrectResults() {
        Assert.assertEquals(HomePage.searchingForValidProduct(), "Search results for: 'jacket'");
    }

    @Test(priority = 13)
    public void verifyMessageForInvalidSearch() {
        Assert.assertEquals(HomePage.searchingForInvalidProduct(), "Your search returned no results.");
    }

    @Test(priority = 14)
    public void verifyTheSpellingOfTitleShippingAddress() {
        Assert.assertEquals(CheckoutPage.presentsOfTitle(), "Shipping Address");
    }

    @AfterClass
    public void end() {
        SetUp.end();
    }
}
