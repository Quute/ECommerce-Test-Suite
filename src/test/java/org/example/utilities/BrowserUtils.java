package org.example.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BrowserUtils {

    //Mouse u elementin üzerine götürme
    public static void hover(WebElement element){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(element).perform();
    }
    // Elementin tıklanabilir olmasını bekler ve tıklar (Wait sorunu çözücü)
    public static void clickWithWait(WebElement element , int timeOut){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    //Element görünür olana kadar bekler.
    public static void waitForVisibility(WebElement element , int timeOut){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    // Sayfayı aşağı kaydırır
    public static void scrollIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);" , element);
    }



}
