package appium.android.automation.utils;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class HxInteractions {

    public static void hexClick(By by) {
        hexVisibleComponentAssert(by);
        HxDriver.getDriver().findElement(by).click();
    }

    public static void hexWrite(By by, CharSequence charSequence) {
        hexVisibleComponentAssert(by);
        HxDriver.getDriver().findElement(by).sendKeys(charSequence);
    }

    public static void hexVisibleComponentAssert(By by) {
        HxDriver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        assertTrue(HxDriver.getDriver().findElement(by).isEnabled());
    }

    public static void hexCompareTextInListOfElements(By by, String expectedString) {
        hexVisibleComponentAssert(by);
        List<MobileElement> elements = HxDriver.getDriver().findElements(by);
        assertTrue("The string '" + expectedString + "' wasn't found in the list of elements.",
                elements.stream().anyMatch(element -> expectedString.equals(element.getText().trim())));
    }

    public static void hexClickAndHold(By by) {
        hexVisibleComponentAssert(by);
        Actions actions = new Actions(HxDriver.getDriver());
        actions.clickAndHold(HxDriver.getDriver().findElement(by)).perform();
    }
}
