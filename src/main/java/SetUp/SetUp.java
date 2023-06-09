package SetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetUp {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

        driver.get("https://magento.softwaretestingboard.com/");
    }

    public static void end() {
        driver.quit();
    }
}
