package com.gmail.dmitilin.tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gmail.dmitilin.pages.BaseWrikePage;
import com.gmail.dmitilin.pages.FormWrikePage;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class WrikeTest {

    private static WebDriver driver;
    private static BaseWrikePage baseWrikePage;
    private static FormWrikePage formWrikePage;



    @BeforeClass
    public static void setup(){

        File file = new File("chrome_driver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        baseWrikePage = new BaseWrikePage(driver);
        formWrikePage = new FormWrikePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.wrike.com");
    }

    @Test
    public void scenarioTests(){
        baseWrikePage.clickStartedButton();
        baseWrikePage.fillFormEnterYourBussinessEmail();
        baseWrikePage.clickButtonCreateMyWrikeAccount();
        assertFalse("We stayed on the same page!!!", "https://www.wrike.com".equals(driver.getCurrentUrl()));

        formWrikePage.clickInterestButton();
        formWrikePage.clickOnMembersOfTeam();
        formWrikePage.clickOnYesOrNoButton();
        assertFalse("your answers aren't submitted", formWrikePage.clickOnSubmitResult());

        assertFalse("Resend email not pressed", formWrikePage.clickOnResendEmail());

        assertTrue("The link is not correct", formWrikePage.checkHrefToTwitter());

    }

}
