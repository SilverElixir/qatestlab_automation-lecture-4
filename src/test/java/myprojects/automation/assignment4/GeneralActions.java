package myprojects.automation.assignment4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {

    public static final String newProductName = generateNewProductName();

//    public GeneralActions(WebDriver driver) {
//        this.driver = driver;
//        wait = new WebDriverWait(driver, 30);
//    }


    public static String generateNewProductName(){
        return "Cool Dress " + System.currentTimeMillis();
    }

}
