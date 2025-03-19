package pages;

public class AmazonPage extends BasePage {

    private final String searchBox = "//input[@id='twotabsearchtextbox']";
    private final String searchButton = "//input[@id='nav-search-submit-button']";
    private final String thirdResult = "/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/span/div/div/div/div[2]/div/div/div[1]/a";
    private final String addToCartButton = "//input[@id='add-to-cart-button']";
    private final String addedMessageText = "//h1[contains(.,'Agregado al carrito')]";


    /**
     * Constructor to set the WebDriver instance (useful for dependency injection
     */
    public AmazonPage() {
        super(driver);
    }

    public void goToAmazon() {
        BasePage.navigateTo("https://www.amazon.com/");
    }

    public void enterSearchBox(String criteria) {
        this.write(this.searchBox, criteria);
    }

    public void clickSearch() {
        this.click(this.searchButton);
    }

    public void goToSecondPage() {
        this.goToLinkText("2");
    }

    public void clickThirdItem() {
        this.click(this.thirdResult);
    }

    public void addToCart() {
        this.click(this.addToCartButton);
    }

    public String addedToCartMessage() {
        return this.getTextElement(this.addedMessageText);
    }
}
