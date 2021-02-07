package com.trello.qa.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBoardsTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!app.user().isAvatarPresent()) {
            app.user().login();
        }
    }

    @Test
    public void DelBoardsTest() throws InterruptedException {
        if(app.delBoard().getCountBoard()>4){
            app.delBoard().CleanAll();
      }

    }
}