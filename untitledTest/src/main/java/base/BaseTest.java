package base;

import driver.AppFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    private static AppiumDriver<MobileElement> driver;

//    public AppiumDriver getDriver(){
//        try {
//            setUp();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return driver;
//    }
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


//    public void setUp() throws Exception {
//        // Set up desired capabilities and pass the Android app-activity and app-package to Appium
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidPixel3");
//        capabilities.setCapability(MobileCapabilityType.APP, "D:\\AUT_LoanTTV\\MobileAUT\\AUTMobile_LoanTTV" +
//                "\\untitledTest\\src\\app\\Android.SauceLabs.Mobile.Sample.app.2.7.1 (1).apk");
//        // You can also set appPackage and appActivity for Android if you want to test on a pre-installed application
//        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
//        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
//
//        // Create AppiumDriver instance and connect to the Appium server.
//        // It will launch the app in Android Emulator using the configurations specified in Desired Capabilities.
//        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
//    }

    @AfterClass
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
