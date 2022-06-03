package iceHrmTests;

import org.testng.annotations.Test;
import pages.IceHrmHomePage;

public class IceHrmHomeTest extends TestBase{

    @Test
    public void homeTest() throws InterruptedException {
        IceHrmHomePage iceHrmHomePage= new IceHrmHomePage(driver);
    iceHrmHomePage.switchToEmployee("Lala Lamees");
    }
}
