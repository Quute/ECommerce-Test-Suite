package org.example.utilities;
//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class Driver {
    // Static: Çünkü her obje oluşturulduğunda değil, proje boyunca tek ve ortak olmalı
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {


            String browser = ConfigReader.getProperty("browser"); // "chrome" gelecek

            switch (browser.toLowerCase()) {
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                // İlerde Edge, Safari eklenebilir
                default:
                    // Eğer yanlış bir şey yazılırsa default olarak Chrome açsın
                    //WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


    }


