package base;

import driver.AppDriver;
import driver.AppFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.AfterClass;

import java.net.MalformedURLException;

public class BaseTest {
    public void getDriver(){
      launchApp();
    }

    public void launchApp() {
        System.out.println("Before class");
        try {
            AppFactory.android_launchApp();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @AfterClass
    public void tearDown() throws Exception {
        if (AppDriver.getCurrentDriver() != null) {
            AppDriver.getCurrentDriver().quit();
        }
    }
}
