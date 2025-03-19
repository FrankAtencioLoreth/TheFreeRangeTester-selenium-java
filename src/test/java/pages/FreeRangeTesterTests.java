package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreeRangeTesterTests {
    
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        //Initialize the webdriver for chrome browser
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @Test
    public void goToPage() {
        //Go to the free range testers page
        this.driver.get("https://www.thefreerangetesters.com");
    }

    @AfterMethod
    public void tearDown() {
        //Quit driver before test execution
        if(this.driver!=null)
            this.driver.quit();
    }
}