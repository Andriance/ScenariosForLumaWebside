package SetUp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import static SetUp.SetUp.driver;
import static SetUp.SetUp.wait;

public class Interactions {
    public static String getUrl(){
        return driver.getCurrentUrl();
    }
    public static String navigateTo(String url){
        driver.get(url);
        return driver.getCurrentUrl();
    }
    public static void typeIn(String elementXpath, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))).sendKeys(text);
    }
    public static void clickIn(String elementXpath){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath))).click();
    }
    public static void clickOn(String elementXpath){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))).click();
    }
    public static void selectByVisibleText(String elementXpath, String visibleText){
        new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)))).selectByVisibleText(visibleText);
    }
    public static String getText(String elementXpath){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))).getText();
    }
    public static Boolean getText(String elementXpath, String textInElement){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(elementXpath), textInElement));
    }
    public static void signIn(String email, String password){
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[2]/a");
        typeIn("//*[@id=\"email\"]", email);
        typeIn("//*[@id=\"pass\"]", password);
        clickOn("//*[@id=\"send2\"]");
    }
    public static boolean isDisplayed(String elementXpath){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))).isDisplayed();
    }

    static Actions actions = new Actions(driver);
    public static void menu(String elementXpath1, String elementXpath2, String elementXpath3){
        WebElement target1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath1)));
        actions.moveToElement(target1).perform();
        WebElement target2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath2)));
        actions.moveToElement(target2).perform();
        clickOn(elementXpath3);
    }
    public static void menu(String elementXpath1, String elementXpath2){
        WebElement target1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath1)));
        actions.moveToElement(target1).perform();
        clickOn(elementXpath2);
    }

    static JavascriptExecutor js = (JavascriptExecutor) driver;
    public static void scrollUntilFindProduct(String elementXpath){
        WebElement Element = driver.findElement(By.xpath(elementXpath));
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }
}
