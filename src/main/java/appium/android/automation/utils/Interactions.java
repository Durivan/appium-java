package appium.android.automation.utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static appium.android.automation.utils.BaseTest.getDriver;
import static org.testng.AssertJUnit.assertTrue;

public class Interactions {

    public static void clickOn(By by) {
        isVisibleComponentAssert(by);
        getDriver().findElement(by).click();
    }

    public static void writeOn(By by, CharSequence charSequence) {
        isVisibleComponentAssert(by);
        getDriver().findElement(by).sendKeys(charSequence);
    }

    public static void isVisibleComponentAssert(By by) {
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        assertTrue(getDriver().findElement(by).isEnabled());
    }

    public static void compareTextInListOfElementsAssert(By by, String expectedString) {
        isVisibleComponentAssert(by);
        List<MobileElement> elements = getDriver().findElements(by);
        assertTrue("The string '" + expectedString + "' wasn't found in the list of elements.",
                elements.stream().anyMatch(element -> expectedString.equals(element.getText().trim())));
    }

    public static void clickAndHoldOn(By by) {
        isVisibleComponentAssert(by);
        Actions actions = new Actions(getDriver());
        actions.clickAndHold(getDriver().findElement(by)).perform();
    }

    public static void reciveSMSAndroid(String fromNumber, String message) {
        ((AndroidDriver<?>) getDriver()).sendSMS(fromNumber, message);
    }
}
