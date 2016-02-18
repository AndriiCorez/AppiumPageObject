package appium.tests.tests;

import appium.tests.MainTest;
import appium.tests.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends MainTest{

    private String emptyEmailSignInAlertMessage = "Please add at least one email address.";

    @Test
    public void EmptyEmailSignInAlert(){
        //Actions
        LoginPage loginPage = new LoginPage(driver);
        String alertMessage = loginPage.clickGotItBtn().
                                        clickGetGooglePlayServicesBtn().
                                        clickSignInGmail().
                                        getEmptyAddressAlertText();

        //Assertion
        Assert.assertEquals(alertMessage, emptyEmailSignInAlertMessage);
    }
}
