package appium.android.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertTrue;

public class HxInteractions {

    public static void hexClick(By by){
        hexVisibleComponentAssert(by);
        AndroidDriverHx.getInstance().findElement(by).click();
    }

    public static void hexWrite(By by, CharSequence charSequence){
        hexVisibleComponentAssert(by);
        AndroidDriverHx.getInstance().findElement(by).sendKeys(charSequence);
    }

    public static void hexVisibleComponentAssert(By by){
        AndroidDriverHx.getInstance().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        assertTrue(AndroidDriverHx.getInstance().findElement(by).isEnabled());
    }

    //TODO new method
    public static void hexCompareTextInListOfElements(By by, String expectedString){
        hexVisibleComponentAssert(by);
        List<WebElement> elements = AndroidDriverHx.getInstance().findElements(by);
        assertTrue("The string '" + expectedString + "' wasn't found in the list of elements.",
                elements.stream().anyMatch(element -> expectedString.equals(element.getText().trim())));
    }

    //TODO new method
    public static void hexClickAndHold(By by) {
        hexVisibleComponentAssert(by);
        Actions actions = new Actions(AndroidDriverHx.getInstance());
        actions.clickAndHold(AndroidDriverHx.getInstance().findElement(by)).perform();
    }
}
