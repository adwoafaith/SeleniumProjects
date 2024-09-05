import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FlightBookingApplicationPOM {
    WebDriver driver;
    public FlightBookingApplicationPOM(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(how=How.XPATH,using = "//div[@class='lJ9FBc']//input[@name='btnK']")
    @CacheLookup
    WebElement email;


}
