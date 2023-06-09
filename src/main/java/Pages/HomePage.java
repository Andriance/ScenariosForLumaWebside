package Pages;

import SetUp.Interactions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static SetUp.SetUp.driver;

public class HomePage extends Interactions {
    public static String searchingForValidProduct() {
        typeIn("//*[@id=\"search\"]", "jacket");
        clickOn("//*[@id=\"search_mini_form\"]/div[2]/button");
        return getText("//*[@id=\"maincontent\"]/div[1]/h1/span");
    }

    public static String searchingForInvalidProduct() {
        typeIn("//*[@id=\"search\"]", "hat");
        clickOn("//*[@id=\"search_mini_form\"]/div[2]/button");
        return getText("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]");
    }

    public static String searchingForMenTShirts() {
        typeIn("//*[@id=\"search\"]", "t-shirts");
        List<WebElement> options = driver.findElements(By.cssSelector("li[role=\"option\"] span[class=\"qs-option-name\"]"));
        for (WebElement option :options) {
            if(option.getText().equalsIgnoreCase(" t-shirts for men")){
                option.click();
                break;
            }
        }
        return getText("//*[@id=\"maincontent\"]/div[1]/h1/span");
    }

    public static String sortByStyle(){
        menu("//*[@id=\"ui-id-5\"]", "//*[@id=\"ui-id-17\"]/span[1]", "//*[@id=\"ui-id-19\"]");
        clickOn("//*[@id=\"narrow-by-list\"]/div[1]/div[1]");
        clickOn("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[6]/a");
        return getText("//*[@id=\"toolbar-amount\"]/span");
    }

    public static String sortByMaterial(){
        clickOn("//*[@id=\"narrow-by-list\"]/div[4]/div[1]");
        clickOn("//*[@id=\"narrow-by-list\"]/div[4]/div[2]/ol/li[3]/a");
        return getText("//*[@id=\"layered-filter-block\"]/div[2]/div[1]/ol/li[2]");
    }

}
