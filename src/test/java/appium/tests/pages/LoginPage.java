package appium.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    //WebDriverWait wait;


    public By gotItBtn = By.xpath("//android.widget.TextView[@text='Got it' and @resource-id='com.google.android.gm:id/welcome_tour_got_it']");
    public By googlePlayPopup = By.xpath("//android.widget.Button[@text='Get Google Play services' and @resource-id='android:id/button1']");
    public By signInGmail = By.xpath("//android.widget.TextView[@text='Take me to Gmail' and @resource-id='com.google.android.gm:id/action_done']");
    public By emptyAddressAlert = By.xpath("//android.widget.TextView[starts-with(@text, 'Please add') and @resource-id='android:id/message']");

    public LoginPage(WebDriver driver){
        //wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }

    //public void waitGotItBtn(){wait.until(ExpectedConditions.presenceOfElementLocated(gotItBtn));}

    //public void waitGooglePlayPopup(){wait.until(ExpectedConditions.presenceOfElementLocated(googlePlayPopup));}

    //public void waitEmptyAddressAlert(){ wait.until(ExpectedConditions.presenceOfElementLocated(emptyAddressAlert));}

    public LoginPage clickGotItBtn() {
        //waitGotItBtn();
        try{driver.findElement(gotItBtn).click();}
        catch (Exception e){
            e.printStackTrace();

        }
        return this;
    }

    public LoginPage clickGetGooglePlayServicesBtn(){
        driver.findElement(googlePlayPopup).click();
        return this;
    }

    public LoginPage clickSignInGmail(){
        driver.findElement(signInGmail).click();
        return this;
    }

    public String getEmptyAddressAlertText(){return driver.findElement(emptyAddressAlert).getText();}

}
