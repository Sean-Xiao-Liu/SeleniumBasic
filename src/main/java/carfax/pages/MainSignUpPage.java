package carfax.pages;

import carfax.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainSignUpPage {

    public MainSignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }


    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    public WebElement signUpHeader;

    @FindBy(css="input[type='email'][name='username']")
    public WebElement email;

    @FindBy(css = "input[type='password'][name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[contains(@class,'button-primary')]")
    public WebElement signUpBtn;

    @FindBy(xpath = "//div[@class='sso-password-show'] [contains(text(),'Show')]")
    public WebElement showBtn;

    @FindBy(xpath = "//div[@class='sso-password-show'] [contains(text(),'Hide')]")
    public WebElement hideBtn;





    public void logIn(String emailStr,String passwordStr){
        email.sendKeys(emailStr);
        password.sendKeys(passwordStr);
        signUpBtn.click();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),4);
        wait.until(ExpectedConditions.titleIs("CARFAX™ - Single Sign On"));
    }
}