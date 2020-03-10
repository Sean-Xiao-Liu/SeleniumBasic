package Introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenNewTab {

    /** open page in a new tab **/
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","/Users/seanliu/Documents/Web Driver/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try{
            // open link in new tab
            driver.get("https://www.google.com"); // open url on corresponding browser
            String selectLinkOpeninNewTab = Keys.chord(Keys.COMMAND,Keys.RETURN); // for windows, using Keys.CONTROL instead of Keys.COMMAND
            driver.findElement(By.linkText("About")).sendKeys(selectLinkOpeninNewTab); // il
            Thread.sleep(3000);


            driver.get("https://www.google.com"); // open url on corresponding browser
            driver.findElement(By.name("q")).sendKeys("Selenium"); // input Selenium into the search blank
            Thread.sleep(2000); // has to add 2 second gap or the search button won't work
            driver.findElement(By.name("btnK")).click(); // find id of click/search button and simulate the user click behavior
            Thread.sleep(2000);
        } catch (Exception e){
            e.getMessage();
        } finally {
            driver.quit();
        }
    }
}
