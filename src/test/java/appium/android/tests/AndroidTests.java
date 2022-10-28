package appium.android.tests;

import appium.android.automation.steps.ContactSteps;
import appium.android.automation.utils.BaseTest;
import org.testng.annotations.Test;


public class AndroidTests extends BaseTest {

    ContactSteps contactSteps = new ContactSteps();

    @Test
    public void addNewContact() {
        contactSteps.createNewContact();
    }

    @Test
    public void deleteContact() {
        contactSteps.deleteContact();
    }


}
