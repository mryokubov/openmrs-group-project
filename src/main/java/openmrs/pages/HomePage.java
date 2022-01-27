package openmrs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class HomePage {

//    private WebDriver driver;  not needed because it has no use in this specific class/page and
    // the Webdriver argument inside the constructor gets filled in with the BrowserDriver classes instantiation of chromedriver and
    //gets put inside the PageFactories constructor.
    public SoftAssert softAssert;

    public HomePage(WebDriver driver,SoftAssert softAssert){
        this.softAssert= softAssert;
//        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //VARIABLES///////////////////////////////////////////////////////////////////////////////////////////

//    @FindBy(className = "nav-item identifier")
//    private WebElement className; CLASSNAME CANNOT BE USED

    @FindBy(id = "does not exist")
    private WebElement nonExistentElement; // A NONEXISTENT ELEMENT CAN BE USED AS LONG AS IT IS NOT CLASS NAME

    @FindBy(xpath = "//li[@class='nav-item identifier']")
    private WebElement admin;

    @FindBy(id = "selected-location")
    private WebElement iW;

    @FindBy(linkText = "Logout")
    private WebElement logOut;

    @FindBy(xpath = "//a[contains(@id,'referenceapplication')][1]")
    private WebElement patientRegisterBtn;

    @FindBy(xpath = "//div[@id='apps']/a")
    private List<WebElement> tabs;

    String[] tabsArray = {"Find Patient Record", "Active Visits", "Register a patient",
            "Capture Vitals", "Appointment Scheduling", "Reports", "Data Management",
            "Configure Metadata", "System Administration"};

    @FindBy(xpath = "//a[contains(@id,'coreapps-activeVisit')][1]")
    private WebElement findPatientTab;

    //METHODS/////////////////////////////////////////////////////////////////////////////////////////////

    public void verifyTopTabs(){
        softAssert.assertTrue(admin.isDisplayed(),"admin tab is not displayed");
        softAssert.assertTrue(iW.isDisplayed(),"IW tab is not displayed");
        softAssert.assertTrue(logOut.isDisplayed(),"logout button is not displayed");
    }

    public void verifyBottomTabs() {
        for (int i = 0; i < tabs.size(); i++) {
            softAssert.assertEquals(tabs.get(i).getText().trim(), tabsArray[i],"Verification of home tabs went wrong");
        }
    }

    public void registerClick(){
        softAssert.assertTrue(patientRegisterBtn.isEnabled(),"Patient registration button is not enabled");
        patientRegisterBtn.click();
    }

    public void findPatient(){
        findPatientTab.click();
    }
}
