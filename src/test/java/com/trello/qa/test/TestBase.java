package com.trello.qa.test;


import com.trello.qa.fw.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {
    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
Logger logger = LoggerFactory.getLogger(TestBase.class);
    @BeforeSuite
    public void setUp() throws IOException {
        app.start();

    }
    @BeforeMethod
    public void startLogger(Method m){
        logger.info("start test " + m.getName());
}
    @AfterMethod(alwaysRun = true)
    public void stopLogger(Method m){
        logger.info("stop test " + m.getName());
    }
    @AfterSuite(enabled = false)
    public void tearDown(){
        app.stop();

    }

}
