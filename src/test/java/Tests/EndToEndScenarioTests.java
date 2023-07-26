package Tests;

import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.ProductListPage;
import SetUp.SetUp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import SetUp.Interactions;

import static SetUp.SetUp.driver;

public class EndToEndScenarioTests{
    @BeforeClass
    public void setUp(){
        SetUp.setup();
    }

    @Test(priority = 1)
    public void verifyBuyingProductWithSigningInAtTheCheckOutPage(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(ProductListPage.addProductToTheBasket());
        softAssert.assertEquals(CheckoutPage.proceedToCheckOut(),"https://magento.softwaretestingboard.com/checkout/#shipping");
        softAssert.assertEquals(CheckoutPage.fillingTheCheckOutFormWhenYouAreNotLoggedIn(), "https://magento.softwaretestingboard.com/checkout/#payment");
        softAssert.assertTrue(CheckoutPage.buyingTheProduct());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifyBuyingProductsWhenYouAreSignedIn(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(ProductListPage.addProductToTheBasket());
        softAssert.assertEquals(CheckoutPage.proceedToCheckOutWhenYouAreLoggedIn(), "https://magento.softwaretestingboard.com/checkout/#shipping");
        softAssert.assertTrue(CheckoutPage.buyingTheProductWhenYouAreLoggedIn());
        softAssert.assertEquals(CheckoutPage.checkOut(),"You are signed out");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void verifyAddingProductInWishListAndLogOut(){
        Interactions.signIn("ane_t_2005@hotmail.com","AneChi2412");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(ProductListPage.addProductToWishList(), "Arcadio Gym Short has been added to your Wish List. Click here to continue shopping.");
        softAssert.assertTrue(ProductListPage.numberOfProductsInWishList());
        softAssert.assertEquals(CheckoutPage.checkOut(),"You are signed out");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void verifyViewingTheProductsInMenTopsCategory(){
        Interactions.menu("//*[@id=\"ui-id-5\"]","//*[@id=\"ui-id-17\"]");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(ProductListPage.viewProductName(),"Argus All-Weather Tank");
        driver.navigate().back();
        softAssert.assertEquals(ProductListPage.listingThePages(),"2");
        softAssert.assertEquals(ProductListPage.viewProductPrice(), "$66.00");
        softAssert.assertEquals(ProductListPage.numberOfProductsInCategory(), "Items 37-48 of 48");
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void verifyLookingForMansJacketAndBuyIt(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(HomePage.searchingForMenTShirts(),"Search results for: 't-shirts for men'");
        softAssert.assertEquals(HomePage.sortByStyle(), "5");
        softAssert.assertEquals(HomePage.sortByMaterial(), "MaterialLumaTech™");
        softAssert.assertEquals(ProductListPage.addProductToCart(), "1");
        softAssert.assertEquals(CheckoutPage.proceedToCheckOut(),"https://magento.softwaretestingboard.com/checkout/#shipping");
        softAssert.assertEquals(CheckoutPage.fillingTheCheckOutFormWhenYouAreNotLoggedIn(), "https://magento.softwaretestingboard.com/checkout/#payment");
        softAssert.assertTrue(CheckoutPage.buyingTheProduct());
        softAssert.assertAll();
    }

    @AfterClass
    public void end() {
        SetUp.end();
    }
}
