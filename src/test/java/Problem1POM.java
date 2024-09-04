import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Problem1POM {
    WebDriver driver;
    WebDriverWait wait;

    public Problem1POM(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Get CSS locators
    By loginButton = By.cssSelector(".login_click.login-vd.giTrackElementHeader");
    By email = By.id("si_popup_email");
    By password = By.id("si_popup_passwd");
    By signUp = By.cssSelector("button[class='clik_btn_log btn-block']");

    //profile locators
    By profile = By.xpath("//img[@class='img30']");
    By Myprofile = By.xpath("//a[normalize-space()='My Profile']");
    By icon = By.xpath("//a[@id='personal_details']//i[@class='icon-pr-edit']");
    By fullName = By.xpath("//input[@id='fullName']");
    By saveAndContinue = By.cssSelector(".btn.btn-default.btn-lg.btn-save.btn_save.pull-right");

    //Topics of interest
    By topicsOfInterest = By.xpath("//a[normalize-space()='Topics of Interest']");
    By addNow = By.xpath("//button[@class='btn btn-add-more']");
    By name = By.xpath("//mat-tab-body//li[4]");
    By saveAndContinue2 = By.xpath("//button[@class='btn btn-default btn-lg btn-save pull-right btn_save']");

    //loout
    By logoutIcon = By.xpath("//span[@class='user_name']");
    By logOut = By.xpath("//a[normalize-space()='Log Out']");


    public void login(String Myemail, String Mypassword){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(Myemail);
            driver.findElement(password).sendKeys(Mypassword);
            wait.until(ExpectedConditions.elementToBeClickable(signUp)).click();
        } catch (NoSuchElementException e) {
            System.out.println("No such element found");
        }
    }
    public void profile(String Myfullname) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(profile)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Myprofile)).click();
        wait.until(ExpectedConditions.elementToBeClickable(icon)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullName)).sendKeys(Myfullname);
        wait.until(ExpectedConditions.elementToBeClickable(saveAndContinue)).click();
        Thread.sleep(3000);
    }

    public void interestedTopics(){
        wait.until(ExpectedConditions.elementToBeClickable(topicsOfInterest)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addNow)).click();
        wait.until(ExpectedConditions.elementToBeClickable(name)).click();
        wait.until(ExpectedConditions.elementToBeClickable(saveAndContinue2)).click();
    }

    public void letLogOut(){
        wait.until(ExpectedConditions.elementToBeClickable(logoutIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logOut)).click();
    }
}