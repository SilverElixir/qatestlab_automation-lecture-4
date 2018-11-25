package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.BaseScript;
import myprojects.automation.assignment4.model.ProductData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateProductTest extends BaseScript {

    final ProductData newProduct = ProductData.generate();

    @DataProvider
    public Object[][] DataProviderData() {
        return  new Object[][]{
                new Object[]{"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"}
        };
    }

    @Test(dataProvider = "DataProviderData")
//    public void createNewProduct() {
    public void createNewProduct(String login, String password) {
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
