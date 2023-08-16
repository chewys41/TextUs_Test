package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Vars;

import java.time.Duration;

public class Base_PO {
    //first thing we need is a constructor for the class..
    public Base_PO() {
        //this logic initializes all page objects
        PageFactory.initElements(getDriver(), this);
    }

    //create method which gets driver object
    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigateTo_URL(String url) {
        getDriver().get(url);
    }

    //custom method generating random number
    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    //    Generate random String
    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public void sendKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }



}
