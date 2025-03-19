package pages;

import java.util.List;

public class CheckoutPage extends BasePage {
    
    private final String planDropdownId = "//select[@id='cart_cart_item_attributes_plan_with_interval']";

    public CheckoutPage() {
        super(BasePage.driver);
    }

    public List<String> returnPlanDropdownValues() {
        return this.getDropdownValues(this.planDropdownId);
    }

}
