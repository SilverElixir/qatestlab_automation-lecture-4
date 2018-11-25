package myprojects.automation.assignment4.pages;

import myprojects.automation.assignment4.BaseScript;
import myprojects.automation.assignment4.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Created by lucky on 11/9/18.
 */
public class LoginPage extends BasicPage{

    public AdminPage loginAsAdmin(String email, String password) {

//        1. Открыть страницу Админ панели
        driver.get(Properties.getBaseAdminUrl());
//        2. Ввести логин, пароль и нажать кнопку Логин.
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.name("submitLogin")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-sidebar")));
        Assert.assertTrue(driver.findElement(By.className("employee_avatar_small")).isDisplayed(), "OOPS! Looks like user avatar isn't shown");

        return new AdminPage();

    }

}
