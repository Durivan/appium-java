package appium.android.tests;

import appium.android.automation.utils.BaseTest;
import org.testng.annotations.Test;

public class TestAppTests extends BaseTest {

    @Test(groups = {"regression", "WIP"})
    public void installAppFromResources() throws InterruptedException {
        Thread.sleep(15000);
        getDriver().closeApp();
    }
}
