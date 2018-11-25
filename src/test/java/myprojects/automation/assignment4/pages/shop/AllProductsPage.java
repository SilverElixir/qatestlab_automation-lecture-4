package myprojects.automation.assignment4.pages.shop;

import myprojects.automation.assignment4.pages.BasicPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Created by lucky on 11/22/18.
 */
public class AllProductsPage extends BasicPage{

    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    public AllProductsPage filterNewlyCreateProduct(String product){
        driver.findElement(By.name("s")).sendKeys(product);
        driver.findElement(By.cssSelector("button > .material-icons")).click();

        Assert.assertTrue(driver.findElements(By.cssSelector(".products.row")).size() == 1, "TBD - failure message");
        return this;
    }

    public OneProductSelectedPage clickOnFilteredProduct(){
        driver.findElement(By.cssSelector(".h3.product-title")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content-wrapper")));

        return new OneProductSelectedPage(driver);
    }







}
