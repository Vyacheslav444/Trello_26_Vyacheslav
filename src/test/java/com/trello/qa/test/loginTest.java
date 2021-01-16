package com.trello.qa.test;

import com.trello.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTest extends TestBase {
    @Test
    public void testAtlassianUserLogin() throws InterruptedException {
        logger.info("User name is sb_vip@mail.ru");
        app.user().initLogin();
        app.user().fillLoginForm(new User()
                .setEmail("sb_vip@mail.ru")
                .setPassword("Slavlik444"));
        app.user().confirmLogin();
        Assert.assertTrue(app.user().isAvatarPresent());
        logger.info("Test Passed");
        String screenshot = "src/test/Screenshot/screenshot" + System.currentTimeMillis() + ".png";
        app. user().takeScreenshot(screenshot);

        logger.info("Created screenshot " + screenshot);
    }
}
