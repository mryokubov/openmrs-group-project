package openmrs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.testng.asserts.SoftAssert;
import utils.ConfigReader;

public class LoginPage {

    public WebDriver driver;
    public SoftAssert softAssert;

    public LoginPage(WebDriver driver,SoftAssert softAssert){
        this.softAssert=softAssert;
        this.driver=driver;
        PageFactory.initElements(driver,this); //142
    }

    //VARIABLES///////////////////////////////////////////////////////////////////////////////////////////

    @FindBy(id = "username")
    private  WebElement id;

    @FindBy(id="password")
    private  WebElement passW;

    @FindBy(id="Inpatient Ward")
    private  WebElement location;

    @FindBy(id="loginButton")
    private  WebElement loginBtn;

    @FindBy(id="sessionLocationError")
    private WebElement errorMessage;

    //METHODS//////////////////////////////////////////////////////////////////////////////////////////////

    public void visitLoginPage(){
        driver.get(ConfigReader.getProperty("url"));
    }

    public void Login(){
        id.sendKeys(ConfigReader.getProperty("userName"));
        passW.sendKeys(ConfigReader.getProperty("passWord"));
        loginBtn.click();
        softAssert.assertEquals(errorMessage.getText().trim(),"You must choose a location!","Location error message is wrong");
        location.click();
        loginBtn.click();

    }
}
