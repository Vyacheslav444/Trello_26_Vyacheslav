package com.trello.qa.test;

import com.trello.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCreateBoard extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!app.user().isAvatarPresent()){
            app.user().login();
        }
    }

     @Test
    public void testCreateNewBoard() throws InterruptedException {
         app.board().create();
         app.board().createBoard();
         app.board().addBoard(new User()
                 .setWorlds("New board"));
         app.board().teamVisible();
         app.board().boardPrivate();
         app.board().createBoardButton();


         Assert.assertTrue(app.board().isNewBoardPresent());


     }



}
