import org.example.pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UiTest {
    private String url = "https://orlovrs.github.io/time-tracker/";
    protected WebDriver driver;
    MainPage mainPage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get(url);
        mainPage = new MainPage(driver);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
