package test.com.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import test.com.cucumber.common.Util;
import test.com.cucumber.pages.HomePage;

import java.util.Iterator;
import java.util.List;

public class SearchSteps {

    HomePage homePage;


    @Given("^I launch ebay online$")
    public void iLaunchEbayOnline() throws Throwable {
        homePage.open("ebayOnlineURL", PageObject.withParameters(Util.getProperty("ebayOnline.url")));
    }

    @When("^I go to all electronics section$")
    public void iGoToAllElectronicsSection() throws Throwable {
        homePage.goToAllElectronics();
    }

    @And("^I select best sellers$")
    public void iSelectBestSellers() throws Throwable {
        System.out.println("************   "+homePage.getBrands());

    }

    @Then("^I should see list of best sellers$")
    public void iShouldSeeListOfBestSellers() throws Throwable {

    }

    @When("^I login in ebay$")
    public void iLoginInEbay() throws Throwable {
        homePage.loginUser();

    }

    @And("^I go to Laptop And Tablet and select Apple products$")
    public void tGoToLaptopAndTabletAndSelectAppleProducts() throws Throwable {
        homePage.goForAppleLaptops();
    }

    @And("^I select a product$")
    public void iSelectAProduct() throws Throwable {
        homePage.selectaProduct();
    }

    @And("^click on buy now$")
    public void clickOnBuyNow() throws Throwable {
        homePage.clickOnBuyNow();
    }
}
