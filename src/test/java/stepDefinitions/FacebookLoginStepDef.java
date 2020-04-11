package stepDefinitions;


import introduction.DriverConfiguration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Cucumber.class)
public class FacebookLoginStepDef {

    public WebDriver driver = DriverConfiguration.chooseDriver("chrome");
    public WebDriverWait wait = new WebDriverWait(driver, 1);

    @Given("User is on facebook home page")
    public void userIsOnFacebookHomePage() {
    }

    @And("User input username and password")
    public void userInputUsernameAndPassword() {

    }

    @When("User click the login button")
    public void userClickTheLoginButton(){
        driver.get("https://www.facebook.com/");
        WebElement loginButton = driver.findElement(By.id("loginbutton"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    @Then("User should be logged in")
    public void userShouldBeLoggedIn() {
    }
}
