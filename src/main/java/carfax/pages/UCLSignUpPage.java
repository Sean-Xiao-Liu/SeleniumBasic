package carfax.pages;

import carfax.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class UCLSignUpPage {
    public UCLSignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@class='hero__button button--green' and contains(text(),'Find a Used')]")
    public WebElement findAUsedCarBtn;
    //@FindBy(xpath = "(//a[contains(text(),'Sign Up')])[2]" )
    @FindBy(css = "a#header-signup")
    public WebElement uclSignUpBtn;
    @FindBy(css = "input[name='email'][type='email']")
    public WebElement uclEmail;
    @FindBy(css="input[name='password'][type='password']")
    public WebElement uclPassword;
    @FindBy(css = "input[name='zip'][placeholder='Home Zip']")
    public WebElement uclZipcode;
    @FindBy(css = "button[type='submit'][value='Send']")
    public WebElement uclCreateAccount;
    @FindBy(css = "button#signUpModalBtn")
    public WebElement closeBtn;
    @FindBy(css = "a[id='header-logout']")
    public WebElement logout;
    @FindBy(xpath = "//a[contains(text(),'Login Here')]")
    public WebElement loginHereBtm;
    @FindBy(xpath = "//a[contains(text(),'Forgot Password?')]")
    public WebElement forgotPassword;
    @FindBy(css = "button[type='submit'][value='Login']")
    public WebElement signInBtn;
    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Reset Password')]")
    public WebElement resetPasswordBtn;
}