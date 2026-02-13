package alfagift.steps;

import alfagift.pages.BerandaPage;
import alfagift.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    HomePage homePage;
    BerandaPage berandaPage;
//    public void setupPages() {
//        if (homePage == null) {
//            homePage = new HomePage(Hooks.driver);
//        }
//        if (berandaPage == null) {
//            berandaPage = new BerandaPage(Hooks.driver);
//        }
//    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
            homePage = new HomePage(Hooks.driver);
            berandaPage = new BerandaPage(Hooks.driver);
        System.out.println("Aplikasi terbuka dan Page Object sudah siap!");

        }

    @When("I login with phone number {string}")
    public void iLoginWithPhoneNumber(String phone) {
        homePage.enterPhoneNumber(phone);
    }
    @And("I Click Masuk")
    public void iClickMasuk() {
        homePage.enterMasukOrDaftar();
    }
    @And("I fill the password {string}")
    public void iFillThePassword(String password) {
        homePage.enterpassword(password);
    }
    @And("I Click Masuk ke beranda")
    public void iClickMasuk2() {
        homePage.enterMasukOrDaftar2();
    }
    @Then("I successfully login")
    public void iSuccessfullLogin() {
        berandaPage.validateLoginSuccess();
    }



}




