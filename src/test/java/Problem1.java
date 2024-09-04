import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        driver.get("https://www.edureka.co/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }


    @Test
    public void searchOperation() throws InterruptedException {
        Problem1POM page = new Problem1POM(driver);
        page.login("adwoafaith49@gmail.com","Edureka@");
        page.profile("Ewuradowa Kaa-YI");
        page.interestedTopics();
        page.letLogOut();

    }

    @AfterTest
    public void terminate(){
//        driver.quit();
    }

}
