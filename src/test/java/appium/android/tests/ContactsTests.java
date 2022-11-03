package appium.android.tests;

import appium.android.automation.actions.ContactActions;
import appium.android.automation.utils.BaseTest;
import org.testng.annotations.Test;


public class ContactsTests extends BaseTest {

    ContactActions contactActions = new ContactActions();

    @Test(groups = "smoke")
    public void addNewContact() {
        contactActions.createNewContact();
    }

    @Test(groups = "smoke")
    public void deleteContact() {
        contactActions.deleteContact();
    }
}
