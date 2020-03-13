package carfax;

import introduction.Scroll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ICRLeadForm {

    public WebDriver driver;
    public JavascriptExecutor jse;
    public List<String> allTabs;
    public Scroll scroll = new Scroll();
    public LeadForm leadForm = new LeadForm();
    public WebDriverWait wait;


    public void driverSelection(String driverName){
       switch (driverName){
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
    }

    public void stepOnePage(){

        /** setting window size and wait time**/
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();// maximize the window when open a new one
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // wait 10 sec before throwing "No Such Element Exception"
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);


        driver.get("https://carfax.com/cars-for-sale");


        // select a make
        driver.findElement(By.xpath("//select[@name='make']")).click();
        Select makeSelection = new Select(driver.findElement(By.xpath("//select[@name='make']"))); // when "select" appear in the tagName, it is static drop down
        String make = driver.findElement(By.xpath("//option[@id='make_Audi']")).getText().trim(); // there are spaces around make, has to trim or no result could be found
        System.out.println("The make I selected is " + make);
        makeSelection.selectByValue(make);

        // select a model
        Select modelSelection = new Select(driver.findElement(By.xpath("//select[@name='model']")));
        String model = driver.findElement(By.xpath("//option[@id='model_A5']")).getText().trim();
        System.out.println("The model I selected is " + model);
        modelSelection.selectByValue(model);

        // check if the CPO box is available, click it if possible
        WebElement cpo = driver.findElement(By.xpath("//span[@class='checkbox-list-item--fancyCbx']"));

        if(cpo.isDisplayed() && cpo.isEnabled()){
            cpo.click();
        }

        // find zip box and submit button
        WebElement zip = driver.findElement(By.xpath("//input[@name='zip']"));
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));

        zip.sendKeys("22213");
        submit.click();
    }

    public void stepTwoPage() throws InterruptedException {
        // on step 2 page, then click the show me result button
        WebElement showResults = driver.findElement(By.cssSelector("button[class='button large primary-green']"));
//        WebElement showResults = driver.findElement(By.cssSelector("div.main-wrapper div.spa-container:nth-child(1) div.div-ui-view:nth-child(2) div.home:nth-child(1) div.top-section div.row.align-center.align-middle.home-search-row:nth-child(3) div.column:nth-child(1) div.searchForm-wrapper.homepage div.four-pillar-form.form-padding footer.row.align-middle div.small-12.medium-8.medium-order-2.align-middle.float-right.columns > button.button.large.primary-green"));

        wait = new WebDriverWait(driver, 2); // Explicit wait, wait for Expected Condition
      //  if(showResults.isDisplayed() && showResults.isEnabled()){
// wait.until(ExpectedConditions.elementToBeClickable(showResults));
        Thread.sleep(2000);
            showResults.click();
            System.out.println("show me results button clicked");
      //  } else {
           // System.out.println("sth wrong with the show me results button");
     //   }
    }


    public void switchTab(){
        // get a list of all current handles available
        allTabs = new LinkedList<>(driver.getWindowHandles());
    }

    public void sendMessageToDealer() throws ElementNotVisibleException,ElementNotSelectableException{

            //input first name
            WebElement firstName = driver.findElement(By.name("firstName"));
            firstName.sendKeys("FirstName");

            //input last name
            driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("LastName");

            //input email
            driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("ThisisfakeEmail@fake.com");

            //send message
            driver.findElement(By.xpath("//button[@class='search-submit button large expanded primary-green']")).click();
    }



    public void findICR() throws ElementNotVisibleException, ElementNotSelectableException, InterruptedException {

            stepOnePage();
            stepTwoPage();
            driver.findElement(By.xpath("//span[contains(text(),'2019 Audi A5 Premium Plus')]")).click();

            switchTab();
            driver.switchTo().window(allTabs.get(allTabs.size()-1));

            scroll.scrollToBottom(driver);
            scroll.scrollToElement(driver.findElement(By.xpath("//h4[@class='sellerDescription-title false false']")),driver);

            scroll.scrollToElement(driver.findElement(By.xpath("//div[@class='vdp-container-body']//a[@class='button large'][contains(text(),'View FREE CARFAX Report')]")),driver); // have to switch tab before find element
            driver.findElement(By.xpath("//div[@class='vdp-container-body']//a[@class='button large'][contains(text(),'View FREE CARFAX Report')]")).click();

            switchTab();

            driver.switchTo().window(allTabs.get(allTabs.size()-1)); // switch to the new tab


            // wait for iframe

//            WebDriverWait wait = new WebDriverWait(driver, 10);

            //Find frame or iframe and switch
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("uclLeadFrame"));

            scroll.scrollToElement(driver.findElement(By.xpath("//span[@class='dealer-contact-title false']")),driver);

            WebElement Form = driver.findElement(By.xpath("//input[@name='firstName' and @type = 'text']"));

            if(Form.isEnabled() && Form.isDisplayed()){
                System.out.println("Lead form exist");
//                leadForm.sendMessageToDealer();
                sendMessageToDealer();
            } else {
                System.out.println("Lead form is not available/displayed");
            }
Thread.sleep(10000);
            System.out.println("The test is finished!");
            driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {

        List<String> driverNamesList = new ArrayList<>();
        driverNamesList.add("chrome");
//        driverNamesList.add("firefox");
//        driverNamesList.add("safari");
//        driverNamesList.add("chromeHeadless");
//        driverNamesList.add("firefoxHeadless");

        ICRLeadForm test = new ICRLeadForm();


        // ues for loop to
        for(int i = 0; i < driverNamesList.size() ; i++){
            test.driverSelection(driverNamesList.get(i));
            test.findICR();
        }



    }
}
