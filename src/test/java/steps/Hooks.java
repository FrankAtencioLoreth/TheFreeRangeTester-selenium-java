package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;

public class Hooks extends BasePage {
    /**
     * Constructor to set the WebDriver instance (useful for dependency injection)
     */
    public Hooks() {
        super(driver);
    }

    @AfterClass
    public static void tearDown() {
        BasePage.quitBrowser();
    }

    @After
    public void cleanTearDown(Scenario scenario) {
        if( scenario.isFailed() ) {
            scenario.log("Scenario failing. Please refer to the image attached to this report");
            final byte[] screenshot = ((TakesScreenshot) BasePage.driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot of the error");
        }
    }
}
