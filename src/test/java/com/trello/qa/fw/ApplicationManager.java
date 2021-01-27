package com.trello.qa.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Properties properties;
    WebDriver wd;
    UserHelper userHelper;
    BoardHelper boardHelper;
    String browser;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager(String browser) {

        this.browser = browser;
    }


    public void start() throws IOException {
        properties = new Properties();


        String target = System.getProperty("target", "slava");

        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));

        if (browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }

        wd.navigate().to(properties.getProperty("web.URL"));
        logger.info("Opened site: " + wd.getCurrentUrl());
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        userHelper = new UserHelper(wd);
        boardHelper = new BoardHelper(wd);

    }
    public String setEmail(){
        return  properties.getProperty("web.email");
    }
    public String setPassword(){
        return  properties.getProperty("web.password");
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
