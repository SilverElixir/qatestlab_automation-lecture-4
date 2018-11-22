package myprojects.automation.assignment4.pages;

import myprojects.automation.assignment4.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lucky on 11/9/18.
 */
public class AdminPage extends BasicPage {

    WebElement catalogMenuItem = driver.findElement(By.id("subtab-AdminCatalog"));

    public ProductPage selectProductsFromCatalogueMenu(){
        Actions builder = new Actions(driver);
        builder
                .moveToElement(catalogMenuItem)
                .moveToElement(driver.findElement(By.id("subtab-AdminProducts")))
                .click()
                .build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-head")));

        return new ProductPage();
    }



}
