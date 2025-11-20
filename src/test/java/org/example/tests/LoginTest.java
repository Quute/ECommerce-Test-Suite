package org.example.tests;

import org.example.pages.LoginPage;
import org.example.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

// TestBase'i (extends), böylece tarayıcı açma/kapama işlerini o hallediyor.
public class LoginTest extends TestBase {

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage();

        loginPage.loginOl(ConfigReader.getProperty("email"), ConfigReader.getProperty("password"));

        Assert.assertTrue(loginPage.loggedInAsText.isDisplayed(), "Login işlemi başarısız oldu!");

        System.out.println("Test Başarıyla Geçti! Kullanıcı sisteme girdi.");
    }



        @Test
        public void loginNegativeTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginOl("hatalimail@gmail.com","hatalisifre");

        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Hata mesajı görüntülenmedi! Sistem yanlış girişe tepki vermiyor.");

        // b) Mesajın içeriği doğru mu?
        String actualMessage = loginPage.errorMessage.getText();
        String expectedMessage = "Your email or password is incorrect!";
        Assert.assertEquals(actualMessage, expectedMessage, "Hata mesajı metni yanlış!");
    }


}