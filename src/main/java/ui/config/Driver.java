package ui.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    private RemoteWebDriver webDriver;

    public enum DriverType {
        FIREFOX, CHROME
    }

    public Driver(DriverType type) {
        if(type == DriverType.FIREFOX){
            this.webDriver = create_firefox_driver();
        }
        else if(type == DriverType.CHROME){
            this.webDriver = create_chrome_driver();
        }
    }

    public Driver(){
        this(DriverType.FIREFOX);
    }

    public RemoteWebDriver getWebDriver() {
        return webDriver;
    }

    private FirefoxDriver create_firefox_driver(){
//        TODO need to get GekhoDriver working for this to work
        return new FirefoxDriver();
    }

    private ChromeDriver create_chrome_driver(){
        return new ChromeDriver();
    }

    private AppiumDriver create_appium_driver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "iPhone 6");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability("platformVersion", "9.1");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");

        URL appiumServerAddress = null;
        try {
            appiumServerAddress = new URL("http://127.0.0.1:4723");
        }
        catch (MalformedURLException mue) {
            mue.getStackTrace();
        }

        IOSDriver driver = new IOSDriver(appiumServerAddress, capabilities);
        return driver;
    }
}
