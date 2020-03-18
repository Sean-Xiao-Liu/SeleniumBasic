package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class SwitchWindow {

    WebDriver driver = DriverConfiguration.chooseDriver("chrome");
    public static List<String> allTabs; // the object type has to be String to fit the window method

    public void switchBetweenTabs() throws InterruptedException{
        driver.get("https://www.facebook.com/");
        WebElement instagram = driver.findElement(By.xpath("//a[contains(text(),'Instagram')]"));
        instagram.click(); // click the instagram, will open in a new tab
        allTabs = new LinkedList<>(driver.getWindowHandles()); // save all open tabs in linked list
        driver.switchTo().window(allTabs.get(allTabs.size()-1));
        System.out.println("Now switch to "+driver.getTitle());
        driver.switchTo().window(allTabs.get(0));
        System.out.println("Now switch to "+driver.getTitle());
        Thread.sleep(5000);
        DriverConfiguration.closeDriver();
    }

    public static void main(String[] args)throws InterruptedException {
        SwitchWindow test =new SwitchWindow();
        test.switchBetweenTabs();
        for(int i = 0 ; i < allTabs.size() ; i++){
            System.out.println(allTabs.get(i));
        }
    }

}
