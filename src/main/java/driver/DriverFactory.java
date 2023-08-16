package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;



        switch (getBrowserType()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                //waits until the load event fire is returned
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecho.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/geckodriver");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                //waits until the load event fire is returned
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static String getBrowserType() {
        String browserType = null;

//        if logic fails it will get caught and output message to terminal window
        try {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
            properties.load(file);
            browserType = properties.getProperty("browser").toLowerCase().trim();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return browserType;
    }

    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();

    }

}
