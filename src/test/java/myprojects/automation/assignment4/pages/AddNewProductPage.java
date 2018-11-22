package myprojects.automation.assignment4.pages;

import myprojects.automation.assignment4.model.ProductData;
import org.openqa.selenium.By;

/**
 * Created by lucky on 11/20/18.
 */
public class AddNewProductPage extends BasicPage {

    /**
     * Заполнить следующие свойства нового продукта: Название продукта,
     Количество, Цена. Свойства продукта должны генерироваться случайно
     (случайное название продукта, количество от 1 до 100, цена от 0.1 ₴ до 100 ₴).
     */
    public void fillInFieldsForNewProduct(ProductData newProduct){
        driver.findElement(By.id("form_step1_name_1")).sendKeys(newProduct.getName());
        driver.findElement(By.id("form_step1_qty_0_shortcut")).sendKeys(newProduct.getQty().toString());
        driver.findElement(By.id("form_step1_price_shortcut")).sendKeys(newProduct.getPrice());

    }
}
