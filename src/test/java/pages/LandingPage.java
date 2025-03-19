package pages;

public class LandingPage extends BasePage {

    private final String sectionLink = "//a[normalize-space()='%s' and @href]";
    private final String planLink = "//a[normalize-space()='Elegir Plan' and @href]";

    public LandingPage() {
        super(BasePage.driver);
    }

    public void navigateToTheFreeRangeTesters() {
        BasePage.navigateTo("https://www.freerangetesters.com/");
    }

    public void clickOnSection(String section) {
        String xpathSection = String.format(this.sectionLink, section);
        this.click(xpathSection);
    }

    public void clickOnPlan() {
        this.click(this.planLink);
    }
    
}