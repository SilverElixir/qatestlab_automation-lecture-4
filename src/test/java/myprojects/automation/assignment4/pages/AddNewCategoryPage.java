package myprojects.automation.assignment4.pages;

import myprojects.automation.assignment4.GeneralActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by otka on 14.11.2018.
 */
public class AddNewCategoryPage extends BasicPage {

    public CategoriesPage addNewCategoriesWithRandomName(){

        driver.findElement(By.id("name_1")).sendKeys(GeneralActions.unchangedCategoryName);
        driver.findElement(By.id("category_form_submit_btn")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("page-head")));
        return new CategoriesPage();
    }
}
