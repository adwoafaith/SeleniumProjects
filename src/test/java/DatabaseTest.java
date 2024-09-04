import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testDatabase() throws SQLException {

        // Verify the database state
        String query = "SELECT * FROM _user";
        ResultSet resultSet = DataBaseTesting.DatabaseUtil.executeQuery(query);

        while(resultSet.next()){
            System.out.println(resultSet.getString("email"));
            System.out.println(resultSet.getString("firstname"));
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
