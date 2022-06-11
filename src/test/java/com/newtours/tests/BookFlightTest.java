package com.newtours.tests;

import com.newtours.pages.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {


private String noOfPassengers;
private String expectedPrice;
    @BeforeTest
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setupParameters(String noOfPassengers,String expectedPrice){
        this.noOfPassengers=noOfPassengers;
        this.expectedPrice=expectedPrice;

    }
    @Test
    public void registrationTestPage(){
        RegistrationPage resgistrationpage= new RegistrationPage(driver);
        resgistrationpage.goTo();
        resgistrationpage.enterUserDetails("selenium","docker");
        resgistrationpage.enterUserCredentials("selenium","docker");
        resgistrationpage.submit();

    }
    @Test(dependsOnMethods = "registrationTestPage")
    public void registrationConfirmationPage(){
    RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
    registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage(){
        FlightDetailsPage flightDetailsPage= new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(noOfPassengers);
        flightDetailsPage.goToFindFightsPage();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage(){
        FindFlightPage findFlightPage= new FindFlightPage(driver);
        findFlightPage.submitFlightPage();
        findFlightPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage(){
        FlightConfirmationPage flightConfirmationPage= new FlightConfirmationPage(driver);
        String actualPrice=flightConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice,expectedPrice);

    }

}
