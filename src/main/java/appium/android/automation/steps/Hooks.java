package appium.android.automation.steps;

import appium.android.automation.utils.AndroidDriverHx;
import org.testng.annotations.AfterTest;

public class Hooks {


    //TODO cuando finaliza el primer test no cierra, cierra luego de la primera interaccion del segundo test
    //@AfterTest
    public void closeAndroidDriver(){
        AndroidDriverHx.getInstance().close();
    }
}
