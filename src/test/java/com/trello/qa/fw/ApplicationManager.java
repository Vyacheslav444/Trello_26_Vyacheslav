package com.trello.qa.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;
    BoardHelper boardHelper;
    String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }


    public void start() {

        if (browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }

        wd.navigate().to("https://trello.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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
