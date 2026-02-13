package alfagift.steps;

import alfagift.pages.BerandaPage;
import alfagift.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ShoppingSteps {
    HomePage homePage;
    BerandaPage berandaPage;

    @Given("I am already logged in")
    public void iAmAlreadyLoggedIn() {
        berandaPage = new BerandaPage(Hooks.driver);
        System.out.println("Berada di Beranda!");
    }
    @Then("I click field search")
    public void iFillOnSearchBox() {
        berandaPage.clickSearch();
    }
    @And("I fill on search box {string}")
    public void andIFillOnSearchBox(String search) {
        berandaPage.filleditSearch(search);
    }
    @And("I click button search on keyboard")
    public void iClickOnKeyboardSearch() {
        berandaPage.clickSearchButtonOnKeyboard();
    }
    @And("I click the specific product {string}")
    public void iClickTheSpecificProduct(String product) {
        berandaPage.clickProductByName(product);
    }

    @Then("I should see the product detail page")
    public void iShouldSeeTheProductDetailPage() {
        berandaPage.validateProductDetailPage();

    }

}
