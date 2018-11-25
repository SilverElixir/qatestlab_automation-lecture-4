package myprojects.automation.assignment4.pages.shop;

import myprojects.automation.assignment4.pages.BasicPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by lucky on 11/22/18.
 */
public class MainShopPage extends BasicPage {

    public MainShopPage(WebDriver driver) {
        super(driver);
    }

    public AllProductsPage goToAllProductsPage(){
        driver.findElement(By.className("all-product-link")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("products")));

        return new AllProductsPage(driver);
    }
}
