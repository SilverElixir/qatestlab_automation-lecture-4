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

    protected EventFiringWebDriver driver;

    /**
     * Prepares {@link WebDriver} instance with timeout and browser window configurations.
     *
     * Driver type is based on passed parameters to the automation project,
     * creates {@link ChromeDriver} instance by default.
     *
     */
    @BeforeClass
    // TODO use parameters from pom.xml to pass required browser type
    public void setUp() {
//    public void setUp(String browser ) {
        driver = new EventFiringWebDriver(DriverFactory.getWebDriverInstance("chrome"));
//        driver = new EventFiringWebDriver(getDriver(browser));
        driver.register(new EventHandler());

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * Closes driver instance after test class execution.
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
