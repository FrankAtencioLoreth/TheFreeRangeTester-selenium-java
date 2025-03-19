package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.AmazonPage;

public class AmazonSteps {

    private final AmazonPage amazonPage = new AmazonPage();

    @Given("^the user navigate to www.amazon.com$")
    public void navigateToAmazon() {
        this.amazonPage.goToAmazon();
    }

    @And("^searches for (.+)$")
    public void enterSearchCriteria(String criteria) {
        this.amazonPage.enterSearchBox(criteria);
        this.amazonPage.clickSearch();
    }

    @And("^navigate to the second page$")
    public void navigateSecondPage() {
        this.amazonPage.goToSecondPage();
    }

    @And("^selects third item$")
    public void selectThirdItem() {
        this.amazonPage.clickThirdItem();
    }

    @Then("^the user is able to add it to the cart$")
    public void itemCanBeAddedToCart() {
        this.amazonPage.addToCart();
        Assert.assertEquals("Agregado al carrito", this.amazonPage.addedToCartMessage());
    }

}
