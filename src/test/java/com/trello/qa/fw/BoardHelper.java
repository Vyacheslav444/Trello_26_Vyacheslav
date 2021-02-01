package com.trello.qa.fw;

import com.trello.qa.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void create() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    public void createBoard() {
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    public void addBoard(User user) {
        if(user.getWorlds()!=null){
            type(By.cssSelector("[data-test-id='create-board-title-input']"),user.getWorlds());
        }

    }
    public void teamVisible() {
        click(By.cssSelector("[class='nch-icon _2_Q6rrYCFblD3M z53beXNiDPJAy2 _3IkOtLubuAF6kK _1_7ndZKXfF_Z1n']"));
    }
    public void boardPrivate() {
        click(By.cssSelector("[class='_2FCfpANq784raH LrSeigrVRlrVHb']"));
    }
    public void createBoardButton() {
        clickByXpath("//button[.='Create Board']");
    }


    public boolean isNewBoardPresent() throws InterruptedException {
        Thread.sleep(5000);
        return isElementPresent(By.cssSelector("[type='submit']"));

    }
}
