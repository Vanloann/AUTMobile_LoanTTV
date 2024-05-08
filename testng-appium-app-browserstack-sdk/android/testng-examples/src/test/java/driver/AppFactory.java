package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {
    private static AppiumDriver<MobileElement> driver;

    public static void android_launchApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidPixel3");
//        capabilities.setCapability(MobileCapabilityType.APP, "D:\\AUT_LoanTTV\\testng-appium-app-browserstack-sdk" +
//                "\\android\\testng-examples\\src\\app\\Android.SauceLabs.Mobile.Sample.app.2.7.1 (1).apk");
//        // You can also set appPackage and appActivity for Android if you want to test on a pre-installed application
//        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
//        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");

        // Create AppiumDriver instance and connect to the Appium server.
        // It will launch the app in Android Emulator using the configurations specified in Desired Capabilities.
        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
        AppDriver.setDriver(driver);
        System.out.println("AndroidDriver is set");
    }
}
