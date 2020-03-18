package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/** The action object is used to simulate the behavior of mouse and keyboard**/
public class ActionExample {

    WebDriver driver = DriverConfiguration.chooseDriver("chrome");
    Actions actions = new Actions(driver);

    public void moveMouseToElement() throws InterruptedException{
        driver.get("https://www.amazon.com/");

        // move to element method
        actions.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
        Thread.sleep(5000);
//        actions.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform(); // always add build and perform method to make complete action
//        Thread.sleep(5000);
    }

    public void clickInputBoxAndSendKeys() throws InterruptedException{

        // keyDown(Keys.SHIFT) means press shift key while send keys
        // will make all the input keys become CAPITALS
        System.out.println("move to search box");
        actions.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("water").build().perform(); // always add build and perform method to make complete action
        Thread.sleep(5000);
        System.out.println("right click");
        actions.contextClick().build().perform(); // right click the input context
        Thread.sleep(5000);
    }


    public static void main(String[] args) throws InterruptedException{
        ActionExample test = new ActionExample();
        test.moveMouseToElement();
        test.clickInputBoxAndSendKeys();
        System.out.println("Test finished and succeed");
        test.driver.close();
    }
}
