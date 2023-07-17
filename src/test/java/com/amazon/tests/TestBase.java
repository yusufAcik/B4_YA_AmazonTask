package com.amazon.tests;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected Actions action;
    protected WebDriverWait wait;
    protected ExtentReports report;// create html report
    protected ExtentHtmlReporter htmlReporter;

    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){
        report=new ExtentReports();
        String projectPath = System.getProperty("user.dir");
        String path = projectPath+"/test-output/report.html";
        htmlReporter=new ExtentHtmlReporter(path);
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("Amazon E2E Test");
        report.setSystemInfo("Enviroment","e corners web site");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS","os.name");
        report.setSystemInfo("Test Engineer","Yusuf");

    }

    @BeforeMethod
    public void setUp() {
        driver= Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,10);
        action=new Actions(driver);
        driver.get(ConfigurationReader.get("url"));
    }

    @AfterTest
    public void tearDownTest(){
        report.flush();
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
       if(result.getStatus()==ITestResult.FAILURE){
           extentLogger.fail(result.getName());
           String screenShotPath= BrowserUtils.getScreenshot(result.getName());
           extentLogger.addScreenCaptureFromPath(screenShotPath);
           extentLogger.fail(result.getThrowable());
       }
        Thread.sleep(2000);
        Driver.closeDriver();
    }
}
