package tests;

import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import ultilities.Utils;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {
    protected AppiumDriver<MobileElement> driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        driver = getDriver();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test(priority = 1)
    public void loginFail() {
        loginPage.login("standard_user", "123");
        loginPage.verifyLoginFail();
        Utils.scroll(Utils.ScrollDirection.DOWN, 0.5, driver);
    }

    @Test(priority = 2)
    public void loginPass() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.verifyTitleDisplayed();
        productsPage.clickSideBar();
        Utils.scroll(Utils.ScrollDirection.RIGHT, 0.6, driver);
    }
}
