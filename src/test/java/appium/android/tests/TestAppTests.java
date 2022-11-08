package appium.android.tests;

import appium.android.automation.utils.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static appium.android.automation.utils.Interactions.clickOn;
import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.testng.Assert.assertEquals;

public class TestAppTests extends BaseTest {

    /**
     * Para ejecutar esta bateria de tests debemos apuntar a la app "appDePruebas" desde BaseTest
     */

    @Test
    public void dragAndDrop() throws InterruptedException {
        loginApp();
        Thread.sleep(5000);
        getDriver().findElementByAccessibilityId("dragAndDrop").click();
        MobileElement dragMe = (MobileElement) new WebDriverWait(getDriver(), 30)
                .until(elementToBeClickable(MobileBy.AccessibilityId("dragMe")));
        Point source = dragMe.getCenter();
        Point target = getDriver().findElementByAccessibilityId("dropzone").getCenter();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(ofMillis(0),
                PointerInput.Origin.viewport(), source.x, source.y));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        dragNDrop.addAction(new Pause(finger, ofMillis(600)));
        dragNDrop.addAction(finger.createPointerMove(ofMillis(600),
                PointerInput.Origin.viewport(),
                target.x, target.y));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        getDriver().perform(singletonList(dragNDrop));
        assertEquals(getDriver().findElementsByAccessibilityId("success").size(), 1);
    }

    private void loginApp(){
        clickOn(MobileBy.AccessibilityId("login"));
    }
}
