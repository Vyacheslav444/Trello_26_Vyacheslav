package com.trello.qa.fw;

import com.trello.qa.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginForm(User user) throws InterruptedException {
        type(By.id("user"), user.getEmail());
        Thread.sleep(2000);
        click(By.id("login"));
        Thread.sleep(2000);
        type(By.id("password"), user.getPassword());


    }

    public void confirmLogin() {
        click(By.id("login-submit"));
    }

    public boolean isAvatarPresent() throws InterruptedException {
        Thread.sleep(20000);
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }
    public void login() throws InterruptedException {
        initLogin();
        fillLoginForm(new User()
                .setEmail("sb_vip@mail.ru")
                .setPassword("Slavlik444"));
        confirmLogin();
    }

    public void clickLogOutButton() {
        click(By.cssSelector("._1FekJJAz6Hu32v"));
        click(By.xpath("//span[contains(.,'Log Out')]"));
    }

    public void clickOnTheAvatar() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void goToProfile() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void goToAtlassianAcc() {
        click(By.cssSelector("[href$=manage-profile]"));
        swithcToWindow(1);

    }
    public void closeWindow(){
        wd.close();
       swithcToWindow(0);

    }




    public void changeAvatar(String path) {
        WebElement avatar = wd.findElement(By.cssSelector("[data-test-selector='profile-hover-info']"));
        Actions actions = new Actions(wd);
          actions
                  .moveToElement(avatar)
                  .moveToElement(avatar.findElement(By.xpath(".//*[@class='Droplist__Trigger-sc-1z05y4v-3 eteVrT']")))
                .click()
                .perform();
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Change profile photo')]"))).click();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        attachPhoto(By.cssSelector("#image-input"),new File(path));
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(By.xpath("//button//span[contains(., 'Upload')]"));

    }
}
//span[contains(text(),'Change profile photo')]
//div[@id='uid16']//span[2]
//span[contains(text(),'Upload')]