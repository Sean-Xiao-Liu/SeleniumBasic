package carfax.pages;

import carfax.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LeadFormPage {
    public LeadFormPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//input[@name='firstName'][@placeholder='First Name'])[2]")
    public WebElement firstName;
    @FindBy(xpath = "(//input[@name='lastName'][@placeholder='Last Name'])[2]")
    public WebElement lastName;
    @FindBy(xpath = "(//input[@name='zip'])[2]")
    public WebElement zipCode;
    @FindBy(xpath = "(//input[@type='email'][@name='email'])[2]")
    public WebElement email;
    @FindBy(xpath = "(//input[@name='phone'][@placeholder='Phone Number'])[2]")
    public WebElement phoneNumber;
    @FindBy(xpath = "(//span[@class='checkbox-list-item--fancyCbx'])[5]")
    public WebElement isThisVehicleAvailable;
    @FindBy(xpath = "(//span[@class='checkbox-list-item--fancyCbx'])[6]")
    public WebElement whatPaymentTermsAreAvailable;
    @FindBy(xpath = "(//span[@class='checkbox-list-item--fancyCbx'])[7]")
    public WebElement whenCanITestDriveThisVehicle;
    @FindBy(xpath = "(//a[@class='dealer-contact-add-note' and contains(text(),'Add a personal note(optional)')])[2]")
    public WebElement personalNote;
    @FindBy(xpath = "(//button[@type='submit'][@class='search-submit button large expanded primary-green'])[2]")
    public WebElement sendMessage;
    @FindBy (xpath = "(//textarea[@name='note'][@class='ui-input form-control input-sm dealer-contact-note'])[2]")
    public WebElement noteField;
}
