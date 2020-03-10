package Introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.plaf.TableHeaderUI;

public class DropDown {

    WebDriver driver;


    public void staticDropDown(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.get("https://carfax.com/cars-for-sale");

        driver.findElement(By.xpath("//select[@name='make']")).click();


        // select a make
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

        // find zip box and submit botton
        WebElement zip = driver.findElement(By.xpath("//input[@name='zip']"));
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));


        try{
            // input invalid zip code and check the pop up
            zip.sendKeys("00000");
            submit.click();
            Thread.sleep(2000);
        } catch (Exception e){
            e.getMessage();
        }


        WebElement pop = driver.findElement(By.xpath("//span[@class='title']"));
        WebElement close = driver.findElement(By.xpath("//div[@class='close-button']"));

        if(pop.isDisplayed()){
            close.click();
        }


        /** not working after return to the home page**/
        try{
            if(zip.isDisplayed() && zip.isEnabled()){
                zip.clear();
                zip.sendKeys("22213");
            }
            submit.click();
        } catch (Exception e){
            e.getMessage();
        }




    }


    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","/Users/seanliu/Documents/Web Driver/chromedriver");



        DropDown test = new DropDown();
        test.staticDropDown();

    }
}
