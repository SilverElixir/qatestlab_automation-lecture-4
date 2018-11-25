package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.BaseScript;
import myprojects.automation.assignment4.model.ProductData;
import org.testng.annotations.Test;

import static myprojects.automation.assignment4.pages.BasicPage.openMainPage;
import static myprojects.automation.assignment4.pages.BasicPage.openShopWelcomePage;

public class CreateProductTest extends BaseScript {

    final ProductData newProduct = ProductData.generate();

    @Test
    public void createNewProduct() {
//    public void createNewProduct(String login, String password) {
        openMainPage()
                .loginAsAdmin("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw")
                .selectProductsFromCatalogueMenu()
                .clickOnAddNewProductBtn()
                .createNewProductWith3Attributes(newProduct)
                .makeProductToBeOnline()
                .saveProduct();
    }

    @Test(dependsOnMethods = "createNewProduct")
    public void verifyProductAndItsAttributesAtTheMainPage(){
        openShopWelcomePage()
                .goToAllProductsPage()
                .filterNewlyCreateProduct(newProduct.getName())
                .clickOnFilteredProduct()
                .verifyProductNameIsCorrect(newProduct.getName())
                .verifyProductPriceIsAccurate(newProduct.getPrice())
                .verifyProductQtyIsCorrect(newProduct.getQty());

   }
}
