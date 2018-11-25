package myprojects.automation.assignment4.pages;

import myprojects.automation.assignment4.model.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Created by lucky on 11/20/18.
 */
public class AddNewProductPage extends BasicPage {

    public AddNewProductPage(WebDriver driver) {
        super(driver);
    }

//    final ProductData newProduct = ProductData.generate();

    /**
     * Заполнить следующие свойства нового продукта: Название продукта, Цена
      Количество. Свойства продукта должны генерироваться случайно
     (случайное название продукта, количество от 1 до 100, цена от 0.1 ₴ до 100 ₴).
     */

    public AddNewProductPage createNewProductWith3Attributes(ProductData newProduct){
        driver.findElement(By.id("form_step1_name_1")).sendKeys(newProduct.getName());
        driver.findElement(By.id("form_step1_price_shortcut")).clear();
        driver.findElement(By.id("form_step1_price_shortcut")).sendKeys(newProduct.getPrice());
        driver.findElement(By.id("form_step1_qty_0_shortcut")).sendKeys(newProduct.getQty().toString());
        return this;
    }

    public AddNewProductPage makeProductToBeOnline(){
        driver.findElement(By.className("switch-input")).click();
        checkGrowlMessagePopsUp();
        return this;
    }

    public AddNewProductPage saveProduct(){
        driver.findElement(By.cssSelector(".js-btn-save[type='submit']")).click();
        checkGrowlMessagePopsUp();
        return this;
    }

    private void checkGrowlMessagePopsUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("growl-notice")));
        String successMessage = driver.findElement(By.className("growl-message")).getText();
        Assert.assertEquals(successMessage, "Настройки обновлены.", "TBD - Failure message");
    }

}
