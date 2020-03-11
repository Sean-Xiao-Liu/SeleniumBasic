package introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Table {

    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","/Users/seanliu/Documents/Web Driver/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://beta.carfax.com/vehicle/1G4GD5G30FF136789");


        try{
            WebElement showPriceHistoryBotton = driver.findElement(By.xpath("(//a[@class = 'show price-history-open'])[2]")); // multiple match of the xpath, so add parentheses around normal expression and select [2]
            Thread.sleep(3000);

            if(showPriceHistoryBotton.isDisplayed() && showPriceHistoryBotton.isEnabled()){
                showPriceHistoryBotton.click();
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{ // Why can't get row and column numbers in this case???
            WebElement table = driver.findElement(By.xpath("//table[@class = 'show price-history-table']"));

            // count number of rows
            WebElement rows = driver.findElement(By.xpath("//table[@class = 'show price-history-table']/tbody"));
            List<WebElement> rowsList = rows.findElements(By.tagName("tr"));

//            // count number of columns
//            WebElement columns = driver.findElement(By.xpath("//table[@class = 'show price-history-table']/tbody/tr"));
//            List<WebElement> columnList = columns.findElements(By.tagName("th")); // th is the header of the table

            // enforce to find the column number by using td, the column tag
            WebElement columns = driver.findElement(By.xpath("(//table[@class = 'show price-history-table']/tbody/tr)[2]")); // select the second row so the tag would contain td
            List<WebElement> columnList = columns.findElements(By.tagName("td")); 


            System.out.println("The table contains " + rowsList.size() + " rows.");
            System.out.println("The table contains " + columnList.size() + " columns.");


        } catch (Exception e){
            System.out.println(e.getMessage());
        }





//        try{
//
//            WebElement table = driver.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr"));
//            if(table.isDisplayed()){
//                System.out.println("The table is displayed");
//                System.out.println("The size of table is " + table.getSize());
//                System.out.println("The width of table is " + table.getRect().width);
//                System.out.println("The height of table is " + table.getRect().height);
//                Thread.sleep(3000);
//            }
//
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//
//        WebElement firstWord = driver.findElement(By.xpath("//table[@class = 'table table-striped']//tr[1]//td[1]//strong")); // tr is the first row while td is the first column of the table



        driver.close();

    }
}
