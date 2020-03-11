package introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/** Navigation from one page to another page**/
public class Navigation {

    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","/Users/seanliu/Documents/Web Driver/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try{

            // open the page of google
            driver.get("https://www.google.com");
            Thread.sleep(2000); // pause for 2 sec

            // navigate to carfax
            driver.navigate().to("https://www.carfax.com"); // to method are overloaded, can take both String url and URL url, https://www.selenium.dev/selenium/docs/api/java/index.html
            Thread.sleep(2000); // pause for 2 sec

            // back to google
            driver.navigate().back();
            Thread.sleep(2000); // pause for 2 sec

            // forward to carfax
            driver.navigate().forward();
            Thread.sleep(2000); // pause for 2 sec

            // refresh the page
            driver.navigate().refresh();
            Thread.sleep(2000);


        } catch (Exception e){
            e.getMessage();
        } finally {
            driver.close();
        }

    }
}
