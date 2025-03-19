package pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

    // Static WebDriver instance shared across all instances of BasePage
    protected static WebDriver driver;

    // WebDriverWait instance for handling explicit waits
    private final WebDriverWait wait = new WebDriverWait(BasePage.driver, Duration.ofSeconds(10));

    // Static block to initialize WebDriver and configure browser settings
    static {
        WebDriverManager.chromedriver().setup(); // Set up ChromeDriver using WebDriverManager
        BasePage.driver = new ChromeDriver(); // Instantiate ChromeDriver
        BasePage.driver.manage().window().maximize(); // Maximize browser window
    }

    /**
     * Constructor to set the WebDriver instance (useful for dependency injection)
     * @param driver WebDriver
     */
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    /**
     * Navigate to a specified URL
     * @param url String
     */
    public static void navigateTo(String url) {
        BasePage.driver.get(url);
    }

    /**
     * Quit the browser and close all associated windows
     */
    public static void quitBrowser() {
        BasePage.driver.quit();
    }

    /**
     * Helper method to locate an element using an XPath locator with explicit wait
     * @param locator String
     * @return webDriverWait WebDriverWait
     */
    private WebElement findElement(String locator) {
        return this.wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(locator)
                )
        );
    }

    /**
     * Clicks on an element specified by an XPath locator
     * @param locator String
     */
    public void click(String locator) {
        this.findElement(locator).click();
    }

    /**
     * Clicks on an element specified by a link text
     * @param locator String
     */
    public void goToLinkText(String locator) {
        BasePage.driver.findElement(By.linkText(locator)).click();
    }

    /**
     * Get text of element
     * @param locator String
     * @return text String
     */
    public String getTextElement(String locator) {
       return this.findElement(locator).getText();
    }

    /**
     * Clears existing text and inputs new text into a text field
     * @param locator String
     * @param text String
     */
    public void write(String locator, String text) {
        this.findElement(locator).clear();
        this.findElement(locator).sendKeys(text);
    }

    /**
     * Selects a dropdown option by its value attribute
     * @param locator String
     * @param value String
     */
    public void selectDropdownByValue(String locator, String value) {
        Select dropdown = new Select(this.findElement(locator));
        dropdown.selectByValue(value);
    }

    /**
     * Selects a dropdown option by its index position
     * @param locator String
     * @param index Integer
     */
    public void selectDropdownByIndex(String locator, int index) {
        Select dropdown = new Select(this.findElement(locator));
        dropdown.selectByIndex(index);
    }

    /**
     * Retrieves the number of options available in a dropdown
     * @param locator String
     * @return size Integer
     */
    public int selectDropdownGetSize(String locator) {
        Select dropdown = new Select(this.findElement(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }

    /**
     * Retrieves all dropdown option values as a list of strings
     * @param locator String
     * @return list List<String>
     */
    public List<String> getDropdownValues(String locator) {
        Select dropdown = new Select(this.findElement(locator));

        return dropdown.getOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
