package appium.android.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HxDriver extends Config {

    private static HxDriver hxDriver;
    private static AppiumDriver<MobileElement> driver;

    public HxDriver() {
        driver = startServerAndDriver();
    }

    public static AppiumDriver<MobileElement> getDriver() {
        if (hxDriver == null) {
            hxDriver = new HxDriver();
        }
        return driver;
    }
}
