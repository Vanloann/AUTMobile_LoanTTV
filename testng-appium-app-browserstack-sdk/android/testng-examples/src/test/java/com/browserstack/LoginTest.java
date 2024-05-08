package com.browserstack;

import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.Utils;

import java.net.MalformedURLException;

public class LoginTest extends BaseTest {
    protected AppiumDriver<MobileElement> driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        getDriver();
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
    }

    @Test(priority = 1)
    public void loginFail() {
        loginPage.login("standard_user", "123");
        loginPage.verifyLoginFail();
//        Utils.scroll(Utils.ScrollDirection.DOWN, 0.5);
    }

    @Test(priority = 2)
    public void loginPass() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.verifyTitleDisplayed();
        productsPage.clickSideBar();
//        Utils.scroll(Utils.ScrollDirection.RIGHT, 0.6);
    }
}
