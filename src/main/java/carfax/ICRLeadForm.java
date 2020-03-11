package carfax;

import introduction.Scroll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

public class ICRLeadForm {

    public WebDriver driver;
    public JavascriptExecutor jse;
    public List<String> allTabs;
    public Scroll scroll = new Scroll();
    public LeadForm leadForm = new LeadForm();


    public void stepOnePage(){


        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        /** setting window size and wait time**/
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();// maximize the window when open a new one
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);


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

        try{
            // input invalid zip code and check the pop up
            zip.sendKeys("22213");
            submit.click();
        } catch (Exception e){
            e.getMessage();
        }
    }

    public void stepTwoPage(){
        // on step 2 page, then click the show me result button
        WebElement showResults = driver.findElement(By.xpath("//button[@class='button large primary-green']"));
        if(showResults.isDisplayed() && showResults.isEnabled()){
            showResults.click();
            System.out.println("show me results button clicked");
        } else {
            System.out.println("sth wrong with the show me results button");
        }

    }


    public void switchTab(){
//        String oldTab = driver.getWindowHandle(); // get current window handle
        allTabs = new LinkedList<>(driver.getWindowHandles());

//        System.out.println(oldTab);
//        for(int i = 0 ; i < allTabs.size() ; i++){
//            System.out.println(allTabs.get(i));
//        }
    }

    public void sendMessageToDealer(){

        try {
            //input first name
            WebElement firstName = driver.findElement(By.name("firstName"));
            firstName.sendKeys("FirstName");

            //input last name
            driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("LastName");

            //input email
            driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("ThisisfakeEmail@fake.com");

            //send message
            driver.findElement(By.xpath("//button[@class='search-submit button large expanded primary-green']")).click();

            Thread.sleep(3000);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



    public void findICR(){

        try {
            stepOnePage();
            Thread.sleep(3000);
            stepTwoPage();
            driver.findElement(By.xpath("//span[contains(text(),'2019 Audi A5 Premium Plus')]")).click();

            switchTab();
            driver.switchTo().window(allTabs.get(allTabs.size()-1));

            scroll.scrollToBottom(driver);

            scroll.scrollToElement(driver.findElement(By.xpath("//div[@class='vdp-container-body']//a[@class='button large'][contains(text(),'View FREE CARFAX Report')]")),driver); // have to switch tab before find element
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='vdp-container-body']//a[@class='button large'][contains(text(),'View FREE CARFAX Report')]")).click();

//            allTabs = new LinkedList<>(driver.getWindowHandles());
            switchTab();

            driver.switchTo().window(allTabs.get(allTabs.size()-1)); // switch to the new tab
//            if(driver.getWindowHandle().equals(allTabs.get(2))){
//                System.out.println("tab switch successful");
//            }


//            scroll.scrollToBottom(driver);


            // wait for iframe
            WebDriverWait wait = new WebDriverWait(driver, 10);

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

//            leadForm.isLeadFormEnabled();

            Thread.sleep(3000);

        } catch (Exception e){
            System.out.println(e.getMessage());

        } finally {
            System.out.println("The test is finished!");
            driver.quit();
        }
    }

    public static void main(String[] args) {
        ICRLeadForm test = new ICRLeadForm();
        test.findICR();

//        for(int i = 2 ; i < 5 ; i++){
//            test.findICR();
//            System.out.println("This is the " + i + " time");
//            i++;
//        }

    }
}
