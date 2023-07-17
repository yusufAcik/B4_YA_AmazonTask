package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement helloUserName;

    @FindBy(xpath = "(//span[text()='Sign in'])[1]")
    public WebElement signInBtn;

    @FindBy(xpath = "//span[text()='Create a List']")
    public WebElement create_a_list;

    public void getLoginPage(){
        BrowserUtils.hover(helloUserName);
        signInBtn.click();
    }

}
