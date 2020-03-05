package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


/** browser UI not showing up**/
public class HeadlessTesting {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","/Users/seanliu/Documents/Web Driver/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true); //set headless so the browser won't show up
//        chromeOptions.addArguments("--headless"); // has same effect as .setHeadless

        WebDriver driver = new ChromeDriver(chromeOptions); // create driver object with headless option

        driver.get("https://www.carfax.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
//        System.out.println(driver.getPageSource());
        System.out.println(driver.getWindowHandle());

//        driver.findElement(By.linkText("cars-for-sale")).click();
//        System.out.println(driver.getCurrentUrl());
        driver.close();


    }
}
