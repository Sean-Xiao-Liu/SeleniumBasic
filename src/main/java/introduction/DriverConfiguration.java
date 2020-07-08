package introduction;

import carfax.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverConfiguration {

    public DriverConfiguration(){};

    private static WebDriver driver;

    public static WebDriver chooseDriver(String name){

        switch (name){
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "chromeHeadless" :
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "firefoxHeadless":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                break;
            case "safari":
                if(System.getProperty("os.name").toLowerCase().contains("windows"))
                    throw  new WebDriverException("You are using Windows as OS which doesn't support Safari");
                WebDriverManager.getInstance(SafariDriver.class).setup();
                driver= new SafariDriver();
                break;
        }

        return driver;
    }


    public static WebDriver getDriver(){
        String name = ConfigurationReader.get("browser");
        System.out.println("The chosen browser is : " + name);
        switch (name){
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "chromeHeadless" :
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "firefoxHeadless":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                break;
            case "safari":
                if(System.getProperty("os.name").toLowerCase().contains("windows"))
                    throw  new WebDriverException("You are using Windows as OS which doesn't support Safari");
                WebDriverManager.getInstance(SafariDriver.class).setup();
                driver= new SafariDriver();
                break;
        }

        return driver;
    }

    public static void closeDriver(){
        if( driver != null){
            driver.quit();
            driver = null;
        }
    }
}

