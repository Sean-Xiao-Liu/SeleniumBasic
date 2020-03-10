package Introduction;

import io.cucumber.java.bs.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.AuthProvider;

//after input sth, will come up with the suggestion and make selection from there
// also use loop to repeat the click process
public class AutoSuggestiveDropDown {

    WebDriver driver;

    public void suggestiveDropDown(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        // use priceline web page as an example
        driver.get("https://booking.priceline.com/shop/search/");
        WebElement startLocation = driver.findElement(By.xpath("//input[@id='startLocation']"));
        WebElement endLocation = driver.findElement(By.xpath("//input[@id='endLocation']"));


        //clean all the content in start box and then type in "N"
        startLocation.clear();
        startLocation.sendKeys("N");
    }






    public static void main(String[] args) {

        AutoSuggestiveDropDown test = new AutoSuggestiveDropDown();
        test.suggestiveDropDown();

    }
}


