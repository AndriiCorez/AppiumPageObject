package appium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class MainTest {

    public WebDriver driver;
    //Initialize data
    protected String browserName;
    protected String browserVersion;
    protected String deviceName;
    protected String platformName;
    protected String appPackage;
    protected String appActivity;
    protected String appiumURL;
    protected DesiredCapabilities capabilities = new DesiredCapabilities();
    //Test data
    protected String username;
    protected String password;

    public MainTest(){
        if(browserName == null ||browserVersion == null || deviceName == null || platformName == null || appPackage == null ||
                appActivity == null || appiumURL == null || username == null || password == null ){
            try{
                initializeProperties();
            }catch(Exception e){
                //logger.error("Error occurred while initializing driver",e);
            }
        }
    }

    private void initializeProperties(){
        Properties prop = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("appium-test.properties");
        try{
        prop.load(stream);
        } catch (IOException e){
            //logger.error("Error occurred while loading properties file.",e);
        }
        browserName = prop.getProperty("appium-test.browserName");
        browserVersion = prop.getProperty("appium-test.browserVersion");
        deviceName = prop.getProperty("appium-test.deviceName");
        platformName = prop.getProperty("appium-test.platformName");
        appPackage = prop.getProperty("appium-test.appPackage");
        appActivity = prop.getProperty("appium-test.appActivity");
        appiumURL = prop.getProperty("appium-test.appiumURL");
        username = prop.getProperty("appium-test.username");
        password = prop.getProperty("appium-test.password");

    }

    @BeforeClass(alwaysRun = true)
    public void mainSetUp() throws MalformedURLException{
        //Capabilities
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
        capabilities.setCapability(CapabilityType.VERSION, browserVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        //Driver
        driver = new RemoteWebDriver(new URL(appiumURL), capabilities);
        System.out.println("Before class " + driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }
}
