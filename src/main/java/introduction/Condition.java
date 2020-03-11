package introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/** Check if the element is displayed/enabled/selected**/
public class Condition {

    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","/Users/seanliu/Documents/Web Driver/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try{
            driver.get("https://www.facebook.com/"); // open url on corresponding browser
            WebElement firstName = driver.findElement(By.name("firstname"));
            WebElement lastName = driver.findElement(By.name("lastname"));
            WebElement signUpBotton = driver.findElement(By.name("websubmit"));
            WebElement female = driver.findElement(By.xpath("//input[@name = 'sex' and @value = '1']")); // using Xpath to find the element
            WebElement male = driver.findElement(By.xpath("//input[@name = 'sex' and @value = '2']"));




            if(firstName.isDisplayed() && firstName.isEnabled() ){

                System.out.println("The first name box is displayed and enabled");

                firstName.sendKeys("FakeFirstName");
                Thread.sleep(2000); // has to add 2 second gap
            }

            if (lastName.isEnabled() && lastName.isDisplayed()) {

                System.out.println("The last name box is displayed and enabled");

                lastName.sendKeys("FakeLastName");
                Thread.sleep(2000); // has to add 2 second gap
            }



            if(female.isEnabled() && female.isDisplayed()){
                female.click();
                if(female.isSelected()){
                    System.out.println("select gender as female");
                }
                Thread.sleep(2000); // has to add 2 second gap
            }


            if (signUpBotton.isDisplayed() && signUpBotton.isEnabled()){
                signUpBotton.click();
            }





            Thread.sleep(3000);
        } catch (Exception e){
            e.getMessage();
        } finally {
//            driver.close();
        }
    }
}
