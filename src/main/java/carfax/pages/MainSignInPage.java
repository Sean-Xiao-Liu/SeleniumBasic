package carfax.pages;


import carfax.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class MainSignInPage {
    public MainSignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@name='email'][@type='email']")
    public WebElement email;
    //@FindBy(xpath = "//a[contains(text(),'Create an Account')]")
    @FindBy(xpath = "//a[@data-reactid='39' and contains(text(),'Sign In')]")
    public WebElement signInHeader;
}