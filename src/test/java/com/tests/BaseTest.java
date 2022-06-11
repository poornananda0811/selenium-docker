package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;
    @BeforeTest
    public void setUp(ITestContext context) throws MalformedURLException {
         //BROWSER===>Chrome/Firefox
        // HUB_HOST==> localHost /10.0.1.3 / hostname
        String host="localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc=DesiredCapabilities.firefox();
        }
        else{
            dc= DesiredCapabilities.chrome();
        }

        if(System.getProperty("HUB_HOST")!=null ){
        host=System.getProperty("HUB_HOST");}
        String completeURL="http://"+host+":4444/wd/hub";
        dc.setCapability("name",context.getCurrentXmlTest().getName());
        this.driver=new RemoteWebDriver(new URL(completeURL), dc);

    }

    @AfterTest
    public void quitBrowser(){
        this.driver.quit();
    }
}
