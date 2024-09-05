import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Problem1 {

    //Steps
    //login to the edureka website
    //navigate to my profile
    //update personal details and carrer interest
    //logout

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Create ChromeOptions instance
        ChromeOptions options = new ChromeOptions();

        // Add the argument to disable popup blocking
        options.addArguments("disable-popup-blocking");

        // Pass the ChromeOptions instance to the ChromeDriver constructor
        driver = new ChromeDriver(options);


        driver.get("https://www.edureka.co/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }


    @Test
    public void searchOperation() throws InterruptedException {
        Problem1POM page = new Problem1POM(driver);
        page.login("adwoafaith49@gmail.com", "Edureka@");
        page.profile("Ewuradowa Kaa-YI");

        page.interestedTopics();
        page.letLogOut();

    }

    @AfterTest
    public void terminate() {
       driver.quit();
    }


}
