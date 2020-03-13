package carfax.pages;

import introduction.DriverConfiguration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class CheckboxTest {

    public WebDriver driver = DriverConfiguration.chooseDriver("chrome");
    public CheckBox checkBox = new CheckBox(driver);

    @Before
    public void setup(){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();// maximize the window when open a new one
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // wait 10 sec before throwing "No Such Element Exception"
        checkBox.checkBoxConfig();
    }



    @After
    public void tearDown(){
        DriverConfiguration.closeDriver();
    }

//    @Ignore
    @Test
    public void clickNoAccientTest() throws InterruptedException {

        checkBox.clickNoAccident();
        Thread.sleep(2000);
        checkBox.clickNoAccident();
        assertTrue(checkBox.noAccident.isDisplayed() && checkBox.noAccident.isEnabled());
    }

//    @Ignore
    @Test
    public void clickOneOwnerTest()throws InterruptedException{
        checkBox.clickOneOwner();
        Thread.sleep(2000);
        checkBox.clickOneOwner();
        assertTrue(checkBox.oneOwner.isDisplayed() && checkBox.oneOwner.isEnabled());

    }

//    @Ignore
    @Test
    public void clickPersonalUseTest()throws InterruptedException{
        checkBox.clickPersonalUse();
        Thread.sleep(2000);
        checkBox.clickOneOwner();
        assertTrue(checkBox.personalUse.isDisplayed() && checkBox.personalUse.isEnabled());
    }

//    @Ignore
    @Test
    public void clickServiceHistoryTest() throws InterruptedException{
        checkBox.clickServiceHistory();
        Thread.sleep(2000);
        checkBox.clickServiceHistory();
        assertTrue(checkBox.serviceHistory.isDisplayed() && checkBox.serviceHistory.isEnabled());
    }

    @Test
    public void clickShowResultsTest()throws InterruptedException{
        Thread.sleep(2000); // sleep for 2 sec to make sure the the button is ready
        checkBox.clickShowResults();
        Assert.assertNotNull(driver.findElement(By.cssSelector("div[class='srp-filter-container__title tabs-title']")));
    }
}
