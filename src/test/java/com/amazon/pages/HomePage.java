package com.amazon.pages;

import com.amazon.utilities.ConfigurationReader;
import org.testng.Assert;

public class HomePage extends BasePage{

    public void verifyLogin(){
        Assert.assertTrue(helloUserName.getText().contains(ConfigurationReader.get("username")));

    }
}
