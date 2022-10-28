package appium.android.automation.utils;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static appium.android.automation.utils.BaseTest.getDriver;
import static org.testng.AssertJUnit.assertTrue;

public class HxInteractions {

    public static void hexClick(By by) {
        hexVisibleComponentAssert(by);
        getDriver().findElement(by).click();
    }

    public static void hexWrite(By by, CharSequence charSequence) {
        hexVisibleComponentAssert(by);
        getDriver().findElement(by).sendKeys(charSequence);
    }

    public static void hexVisibleComponentAssert(By by) {
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        assertTrue(getDriver().findElement(by).isEnabled());
    }

    public static void hexCompareTextInListOfElements(By by, String expectedString) {
        hexVisibleComponentAssert(by);
        List<MobileElement> elements = getDriver().findElements(by);
        assertTrue("The string '" + expectedString + "' wasn't found in the list of elements.",
                elements.stream().anyMatch(element -> expectedString.equals(element.getText().trim())));
    }

    public static void hexClickAndHold(By by) {
        hexVisibleComponentAssert(by);
        Actions actions = new Actions(getDriver());
        actions.clickAndHold(getDriver().findElement(by)).perform();
    }
}
