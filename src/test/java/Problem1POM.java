import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Problem1POM {
    WebDriver driver;
    WebDriverWait wait;

    // Get CSS locators
    @FindBy(how = How.CSS, using = ".login_click.login-vd.giTrackElementHeader")
    @CacheLookup
    WebElement loginButton;

    @FindBy(how = How.ID, using = "si_popup_email")
    @CacheLookup
    WebElement email;

    @FindBy(how = How.ID, using = "si_popup_passwd")
    @CacheLookup
    WebElement password;

    @FindBy(how = How.CSS, using = "button[class='clik_btn_log btn-block']")
    @CacheLookup
    WebElement signUp;

    // Profile locators
    @FindBy(xpath = "//img[@class='img30']")
    @CacheLookup
    WebElement profile;

    @FindBy(xpath = "//a[normalize-space()='My Profile']")
    @CacheLookup
    WebElement Myprofile;

    @FindBy(xpath = "//a[@id='personal_details']//i[@class='icon-pr-edit']")
    @CacheLookup
    WebElement icon;


    @FindBy(how = How.ID, using = "fullname")
    @CacheLookup
    WebElement fullName;

    @FindBy(css = ".btn.btn-default.btn-lg.btn-save.btn_save.pull-right")
    @CacheLookup
    WebElement saveAndContinue;

    // Topics of interest
    @FindBy(xpath = "//a[normalize-space()='Topics of Interest']")
    @CacheLookup
    WebElement topicsOfInterest;

    @FindBy(xpath = "//button[@class='btn btn-add-more']")
    @CacheLookup
    WebElement addNow;

    @FindBy(xpath = "//mat-tab-body//li[4]")
    @CacheLookup
    WebElement name;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg btn-save pull-right btn_save']")
    @CacheLookup
    WebElement saveAndContinue2;

    // Logout
    @FindBy(xpath = "//span[@class='user_name']")
    @CacheLookup
    WebElement logoutIcon;

    @FindBy(xpath = "//a[normalize-space()='Log Out']")
    @CacheLookup
    WebElement logOut;


    @FindBy(how = How.ID, using = "wzrk-cancel")
    @CacheLookup
    WebElement popup;


    public Problem1POM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this); // Initialize WebElements
    }

    public void login(String Myemail, String Mypassword) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
            wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(Myemail);
            password.sendKeys(Mypassword);
            wait.until(ExpectedConditions.elementToBeClickable(signUp)).click();
        } catch (NoSuchElementException e) {
            System.out.println("No such element found");
        }
    }

    public void profile(String Myfullname) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(profile)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Myprofile)).click();
        wait.until(ExpectedConditions.elementToBeClickable(icon)).click();
        Thread.sleep(3000);
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert Text: " + alert.getText());
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert found");
        }
        fullName.clear();
        fullName.sendKeys(Myfullname);
        saveAndContinue.click();
        Thread.sleep(3000);
    }

    public void interestedTopics() {
        wait.until(ExpectedConditions.elementToBeClickable(topicsOfInterest)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addNow)).click();
        wait.until(ExpectedConditions.elementToBeClickable(name)).click();
        wait.until(ExpectedConditions.elementToBeClickable(saveAndContinue2)).click();
    }

    public void letLogOut() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logOut)).click();
    }

    public void handleUnexpectedPopup() {
        try {
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wzrk-cancel")));
            WebElement closeButton = popup.findElement(By.cssSelector(".close-button"));
            closeButton.click();
        } catch (Exception e) {
            System.out.println("No unexpected popup found");
        }
    }

    public void handleAlertWithRobot() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            System.out.println("Failed to handle alert with Robot: " + e.getMessage());
        }
    }
}