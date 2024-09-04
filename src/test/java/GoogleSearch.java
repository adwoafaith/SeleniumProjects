import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class GoogleSearch {
    WebDriver driver;

    public GoogleSearch(WebDriver driver){
        this.driver = driver;
    }


    By searchBox = By.id("APjFqb");
    By searchButton = By.xpath("//div[@class='lJ9FBc']//input[@name='btnK']");

    public void searchGoogle(String value){
        try {
            driver.findElement(searchBox).sendKeys(value);
            System.out.println("found button");
            Thread.sleep(3000);
            driver.findElement(searchButton).click();
        }
        catch (NoSuchElementException e){
            System.out.println("no such element found");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
