package carfax.pages;




import carfax.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BetaHomePage {
    public BetaHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='hero__button button--green']")
    public WebElement findAUsedCarButton;
}
