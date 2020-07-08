package carfax.pages;

import carfax.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendToMyPhonePage {

    public SendToMyPhonePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//button[contains(text(),'Send to my Phone ')])[1]")
    public WebElement sendToMyPhoneHeader;


    @FindBy(css = "input[name='phone'][type='tel'][placeholder='Enter your mobile phone #']")
    public WebElement enterYourMobilePhone;

    @FindBy(css = "button[type='submit'][value='Send']")
    public WebElement sendBtn;


}
