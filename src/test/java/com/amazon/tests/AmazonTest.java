package com.amazon.tests;

import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.YourListPage;
import org.testng.annotations.Test;

public class AmazonTest extends TestBase{
/** Amazon E2E Task
 *  go to amazon web page
 *  if there are cookies accept cookies
 *  log in with your own valid credential
 *  Verify that login is successful
 *  Create a new list from Account and Lists
 *  Select any category from the section tab next to the search box
 *  Verify that category  is selected
 *  Write any product to search box and click
 *  Verify that the result contains product items
 */

LoginPage loginPage;
HomePage homePage;
YourListPage yourListPage;
@Test
    public void amazonTest1(){

    loginPage=new LoginPage();
    homePage=new HomePage();
    yourListPage=new YourListPage();

    extentLogger=report.createTest("Amazon e2e test");
    extentLogger.info("Login with predefined credentials");
    loginPage.login();
    extentLogger.info("Verify that login is successful");
    homePage.verifyLogin();
    extentLogger.info("Create a new list from Account and Lists");
    yourListPage.createAList();
}
}
