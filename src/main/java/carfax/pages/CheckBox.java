package introduction;

import carfax.pages.StepOnePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBox {


    public CheckBox(WebDriver driver){
        this.driver = driver;
    }

//    public WebDriver driver = DriverConfiguration.chooseDriver("chrome");
    public WebDriver driver;
    public StepOnePage stepOnePage;
    public WebDriverWait wait;
    WebElement showResults;
    WebElement noAccident;
    WebElement oneOwner;
    WebElement personalUse;
    WebElement serviceHistory;



    public void checkBoxConfig(){

        wait = new WebDriverWait(driver, 5);
        stepOnePage = new StepOnePage(driver);

        stepOnePage.selectMakeModelZipAndClick();

        showResults = driver.findElement(By.cssSelector("button[class='button large primary-green']"));
        noAccident = driver.findElement(By.xpath("//label[@class='checkbox checkbox-styled checkbox-list-item--label noAccidents']//span[@class='checkbox-list-item--fancyCbx']"));
        oneOwner = driver.findElement(By.xpath("//label[@class='checkbox checkbox-styled checkbox-list-item--label oneOwner']//span[@class='checkbox-list-item--fancyCbx']"));
        personalUse = driver.findElement(By.xpath("(//label[@class='checkbox checkbox-styled checkbox-list-item--label']//span[@class='checkbox-list-item--fancyCbx'])[1]"));
        serviceHistory = driver.findElement(By.xpath("(//label[@class='checkbox checkbox-styled checkbox-list-item--label']//span[@class='checkbox-list-item--fancyCbx'])[2]")); // has same label as personal use, apply number to distinguish

    }

    public void clickNoAccident(){
        noAccident.click();
    }

    public void clickOneOwner(){
        oneOwner.click();
    }

    public void clickPersonalUse(){
        personalUse.click();
    }

    public void clickServiceHistory(){
        serviceHistory.click();
    }

    public void clickShowResults(){
        showResults.click();
    }



    public static void main(String[] args){
    }
}
