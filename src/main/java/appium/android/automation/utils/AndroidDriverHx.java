package appium.android.automation.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
//TODO new implementation of android driver
public class AndroidDriverHx {

    private static AndroidDriverHx androidDriverHx;
    private static AndroidDriver androidDriver;

    public AndroidDriverHx(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "11");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("deviceName", "Android SDK built for x86");
        desiredCapabilities.setCapability("appPackage", "com.android.contacts");
        desiredCapabilities.setCapability("appActivity", ".activities.PeopleActivity");
        try {
            androidDriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static AndroidDriver getInstance(){
        if (androidDriverHx == null){
            androidDriverHx = new AndroidDriverHx();
        }
        return androidDriver;
    }
}
