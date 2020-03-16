package carfax.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StepTwoPage {

    private static WebDriver driver;
    public WebElement showResults;

    public StepTwoPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickShowMeResults(){
        showResults = driver.findElement(By.cssSelector("button[class='button large primary-green']"));
        showResults.click();
    }
}
