package com.amazon.pages;

import com.amazon.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "ap_email")
    public WebElement emailInput;

    @FindBy (id="continue")
    public WebElement continiueBtn;

    @FindBy (id="ap_password")
    public WebElement passwordInput;

    @FindBy(id = "signInSubmit")
    public WebElement signInSubmitBtn;

    public void login(){
        getLoginPage();
        emailInput.sendKeys(ConfigurationReader.get("email"));
        continiueBtn.click();
        passwordInput.sendKeys(ConfigurationReader.get("password"));
        signInSubmitBtn.click();
    }


}
