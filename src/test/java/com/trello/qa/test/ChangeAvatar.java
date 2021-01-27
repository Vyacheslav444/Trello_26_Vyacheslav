package com.trello.qa.test;

import com.trello.qa.model.User;
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
    public void testChangeAvatar(){
        app.user().clickOnTheAvatar();
        app.user().goToProfile();
        app.user().goToAtlassianAcc();
        app.user().chengeAvatar("C:\\Users\\Slavlik\\Documents");


    }
}
