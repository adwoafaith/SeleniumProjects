import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Mine {
    WebDriver driver;

    @Test
    public void myMethod(){
        driver = new ChromeDriver();
        driver.get("http://www.edureka.co");
        driver.getTitle();
        System.out.println("the tile");
    }

}
