package Pages;

import SetUp.Interactions;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static SetUp.SetUp.wait;

public class CheckoutPage extends Interactions {
    static Faker faker = new Faker();
    protected static String address = faker.address().streetAddress();
    protected static String city = faker.address().city();
    protected static String zipCode = faker.address().zipCode();
    protected static String phoneNumber = faker.phoneNumber().phoneNumber();

    public static String addingTwoProductsInCartAndProceedToCheckOut() {
        signIn("ane_t_2005@hotmail.com", "AneChi2412");
        clickOn("//*[@id=\"ui-id-8\"]");
        clickOn("//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[1]/li[1]");
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img");
        clickOn("//*[@id=\"option-label-size-143-item-166\"]");
        clickOn("//*[@id=\"option-label-color-93-item-57\"]");
        clickOn("//*[@id=\"product-addtocart-button\"]");
        clickOn("/html/body/div[1]/div[2]/ul/li[4]/a");
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]");
        clickOn("//*[@id=\"option-label-size-143-item-166\"]");
        clickOn("//*[@id=\"option-label-color-93-item-50\"]");
        clickOn("//*[@id=\"product-addtocart-button\"]");
        clickOn("/html/body/div[1]/header/div[2]/div[1]/a");
        clickIn("//*[@id=\"top-cart-btn-checkout\"]");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return getUrl();
    }

    public static String presentsOfTitle(){
        signIn("andriana@hotmail.com", "AneChi2412");
        ProductListPage.addProductToTheBasket();
        clickOn("/html/body/div[1]/header/div[2]/div[1]/a");
        clickOn("//*[@id=\"top-cart-btn-checkout\"]");
        return getText("//*[@id=\"shipping\"]/div[1]");
    }

    public static String proceedToCheckOut(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOn("/html/body/div[1]/header/div[2]/div[1]/a");
        clickIn("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a");
        clickOn("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button");
        return getUrl();
    }

    public static String proceedToCheckOutWhenYouAreLoggedIn(){
        clickOn("/html/body/div[1]/header/div[2]/div[1]/a");
        clickIn("//*[@id=\"top-cart-btn-checkout\"]");
        return getUrl();
    }

    public static String fillingTheCheckOutFormWhenYouAreNotLoggedIn(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        typeIn("//*[@id=\"customer-email\"]" , "andriana@hotmail.com");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        typeIn("//*[@id=\"customer-password\"]", "AneChi2412");
        clickOn("//*[@id=\"customer-email-fieldset\"]/fieldset/div[2]/div[1]/button");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String button = getText("//*[@id=\"checkout-step-shipping\"]/div[2]/button/span");
        if (button.equals("New Address")){
            clickOn("//*[@id=\"shipping-method-buttons-container\"]/div/button");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("street[0]"))).sendKeys(address);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name=city]"))).sendKeys(city);
            new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name=region_id]")))).selectByVisibleText("Arizona");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name=postcode]"))).sendKeys(zipCode);
            new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name=country_id]")))).selectByVisibleText("Angola");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name=telephone]"))).sendKeys(phoneNumber);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clickOn("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr/td[1]/input");
            clickOn("//*[@id=\"shipping-method-buttons-container\"]/div/button");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return getUrl();
    }


    public static boolean buyingTheProduct(){
        clickOn("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button");
        return getText("//*[@id=\"maincontent\"]/div[1]/h1/span", "Thank you for your purchase!");
    }

    public static boolean buyingTheProductWhenYouAreLoggedIn(){
        clickIn("//*[@id=\"shipping-method-buttons-container\"]/div/button");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickIn("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button");
        return getText("//*[@id=\"maincontent\"]/div[1]/h1/span", "Thank you for your purchase!");
    }

    public static String checkOut(){
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button");
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[3]");
        return getText("//*[@id=\"maincontent\"]/div[1]/h1/span");
    }
}
