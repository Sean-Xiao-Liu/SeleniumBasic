package carfax.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/** ucl step one page, select make, model and CPO box, enter zip code and click next button**/

public class StepOnePage {

//    private static WebDriver driver = DriverConfiguration.chooseDriver("chrome");
    private static WebDriver driver;

    public StepOnePage(WebDriver driver) {
        this.driver = driver;
    }


    public static void selectMakeModelZipAndClick(){


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
}
