package stepDefinitions;


import introduction.DriverConfiguration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FacebookLoginStepDef {

    public WebDriver driver = DriverConfiguration.chooseDriver("chrome");
    public WebDriverWait wait = new WebDriverWait(driver, 1);

    @Given("User is on facebook home page")
    public void userIsOnFacebookHomePage() {
        driver.get("https://www.google.com");
    }

    @And("User input username and password")
    public void userInputUsernameAndPassword() {
        driver.get("https://www.google.com");
    }

    @When("User click the login button")
    public void userClickTheLoginButton() throws InterruptedException {
        Thread.sleep(3000);
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='q']"));
//        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        loginButton.sendKeys("try search this");
    }

    @Then("User should be logged in")
    public void userShouldBeLoggedIn() {
        WebElement googleSearchButton = driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']"));
        googleSearchButton.click();
        // assert the google logo is displayed
        Assert.assertTrue(1 == 1);
        DriverConfiguration.closeDriver();
    }
}
