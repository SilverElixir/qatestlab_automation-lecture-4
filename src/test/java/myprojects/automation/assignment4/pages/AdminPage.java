package myprojects.automation.assignment4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by lucky on 11/9/18.
 */
public class AdminPage extends BasicPage {

    WebElement catalogMenuItem = driver.findElement(By.id("subtab-AdminCatalog"));

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage selectProductsFromCatalogueMenu(){
        Actions builder = new Actions(driver);
        builder
                .moveToElement(catalogMenuItem)
                .moveToElement(driver.findElement(By.id("subtab-AdminProducts")))
                .moveToElement(driver.findElement(By.id("subtab-AdminCategories")))
                .moveToElement(driver.findElement(By.id("subtab-AdminProducts")))
                .click()
                .build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-header-desc-configuration-add")));
        return new ProductPage(driver);
    }



}
