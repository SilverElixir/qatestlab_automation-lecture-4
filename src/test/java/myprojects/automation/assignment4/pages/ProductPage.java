package myprojects.automation.assignment4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by lucky on 11/19/18.
 */
public class ProductPage extends BasicPage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public AddNewProductPage clickOnAddNewProductBtn(){
        driver.findElement(By.id("page-header-desc-configuration-add")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product-header")));

        return new AddNewProductPage(driver);
    }
}
