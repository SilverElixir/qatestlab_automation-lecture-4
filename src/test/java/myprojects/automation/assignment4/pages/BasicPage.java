package myprojects.automation.assignment4.pages;

import myprojects.automation.assignment4.pages.shop.MainShopPage;
import myprojects.automation.assignment4.utils.DriverFactory;
import myprojects.automation.assignment4.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class BasicPage {

    protected static WebDriver driver = DriverFactory.getWebDriverInstance("chrome");

    protected WebDriverWait wait = new WebDriverWait(driver, 15);

    public static LoginPage openMainPage(){
        Reporter.log("Open Login page");
        driver.get(Properties.getBaseAdminUrl());
//        DriverFactory.getWebDriverInstance("chrome").get(Properties.getBaseAdminUrl());
        return new LoginPage();
    }

    public static MainShopPage openShopWelcomePage(){
        driver.get(Properties.getBaseUrl());
//        DriverFactory.getWebDriverInstance("chrome").get(Properties.getBaseUrl());
        // should I add up some kind of WAIT here - just to check main Shop page is fully loaded ??
        return new MainShopPage();
    }

}
