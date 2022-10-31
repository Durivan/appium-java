package appium.android.tests;

import appium.android.automation.actions.ContactActions;
import appium.android.automation.utils.BaseTest;
import org.testng.annotations.Test;


public class AndroidTests extends BaseTest {

    ContactActions contactActions = new ContactActions();

    @Test
    public void addNewContact() {
        contactActions.createNewContact();
    }

    @Test
    public void deleteContact() {
        contactActions.deleteContact();
    }
}
