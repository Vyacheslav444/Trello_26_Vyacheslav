package com.trello.qa.test;

import com.trello.qa.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeAvatar extends TestBase {
    @BeforeMethod
    public  void preconditions() throws InterruptedException {
        if(!app.user().isAvatarPresent()){
            app.user().initLogin();
            app.user().fillLoginForm(new User()
                    .setEmail(app.setEmail())
                    .setPassword(app.setPassword()));
            app.user().confirmLogin();
        }
    }
    @Test
    public void testChangeAvatar() {
        app.user().clickOnTheAvatar();
        app.user().goToProfile();
        app.user().goToAtlassianAcc();
        app.user().changeAvatar("C:\\Users\\Slavlik\\Documents\\GitHub\\Trello_26_Vyacheslav\\src\\test\\resources\\1.jpg");
        Assert.assertTrue(app.user().isElementPresent(By.xpath("//*[contains(.,'Avatar added')]")));
        logger.info("Test Passed");
        String screenshot = "src/test/Screenshot/screenshot" + System.currentTimeMillis() + ".png";
        app. user().takeScreenshot(screenshot);

        logger.info("Created screenshot " + screenshot);
        app.user().closeWindow();


    }
}
