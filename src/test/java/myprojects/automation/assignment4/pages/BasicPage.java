package myprojects.automation.assignment4.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BasicPage {

    protected static WebDriver driver;
    protected WebDriverWait wait;

    public BasicPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

//    public static LoginPage openMainPage(){
//        Reporter.log("Open Login page");
//        driver.get(Properties.getBaseAdminUrl());
//
//        return new LoginPage(driver);
//    }

//    public static MainShopPage openShopWelcomePage(){
//        Reporter.log("Open Shop main page");
//        driver.get(Properties.getBaseUrl());
////        DriverFactory.getWebDriverInstance("chrome").get(Properties.getBaseUrl());
//        // should I add up some kind of WAIT here - just to check main Shop page is fully loaded ??
//        return new MainShopPage(driver);
//    }

}
