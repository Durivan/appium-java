package appium.android.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private AppiumDriverLocalService service;
    private static AppiumDriver<MobileElement> driver;

    @BeforeClass
    public AppiumDriver<MobileElement> startServerAndDriver() {
        this.service = new AppiumServiceBuilder()
                .usingAnyFreePort().build();
        service.start();

        if (service == null || !service.isRunning()) {
            throw new RuntimeException("An appium server node is not started!");
        }

        String platform = System.getenv("platform");
        if (platform == null) {
            platform = "ANDROID";
        }

        switch (platform.toUpperCase()) {
            case "IOS":
                driver = iosDriver();
                break;
            default:
                driver = androidDriver();
                break;
        }
        return driver;
    }

    @AfterClass(alwaysRun = true)
    public void closeServerAndDriver() {
        if (driver != null) {
            driver.quit();
        }
        if (this.service != null) {
            this.service.stop();
        }
    }

    private AppiumDriver<MobileElement> androidDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "11");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("deviceName", "Android SDK built for x86");
        desiredCapabilities.setCapability("appPackage", "com.android.contacts");
        desiredCapabilities.setCapability("appActivity", ".activities.PeopleActivity");
        return new AndroidDriver<>(this.service.getUrl(), desiredCapabilities);
    }

    private AppiumDriver<MobileElement> iosDriver() {
        System.out.println("IOS DRIVER");
        return null;
        //TODO capabilities for iOS
    }

    public static AppiumDriver<MobileElement> getDriver(){
        return driver;
    }
}
