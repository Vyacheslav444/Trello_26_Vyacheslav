package com.trello.qa.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBoardsTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!app.user().isAvatarPresent()){
            app.user().login();
        }
    }
    @Test
    public void DelBoardsTest() throws InterruptedException {
        if(app.delBoard().getCountBoard()>3){
            app.delBoard().CleanAll();
        }
        app.delBoard().DelWhile();
       app.delBoard().clickByBoard();
       //[class='boards-page-board-section-list-item']
        //[class='board-header-btn mod-show-menu js-show-sidebar']
        app.delBoard().clickByShowMenu();
       //[class='board-menu-navigation-item-link js-open-more']
        app.delBoard().clickByMore();
        //[class='board-menu-navigation-item-link js-close-board']
        app.delBoard().closeBoard();
        //[class='js-confirm full nch-button nch-button--danger']
        app.delBoard().ByClose();
        //[class='quiet js-delete']
        app.delBoard().PermDeleteBoard();
        //[class='js-confirm full nch-button nch-button--danger']
        app.delBoard().Delete();
        //[class='nch-icon _2_Q6rrYCFblD3M _3Dk1GPoKnJxuep _1iYprMLTeGpyW9']
        app.delBoard().HomeButton();

    }
}
