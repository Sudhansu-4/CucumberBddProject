package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserDriver {

    public static WebDriver CHROME() {
        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        return new ChromeDriver(options);
    }

    public static WebDriver FIREFOX() {
        System.setProperty("webdriver.gecko.driver", "D:\\Training\\geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications"); // You can add Firefox-specific options here
        return new FirefoxDriver(options);
    }
    public static void waitForElementClickable(WebDriver driver, long timeoutInSeconds, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
