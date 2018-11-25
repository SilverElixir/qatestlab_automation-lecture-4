package myprojects.automation.assignment4.pages.shop;

import myprojects.automation.assignment4.pages.BasicPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by lucky on 11/22/18.
 */

public class OneProductSelectedPage extends BasicPage {

    public OneProductSelectedPage(WebDriver driver) {
        super(driver);
    }

    public OneProductSelectedPage verifyProductNameIsCorrect(String expectedProductName){
        String actualProductName = driver.findElement(By.cssSelector(".h1[itemprop='name']")).getText();

        Assert.assertEquals(actualProductName, expectedProductName.toUpperCase(), "TBD - failure message");
        return this;
    }

    public OneProductSelectedPage verifyProductPriceIsAccurate(String expectedPrice){
        String actualProdice = driver.findElement(By.cssSelector(".current-price > span")).getAttribute("content");

        Assert.assertEquals(actualProdice, expectedPrice, "TBD - failure message");
        return this;
    }

    public OneProductSelectedPage verifyProductQtyIsCorrect(int expectedQty){
        String actualQtyRaw = driver.findElement(By.cssSelector(".product-quantities > span")).getText();
        String expectedQtyStr = String.valueOf(expectedQty) + " Товары";

        Assert.assertEquals(actualQtyRaw, expectedQtyStr, "TBD - failure message");
        return this;
    }
}
