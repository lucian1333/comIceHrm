package iceHrmTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.IceHrmLoginPage;
import util.Driver;

public class TestBase {
    public static WebDriver driver;
    public static IceHrmLoginPage loginPage;
    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        driver.get("http://icehrm-open.gamonoid.com/login.php?");
        loginPage = new IceHrmLoginPage(driver);
        loginPage.login("admin","admin");

    }
}
