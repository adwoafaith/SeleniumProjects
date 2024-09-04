import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.URL;

public class GridTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Define the capabilities for the browser you want to test
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");

        // Set ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setCapability(ChromeOptions.CAPABILITY, capabilities);

        // Connect to the Selenium Grid Hub
        driver = new RemoteWebDriver(new URL("http://172.20.48.1:4444/wd/hub"), options);
    }

    @Test
    public void testGrid() {
        // Open a webpage
        driver.get("http://www.example.com");

        // Print the page title
        System.out.println("Page title: " + driver.getTitle());
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}