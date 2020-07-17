package stepDefinitions;

import carfax.pages.BasePage;
import carfax.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FindDealStepDef {
    BasePage basePage = new BasePage();
    public WebDriver driver = Driver.getDriver();
    public WebDriverWait wait = new WebDriverWait(driver,3);

    @Given("I am on main carfax page")
    public void iAmOnMainCarfaxPage(){
        driver.get("https://beta.carfax.com/");
    }

    @And("I navigate to find a used car page")
    public void iNavigateToFindAUsedCarPage(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // wait for 3 seconds before throwing "No Such Element Exception"
        basePage.getBetaHomePage().findAUsedCarButton.click();
    }



}
