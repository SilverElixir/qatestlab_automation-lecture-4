package myprojects.automation.assignment4;

import myprojects.automation.assignment4.pages.LoginPage;
import myprojects.automation.assignment4.pages.shop.MainShopPage;
import myprojects.automation.assignment4.utils.DriverFactory;
import myprojects.automation.assignment4.utils.Properties;
import myprojects.automation.assignment4.utils.logging.EventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    protected static EventFiringWebDriver driver;

    /**
     * Prepares {@link WebDriver} instance with timeout and browser window configurations.
     *
     * Driver type is based on passed parameters to the automation project,
     * creates {@link ChromeDriver} instance by default.
     *
     */
    @Parameters("browser")
    @BeforeTest
    public void setUp() {
//    public void setUp(@Optional("chrome") String browser ) {
        driver = new EventFiringWebDriver(DriverFactory.getWebDriverInstance("firefox"));
//        driver.register(new EventHandler());

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * Closes driver instance after test class execution.
     */
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static LoginPage openMainPage(){
        Reporter.log("Open Login page");
        driver.get(Properties.getBaseAdminUrl());

        return new LoginPage(driver);
    }

    public static MainShopPage openShopWelcomePage(){
        Reporter.log("Open Shop main page");
        driver.get(Properties.getBaseUrl());
//        DriverFactory.getWebDriverInstance("chrome").get(Properties.getBaseUrl());
        // should I add up some kind of WAIT here - just to check main Shop page is fully loaded ??
        return new MainShopPage(driver);
    }
}
