package myprojects.automation.assignment4.pages;

import myprojects.automation.assignment4.BaseScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasicPage {

    WebDriver driver = BaseScript.getDriver("chrome");
    WebDriverWait wait = new WebDriverWait(driver, 15);

}
