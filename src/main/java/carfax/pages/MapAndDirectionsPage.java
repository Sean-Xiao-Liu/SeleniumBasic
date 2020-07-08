package carfax.pages;

import carfax.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MapAndDirectionsPage {

    public MapAndDirectionsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "a#_automation_test_map_and_directions")
    public WebElement mapAndDirectionVDP;

    @FindBy(css = "span.dealer-directions-info-title")
    public WebElement dealerName;

    @FindBy(xpath = "//i[@class='fa fa-phone']")
    public WebElement phoneNumberSign;

    @FindBy(xpath = "//i[@class='fa fa-map-marker']")
    public WebElement locationSign;

    @FindBy(css = "input[name='address']")
    public WebElement addressField;

    @FindBy(css = "input[name='city']")
    public WebElement cityField;

    @FindBy(xpath = "//select[@name='state']/option")
    public WebElement state;

    @FindBy(css = "input[name='zip']")
    public WebElement zipCode;

    @FindBy (css = "button[value='Get Directions']")
    public WebElement getDirections;

    @FindBy(css = "i[class='fa fa-mobile']")
    public WebElement mobileSign;




}
