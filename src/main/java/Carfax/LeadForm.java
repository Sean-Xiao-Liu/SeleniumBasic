package Carfax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeadForm {

    WebDriver driver;
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

            Thread.sleep(10000);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void isLeadFormEnabled(){
        WebElement Form = driver.findElement(By.xpath("//input[@name='firstName' and @type = 'text']"));

        if(Form.isEnabled() && Form.isDisplayed()){
            System.out.println("Lead form exist");
            sendMessageToDealer();
        } else {
            System.out.println("Lead form is not available/displayed");
        }
    }
}
