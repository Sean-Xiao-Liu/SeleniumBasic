package carfax.pages;

import introduction.DriverConfiguration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageTwoTest {

    public WebDriver driver = DriverConfiguration.chooseDriver("chrome");
    public static WebDriverWait wait;
    public static StepOnePage stepOnePage;
    public static StepTwoPage stepTwoPage;


    @Before
    public void setup(){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();// maximize the window when open a new one
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // wait 10 sec before throwing "No Such Element Exception"
        wait = new WebDriverWait(driver, 2); // Explicit wait, wait for Expected Condition
        stepOnePage = new StepOnePage(driver);
        stepOnePage.selectMakeModelZipAndClick();

    }

    @After
    public void tearDown(){
        DriverConfiguration.closeDriver();
    }

    @Test
    public void stepTwoPageTest() throws InterruptedException{
        stepTwoPage = new StepTwoPage(driver);
        Thread.sleep(2000);
        stepTwoPage.clickShowMeResults();
        Thread.sleep(2000);
        Assert.assertNotNull(driver.findElement(By.cssSelector("div[class='srp-filter-container__title tabs-title']")));

    }
}
