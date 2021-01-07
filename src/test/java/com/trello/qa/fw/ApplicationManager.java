package com.trello.qa.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;
    BoardHelper boardHelper;





    public void start() {
        wd = new ChromeDriver();
        wd.navigate().to("https://trello.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        userHelper = new UserHelper(wd);
        boardHelper = new BoardHelper(wd);

    }

    public void stop() {
        wd.quit();
    }

    public UserHelper user() {
        return userHelper;
    }

    public BoardHelper board() { return boardHelper;
    }
}
