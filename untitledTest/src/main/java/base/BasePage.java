package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;
    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 2L);
    }
    protected void waitForElement(MobileElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(MobileElement element){
        waitForElement(element);
        element.click();
    }

    protected void type(MobileElement element, String text){
        waitForElement(element);
        element.sendKeys(text);
    }

    protected String getText(MobileElement element) {
        return element.getText();
    }

    protected void verify(MobileElement element, String text){
        waitForElement(element);
        System.out.println(getText(element));
        Assert.assertEquals(element.getText(), text);
    }
}
