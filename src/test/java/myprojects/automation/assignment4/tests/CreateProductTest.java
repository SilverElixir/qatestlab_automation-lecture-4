package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.BaseScript;
import org.testng.annotations.Test;

public class CreateProductTest extends BaseScript {

    @Test
    public void createNewProduct(String login, String password) {
        openMainPage()
                .loginAsAdmin("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw")
                .selectProductsFromCatalogueMenu()
                .addNewProduct()

    }

    // TODO implement logic to check product visibility on website
}
