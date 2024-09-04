import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleSearchMethodPOM {

    WebDriver driver;
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    @Test
    public void searchOperation(){
        GoogleSearch search = new GoogleSearch(driver);
        search.searchGoogle("facebook");
    }

    @AfterTest
    public void terminate(){
        driver.quit();
    }
}
