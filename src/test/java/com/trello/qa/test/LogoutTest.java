package com.trello.qa.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        if(!app.user().isAvatarPresent()){
            app.user().login();
        }
    }
    @Test
    public void logOutTest() throws InterruptedException {
        app.user().clickLogOutButton();
        //app.user().pause(3000);
        //Assert.assertFalse(app.user().isElementPresent(By.cssSelector("[href='signup']")));
    }
}
