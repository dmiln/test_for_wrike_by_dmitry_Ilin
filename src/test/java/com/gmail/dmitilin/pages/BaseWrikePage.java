package com.gmail.dmitilin.pages;


import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseWrikePage {

    private WebDriver driver;

    public BaseWrikePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy /*(xpath = "//button[contains(text(), 'Get started for free')]")*/
            /*(className = "wg-header__free-trial-button")*/
            /*Не получилось подобрать нормальный локатор*/
            (xpath = "/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button")
    private WebElement getStartedForFreeButton;

    @FindBy (className = "modal-form-trial__input")
    private WebElement formEnterYourBussinessEmail;

    @FindBy (className = "modal-form-trial__submit")
    private WebElement createMyWrikeAccount;

    public void clickStartedButton () {
        getStartedForFreeButton.click();
    }

    public void clickButtonCreateMyWrikeAccount(){
        createMyWrikeAccount.click();
    }

    public void fillFormEnterYourBussinessEmail () {
        String string = generateRandomLogin();
        formEnterYourBussinessEmail.sendKeys(string + "+wpt@wriketask.qaa");
    }


    private String generateRandomLogin() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            char letter = (char)(random.nextInt(26) + 'a');
            stringBuilder.append(letter);
        }
        return stringBuilder.toString();
    }
}
