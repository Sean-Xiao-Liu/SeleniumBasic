package carfax.pages;

import carfax.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class UCLSignInPage {

    public UCLSignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@class='hero__button button--green' and contains(text(),'Find a Used')]")
    public WebElement findAUsedCarBtn;
    @FindBy(xpath = "//a[@id='header-signin']")
    public WebElement UclSignIn;

    @FindBy(css = "input[name='email'][placeholder='Email Address']")
    public WebElement email;

    @FindBy(css = "input[name='password'][placeholder='Password']")
    public WebElement password;

    @FindBy(css = "button[type='submit'][value='Login']")
    public WebElement signInBtn;

    @FindBy(xpath = "//a[contains(text(),'Create an Account')]")
    public WebElement createAccount;
    @FindBy(xpath = "//a[contains(text(),'Forgot Password?')]")
    public WebElement forgotPassword;

    @FindBy(css = "input[name='email'][placeholder='Enter your email address']")
    public WebElement EnterEmail;

    @FindBy(css = "input[name='password'][placeholder='Enter password']")
    public WebElement EnterPassword;

    @FindBy(css = "input[name='zip'][placeholder='Home Zip']")
    public WebElement zipcode;

    @FindBy(css = "button[type='submit'][value='Send']")
    public WebElement createAccountBtn;
    @FindBy(xpath = "//a[contains(text(),'Login Here')]")
    public WebElement loginHereBtn;

    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Reset Password')]")
    public WebElement resetPassword;

    @FindBy(css = "a[id='header-logout']")
    public WebElement logout;










}
