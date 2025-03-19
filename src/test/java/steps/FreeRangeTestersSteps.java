package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.Arrays;
import java.util.List;

public class FreeRangeTestersSteps {

    private final LandingPage landingPage = new LandingPage();
    private final CursesPage cursesPage = new CursesPage();
    private final CheckoutPage checkoutPage = new CheckoutPage();
    private final SoftAssert soft = new SoftAssert();

    @Given("I navigate to landing page")
    public void navigateToLandingPage() {
        this.landingPage.navigateToTheFreeRangeTesters();
    }

    @When("I go to {word} using the navigation bar")
    public void  iGoToSection(String section) {
        this.landingPage.clickOnSection(section);
    }

    @And("I select a course")
    public void iSelectACourse() {
        this.cursesPage.clickCourse();
    }

    @When("I select a plan")
    public void iSelectAPlan() {
        this.landingPage.clickOnPlan();
    }

    @Then("I can validate the options in the checkout page")
    public void validateOptionsInCheckoutPage() {
        List<String> options = this.checkoutPage.returnPlanDropdownValues();
        List<String> expectOptions = Arrays
                .asList(
                    "Academia: $16.99 / mes • 14 productos",
                        "Academia: $176 / año • 14 productos",
                        "Free: Gratis • 3 productos"
                );

        Assert.assertEquals(expectOptions, options);

        // Soft Assertions: Doesn't stop the execution if a verification fail.
        /*
        String worldExpect = "Pepe";
        String worldFound = "Papa";

        
        soft.assertEquals(worldExpect, worldFound);
        soft.assertTrue(worldExpect.contains(worldFound));
        soft.assertNotEquals(worldExpect,worldFound);

        soft.assertAll();
        */
    }
}
