package Introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TextBoxAndButton {

    WebDriver driver;
    JavascriptExecutor javascriptExecutor;

    public void invokeBrowser(){

        try {
//            System.setProperty("webdriver.gecko.driver", "/Users/seanliu/Documents/Web Driver/geckodriver");// set up env properties, driver name and location
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(); // create driver object

//        System.setProperty("webdriver.chrome.driver","/Users/seanliu/Documents/Web Driver/chromedriver");
//        driver = new ChromeDriver();

            /** Window settings **/
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();// maximize the window when open a new one
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);


            /** Operation **/
            driver.get("https://www.google.com"); // open url on corresponding browser
            searchThings(); // add click simulation here
            Thread.sleep(5000); // stay on the search result page for 5 sec before close the tab

            System.out.println("The we burl is " + driver.getCurrentUrl());
            System.out.println("The web title is " + driver.getTitle());

//            driver.get("https://beta.carfax.com/cars-for-sale");
//
//            System.out.println(driver.getCurrentUrl());

//        driver.close(); // closing one tab

        } catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        } finally {
            driver.quit(); // closing all tabs
        }
    }

    public void searchThings(){
        try{

            // input "Selenium and search"
            driver.findElement(By.name("q")).sendKeys("Selenium"); // input Selenium into the search blank
            Thread.sleep(2000); // has to add 2 second gap or the search button won't work
            driver.findElement(By.name("btnK")).click(); // find id of click/search button and simulate the user click behavior

            // scroll function
            javascriptExecutor = (JavascriptExecutor)driver;
            javascriptExecutor.executeScript("scroll(0,2000)"); // scroll down + the number actually matters??? can also use element location
        } catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }

    }



    public static void main(String[] args) {

        TextBoxAndButton test = new TextBoxAndButton();
        test.invokeBrowser();

//        System.setProperty("webdriver.gecko.driver","/Users/seanliu/Documents/geckodriver");
//        WebDriver firefoxDriver = new FirefoxDriver();

//        WebDriver chromeDriver = new ChromeDriver();
//        firefoxDriver.get("https//www.google.com");
//        chromeDriver.get("https//www.google.com");
    }
}
