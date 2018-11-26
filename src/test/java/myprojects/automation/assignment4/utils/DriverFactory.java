package myprojects.automation.assignment4.utils;

import myprojects.automation.assignment4.BaseScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.net.URISyntaxException;
import java.nio.file.Paths;


/**
 * Singleton-like class
 */
public class DriverFactory{

    private DriverFactory(){}

    protected static WebDriver webDriver;

    /**
     * @param browser Driver type to use in tests.
     *
     * @return New instance of {@link WebDriver} object.
     */
    public static WebDriver getWebDriverInstance(String browser) {
        if(webDriver == null) {
            switch (browser) {
                case "firefox":
//                    System.setProperty("webdriver.gecko.driver", getResource("/mac/geckodriver"));
                System.setProperty("webdriver.gecko.driver", getResource("/win/geckodriver.exe"));
                    return new FirefoxDriver();
                case "ie":
                case "internet explorer":
                    System.setProperty("webdriver.ie.driver", getResource("/win/IEDriverServer.exe"));
                    return new InternetExplorerDriver();
                case "chrome":
                default:
//                    System.setProperty("webdriver.chrome.driver", getResource("/mac/chromedriver"));
                System.setProperty("webdriver.chrome.driver", getResource("/win/chromedriver.exe"));
                    return new ChromeDriver();
            }
        }
        return webDriver;
    }

    /**
     * @param resourceName The name of the resource
     * @return Path to resource
     */
    private static String getResource(String resourceName) {
        try {
            return Paths.get(BaseScript.class.getResource(resourceName).toURI()).toFile().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return resourceName;
    }

}
