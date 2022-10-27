package appium.android.automation.steps;

import appium.android.automation.models.DataInjection;
import appium.android.automation.pageobjects.ContactPage;
import appium.android.automation.utils.AndroidDriverHx;

import static appium.android.automation.utils.HxInteractions.*;

public class ContactSteps {

    ContactPage contactPage = new ContactPage();
    DataInjection dataInjection = new DataInjection();

    //TODO some of changes on this method
    public void createNewContact(){
        hexClick(contactPage.addContactButton);
        hexClick(contactPage.cancelButton);
        hexWrite(contactPage.firstNameInput, dataInjection.getFirstName());
        hexWrite(contactPage.lastNameInput, dataInjection.getLastName());
        hexWrite(contactPage.emailInput, dataInjection.getEmail());
        hexWrite(contactPage.phoneInput, dataInjection.getPhone());
        hexClick(contactPage.saveButton);
        AndroidDriverHx.getInstance().closeApp();
        AndroidDriverHx.getInstance().launchApp();
        hexCompareTextInListOfElements(contactPage.contactName,
                dataInjection.getFirstName() + " " + dataInjection.getLastName());
    }

    //TODO new steps method
    public void deleteContact(){
        hexClickAndHold(contactPage.contactName);
        hexClick(contactPage.deleteButton);
        hexClick(contactPage.confirmDelete);
        hexVisibleComponentAssert(contactPage.contactListEmptyMessage);
    }

}
