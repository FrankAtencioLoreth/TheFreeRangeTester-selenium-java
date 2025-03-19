package pages;

public class CursesPage extends BasePage {

    private final String curseIntroductionTestingLink = "//a[normalize-space()='Selenium con Python y PyTest' and @href]";

    public CursesPage() {
        super(BasePage.driver);
    }

    public void clickCourse() {
        this.click(this.curseIntroductionTestingLink);
    }
    
}
