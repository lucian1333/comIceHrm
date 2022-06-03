package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IceHrmHomePage {
    public IceHrmHomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[.=\"Switch\"]")
    private WebElement switchButton;
    @FindBy(id = "myModalLabel")
    private WebElement switchToText;

    @FindBy (xpath = "//p[contains(text(),\"Select The Employee to Switch Into\")]")
    private WebElement selectEmployeeText;


    @FindBy(id ="s2id_autogen1_search")
    private WebElement employeeSearch;

    @FindBy(xpath ="//*[text() [contains(. , \"Changed To\")]]//../p/a")
    private WebElement employeeNameElement;

    @FindBy(xpath = "//*[text() [contains(. , \"Changed To\")]]")
    private WebElement changedToText;

    @FindBy(xpath = "//i[@class=\"fa fa-circle text-warning\"]")
    private WebElement brownCircle;
    @FindBy(xpath = "//span[@id=\"select2-chosen-1\"]")
    private WebElement openSearchField;
    @FindBy(xpath = "//button[.=\"Switch\"]")
    private WebElement switchButtonInPopUp;
//    Navigate to the "http://icehrm-open.gamonoid.com/login.php?" Enter username "admin"
//    Enter password "admin"
//    Click sign-in button
//    Click Switch button
//    Validate "Switch Employee" is displayed and text is matching Validate "Select The Employee to Switch Into" is displayed and text is matching
//    Select "Lala Lamees"
//    Click Switch button
//    Validate "Lala Lamees" name is displayed and name is matching with selected name
//    Validate "Changed to" text is correct
//    Validate color of circle is brown (#8a6d3b)
    public void switchToEmployee(String employeeName) throws InterruptedException {
        Thread.sleep(1000);
        switchButton.click();
        String expectedPopUpText1= "Switch Employee";
        Thread.sleep(1000);
        String actulaPopUpText1 = switchToText.getText().trim();
        Assert.assertEquals(actulaPopUpText1,expectedPopUpText1);
        String expectedPopUpText2 = "Select The Employee to Switch Into";
        String actualPopUpText2 = selectEmployeeText.getText().trim();
        Assert.assertEquals(actualPopUpText2,expectedPopUpText2);
        Thread.sleep(500);
        openSearchField.click();
        Thread.sleep(500);
        employeeSearch.sendKeys(employeeName);
        employeeSearch.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        switchButtonInPopUp.click();
        Thread.sleep(1500);
        Assert.assertTrue(changedToText.isDisplayed());
        String actualName = employeeNameElement.getText().trim().toLowerCase();
        Thread.sleep(500);
        Assert.assertEquals(actualName,employeeName.toLowerCase());
        String expectedRGB = "rgba(138, 109, 59, 1)";
        String actualRGB= brownCircle.getCssValue("color");
        Assert.assertEquals(actualRGB,expectedRGB);


    }
}
