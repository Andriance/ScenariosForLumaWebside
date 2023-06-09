package Pages;

import SetUp.Interactions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static SetUp.SetUp.driver;
import static SetUp.SetUp.wait;

public class ProductListPage extends Interactions {

    public static boolean addProductToTheBasket() {
        navigateTo("https://magento.softwaretestingboard.com/");
        menu("//*[@id=\"ui-id-6\"]","//*[@id=\"ui-id-25\"]");
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]");
        clickOn("//*[@id=\"product-addtocart-button\"]");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return getText("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div","You added Push It Messenger Bag to your shopping cart.");
    }

    public static boolean sortItemsByPriceInAscendingOrder(){
        clickOn("//*[@id=\"ui-id-4\"]");
        clickOn("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a");
        selectByVisibleText("//*[@id=\"sorter\"]","Price");
        String priceForFirstProductWithDollarSign = getText("//*[@id=\"product-price-1556\"]/span");
        String priceForFirstProductWithoutDollarSign = priceForFirstProductWithDollarSign.substring(1, priceForFirstProductWithDollarSign.length());
        String priceForSecondProductWithDollarSign = getText("//*[@id=\"product-price-1652\"]/span");
        String priceForSecondProductWithoutDollarSign = priceForSecondProductWithDollarSign.substring(1, priceForSecondProductWithDollarSign.length());
        boolean flag = false;
        if(Double.valueOf(priceForFirstProductWithoutDollarSign) < Double.valueOf(priceForSecondProductWithoutDollarSign)){
            flag = true;
        }
        return flag;
    }

    public static boolean sortItemsByPriceInDescendingOrder(){
        clickOn("//*[@id=\"ui-id-4\"]");
        clickOn("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a");
        selectByVisibleText("//*[@id=\"sorter\"]","Price");
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[4]/a");
        String priceForFirstProductWithDollarSign = getText("//*[@id=\"product-price-1268\"]/span");
        String priceForFirstProductWithoutDollarSign = priceForFirstProductWithDollarSign.substring(1, priceForFirstProductWithDollarSign.length());
        String priceForSecondProductWithDollarSign = getText("//*[@id=\"product-price-1396\"]/span");
        String priceForSecondProductWithoutDollarSign = priceForSecondProductWithDollarSign.substring(1, priceForSecondProductWithDollarSign.length());
        boolean flag = false;
        if(Double.valueOf(priceForFirstProductWithoutDollarSign) > Double.valueOf(priceForSecondProductWithoutDollarSign)){
            flag = true;
        }
        return flag;
    }

    public static String addProductToWishList(){
        clickOn("//*[@id=\"ui-id-5\"]");
        clickOn("//*[@id=\"narrow-by-list2\"]/dd/ol/li[2]/a");
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]/div/a/span/span");
        clickOn("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[5]/div/a[1]");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return getText("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    }

    public static boolean numberOfProductsInWishList(){
        clickOn("//*[@id=\"ui-id-6\"]");
        clickOn("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a");
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]");
        clickOn("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[5]/div/a[1]");
        clickOn("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/a");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOn("//*[@id=\"maincontent\"]/div[2]/div/div[5]/div[2]/div/ol/li[2]");
        clickOn("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[5]/div/a[1]");
        return getText("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div/p/span", "3");
    }

    public static boolean presenceOfCorrectProductsInCategory(){
        clickOn("//*[@id=\"ui-id-4\"]");
        clickOn("//*[@id=\"narrow-by-list2\"]/dd/ol/li[2]/a");
        clickOn("//*[@id=\"narrow-by-list\"]/div[1]/div[1]");
        clickOn("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[2]/a");
        return getText("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/strong", "Short");
    }

    public static String badgeNumber(){
        navigateTo("https://magento.softwaretestingboard.com/");
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button");
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");
        clickOn("//*[@id=\"ui-id-6\"]");
        clickOn("//*[@id=\"narrow-by-list2\"]/dd/ol/li[3]/a");
        clickIn("//*[@id=\"mode-list\"]");
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div[1]/div[1]/form/button");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]/div/div/div[3]/div[1]/div[1]/form/button");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[3]/div/div/div[3]/div[1]/div[1]/form/button");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return getText("/html/body/div[1]/header/div[2]/div[1]/a/span[2]/span[1]");
    }

    public static String numberOfItemsInCart(){
        clickOn("/html/body/div[1]/header/div[2]/div[1]/a");
        return getText("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[1]/span[1]");
    }

    public static double totalSumInCart(){
        String priceOfFirstProductWithDollarSign = getText("//*[@id=\"mini-cart\"]/li[1]/div/div/div[1]/div[1]/span/span/span/span");
        String priceOfFirstProductWithoutDollarSign = priceOfFirstProductWithDollarSign.substring(1, priceOfFirstProductWithDollarSign.length());
        String priceOfSecondProductWithDollarSign = getText("//*[@id=\"mini-cart\"]/li[2]/div/div/div[1]/div[1]/span/span/span/span");
        String priceOfSecondProductWithoutDollarSign = priceOfSecondProductWithDollarSign.substring(1, priceOfFirstProductWithDollarSign.length());
        String priceOfThirdProductWithDollarSign = getText("//*[@id=\"mini-cart\"]/li[3]/div/div/div[1]/div[1]/span/span/span/span");
        String priceOfThirdProductWithoutDollarSign = priceOfThirdProductWithDollarSign.substring(1, priceOfFirstProductWithDollarSign.length());
        double totalPrice = Double.valueOf(priceOfFirstProductWithoutDollarSign) + Double.valueOf(priceOfSecondProductWithoutDollarSign) + Double.valueOf(priceOfThirdProductWithoutDollarSign);
        return totalPrice;
    }

    public static boolean emptyTheBasket(){
        clickIn("//*[@id=\"mini-cart\"]/li[1]/div/div/div[2]/div[2]/a");
        clickIn("/html/body/div[2]/aside[2]/div[2]/footer/button[2]");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickIn("//*[@id=\"mini-cart\"]/li[1]/div/div/div[2]/div[2]/a");
        clickIn("/html/body/div[2]/aside[2]/div[2]/footer/button[2]");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickIn("//*[@id=\"mini-cart\"]/li/div/div/div[2]/div[2]/a");
        clickIn("/html/body/div[2]/aside[2]/div[2]/footer/button[2]");
        return getText("//*[@id=\"minicart-content-wrapper\"]/div[2]/strong", "You have no items in your shopping cart.");
    }

    public static String viewProductName(){
        Interactions.scrollUntilFindProduct("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[6]");
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[6]");
        return getText("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[1]/h1/span");
    }

    public static String listingThePages(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/div[2]/ul/li[5]/a");
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        return getText("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/div[2]/ul/li[3]/strong");
    }

    public static String viewProductPrice (){
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/div[2]/ul/li[6]/a");
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]");
        return getText("//*[@id=\"product-price-366\"]/span");
    }

    public static String numberOfProductsInCategory(){
        driver.navigate().back();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/div[2]/ul/li[5]/a");
        return getText("//*[@id=\"toolbar-amount\"]");
    }

    static Actions actions = new Actions(driver);
    public static String addProductToCart(){
        clickOn("//*[@id=\"option-label-size-143-item-168\"]");
        clickOn("//*[@id=\"option-label-color-93-item-56\"]");
        WebElement target = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]")));
        actions.moveToElement(target).perform();
        clickOn("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[4]/div/div[1]/form/button");
        return getText("/html/body/div[1]/header/div[2]/div[1]/a/span[2]");
    }
}
