package myprojects.automation.assignment4.pages;

import myprojects.automation.assignment4.GeneralActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Created by otka on 14.11.2018.
 */
public class CategoriesPage extends BasicPage{

    /**
     *
     * @return
     */
    public AddNewCategoryPage clickOnAddNewCategoryBtn(){
        driver.findElement(By.id("page-header-desc-category-new_category")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("name_1")));

        return new AddNewCategoryPage();
    }

    public CategoriesPage checkSuccessMessageIsShown(){
        String successAlert = driver.findElement(By.cssSelector(".alert-success:nth-child(1)")).getText().replaceAll("\\s+","");;
        Assert.assertEquals(successAlert, "×Создано");
        return this;
    }

    public CategoriesPage filterGridWithSpecificCategory(String category){
        driver.findElement(By.name("categoryFilter_name")).sendKeys(category);
        driver.findElement(By.id("submitFilterButtoncategory")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("table-responsive-row")));
        return new CategoriesPage();
    }

    public CategoriesPage checkNewlyCategorieInTheGrid(){
        String actualCategory = driver.findElement(By.cssSelector("tbody > tr > td:nth-child(3)")).getText();
        Assert.assertEquals(actualCategory, GeneralActions.unchangedCategoryName, "TBD");
        return this;
    }
}
