package org.example.tests;

import org.example.utilities.ConfigReader;
import org.example.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {


    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}