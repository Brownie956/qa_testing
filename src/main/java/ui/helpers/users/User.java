package ui.helpers.users;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.config.Conf;
import ui.config.Driver;

import java.util.concurrent.TimeUnit;

public abstract class User {

    private RemoteWebDriver webDriver;

    User(){
        this.webDriver = setupDriver();
        this.webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        this.webDriver.getWebDriver().manage().window().fullscreen();
        this.webDriver.manage().window().maximize();
    }

    RemoteWebDriver getWebDriver(){
        return this.webDriver;
    }

    private RemoteWebDriver setupDriver(){
        Driver driver = new Driver(Conf.BROWSER);
        return driver.getWebDriver();
    }

    public void tearDown() {
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }

    public final void navigate_to(String url){
        webDriver.navigate().to(url);
    }

    public final String views_page_title(){
        return webDriver.getTitle();
    }
}
