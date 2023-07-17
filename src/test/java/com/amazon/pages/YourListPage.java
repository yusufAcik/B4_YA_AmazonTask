package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;

public class YourListPage extends BasePage{

    public void createAList(){
        BrowserUtils.hover(helloUserName);
        create_a_list.click();
    }
}
