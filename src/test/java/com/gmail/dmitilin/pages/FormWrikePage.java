package com.gmail.dmitilin.pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormWrikePage {

    private WebDriver driver;
    private Random random = new Random();

    public FormWrikePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[contains(text(), 'Very interested')]")
    private WebElement buttonVeryInterested;
    @FindBy(xpath = "//button[contains(text(), 'Just looking')]")
    private WebElement buttonJustLooking;

    @FindBy(xpath = "//button[contains(text(), '1-5')]")
    private WebElement buttonOneToFive;
    @FindBy(xpath = "//button[contains(text(), '6–15')]")
    private WebElement buttonSixToFiveteen;
    @FindBy(xpath = "//button[contains(text(), '16-25')]")
    private WebElement buttonFiveteenToTwentyFive;
    @FindBy(xpath = "//button[contains(text(), '26-50')]")
    private WebElement buttonTwentySixToFifty;
    @FindBy(xpath = "//button[contains(text(), '50+')]")
    private WebElement buttonFiftyPlus;

    @FindBy(xpath = "//button[contains(text(), 'Yes')]")
    private WebElement buttonYes;
    @FindBy(xpath = "//button[contains(text(), 'No')]")
    private WebElement buttonNo;

    @FindBy(xpath = "//button[contains(text(), 'Submit results')]")
    private WebElement buttonSubmitResults;

    @FindBy(xpath = "//button[contains(text(), 'Resend email')]")
    private WebElement buttonResendEmail;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div[1]/div/ul/li[1]/a")
    private WebElement hrefToTwitter;


    public void clickInterestButton() {
        int i = random.nextInt(1);
        choiceOfTwo(i, buttonJustLooking, buttonVeryInterested);
    }

    public void clickOnMembersOfTeam() {
        int i = random.nextInt(4);
        switch (i) {
        case 0:
            buttonOneToFive.click();
            break;
        case 1:
            buttonSixToFiveteen.click();
            break;
        case 2:
            buttonFiveteenToTwentyFive.click();
            break;
        case 3:
            buttonTwentySixToFifty.click();
            break;
        case 4:
            buttonFiftyPlus.click();
        }
    }

    public void clickOnYesOrNoButton() {
        int i = random.nextInt(1);
        choiceOfTwo(i, buttonNo, buttonYes);
    }

    public boolean clickOnSubmitResult() {
        buttonSubmitResults.click();
        return buttonSubmitResults.isDisplayed();
    }

    public boolean clickOnResendEmail() {
        buttonResendEmail.click();
        return buttonResendEmail.isDisplayed();
    }

    private void choiceOfTwo(int i, WebElement button1, WebElement button2) {
        switch (i) {
        case 0:
            button1.click();
            break;
        case 1:
            button2.click();
            break;
        }
    }

    public boolean checkHrefToTwitter() {
        String str = hrefToTwitter.getAttribute("href");
        return "https://twitter.com/wrike".equals(str);
    }

}
