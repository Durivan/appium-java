package appium.android.automation.actions;

import appium.android.automation.models.DataInjection;
import appium.android.automation.pageobjects.ContactPage;

import static appium.android.automation.utils.BaseTest.getDriver;
import static appium.android.automation.utils.Interactions.*;

public class ContactActions {

    ContactPage contactPage = new ContactPage();
    DataInjection dataInjection = new DataInjection();

    public void createNewContact() {
        clickOn(contactPage.addContactButton);
        clickOn(contactPage.cancelButton);
        writeOn(contactPage.firstNameInput, dataInjection.getFirstName());
        writeOn(contactPage.lastNameInput, dataInjection.getLastName());
        writeOn(contactPage.emailInput, dataInjection.getEmail());
        writeOn(contactPage.phoneInput, dataInjection.getPhone());
        clickOn(contactPage.saveButton);
        getDriver().closeApp();
        getDriver().launchApp();
        compareTextInListOfElementsAssert(contactPage.contactName,
                dataInjection.getFirstName() + " " + dataInjection.getLastName());
    }

    public void deleteContact() {
        clickAndHoldOn(contactPage.contactName);
        clickOn(contactPage.deleteButton);
        clickOn(contactPage.confirmDelete);
        isVisibleComponentAssert(contactPage.contactListEmptyMessage);
    }

}
