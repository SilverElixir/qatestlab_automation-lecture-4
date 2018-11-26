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
    public void setUp(@Optional("chrome") String browser ) {
        driver = new EventFiringWebDriver(DriverFactory.getWebDriverInstance("firefox"));
//        driver.register(new EventHandler());
        /**
         * I had to comment above line since its fail the test on "webElement.clear()"
         * EventHandler.java, line 92
         * AddNewProductPage.java, line 28
         * and I didn't have enough time to debug it properly :(
         */

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

        return new MainShopPage(driver);
    }
}
