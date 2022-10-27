package appium.android.tests;

import appium.android.automation.steps.ContactSteps;
import org.testng.annotations.Test;


public class AndroidTests{

    ContactSteps contactSteps = new ContactSteps();

    @Test
    public void addNewContact(){
        contactSteps.createNewContact();
    }

    //TODO new test

    @Test
    public void deleteContact(){
        contactSteps.deleteContact();
    }


}
