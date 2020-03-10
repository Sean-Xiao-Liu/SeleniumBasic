package Introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

    WebDriver driver;


    public void staticDropDowm(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.get("https://beta.carfax.com/cars-for-sale");

        driver.findElement(By.xpath("//select[@name='make']")).click();

        Select makeSelection = new Select(driver.findElement(By.xpath("//select[@name='make']"))); // when "select" appear in the tagName, it is static drop down

        String make = driver.findElement(By.xpath("//option[@id='make_Audi']")).getText().trim(); // there are spaces around make, has to trim or no result could be found
        System.out.println(make);
        makeSelection.selectByValue(make);
//        makeSelection.selectByValue(driver.findElement(By.xpath("//option[@id='make_Audi']")).getText());
//        makeSelection.selectByValue("Audi");
    }

    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","/Users/seanliu/Documents/Web Driver/chromedriver");



        DropDown test = new DropDown();
        test.staticDropDowm();
        test.driver.quit();
    }
}
