package openmrs;

import openmrs.pages.HomePage;
import openmrs.pages.LoginPage;
import openmrs.pages.PatientPage;
import openmrs.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserDriver;
import utils.ScanQ;

public class PatientRegistrationTests {

    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeMethod
    public void driverSetup(){
        driver = BrowserDriver.getDriver();
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void driverQuit(){
        BrowserDriver.quitBrowser();
        System.out.println("The Test has ENDED!!!");
    }

    @Test
    public void test() throws Exception{
        LoginPage loginPage = new LoginPage(driver, softAssert);
        loginPage.visitLoginPage();
        loginPage.Login();
        HomePage homePage = new HomePage(driver, softAssert);
        homePage.verifyTopTabs();
        homePage.verifyBottomTabs();
        homePage.registerClick();
        RegistrationPage registrationPage = new RegistrationPage(driver, softAssert);
        registrationPage.patientsNameSet();
        registrationPage.nextBottonClick();
        registrationPage.genderSelect();
        registrationPage.nextBottonClick();
        registrationPage.birthDateSelect();
        registrationPage.nextBottonClick();
        registrationPage.addressSelect();
        registrationPage.nextBottonClick();
        registrationPage.phoneNumberSelect();
        registrationPage.nextBottonClick();
        registrationPage.relationTabSelect();
        registrationPage.nextBottonClick();
        registrationPage.patientTabsVerify();
        registrationPage.confirmClick();
        Thread.sleep(3000);
        PatientPage patientPage = new PatientPage(driver,softAssert);
        Thread.sleep(1000);
        patientPage.enterStickyNote();
        Thread.sleep(3000);
        patientPage.registrationPageTabsCheck();
        Thread.sleep(3000);
        patientPage.goHome();
        homePage.findPatient();
        patientPage.searchPatientBox();
        patientPage.logOut();
//        ScanQ.scanTest();
        softAssert.assertAll();
    }
}
