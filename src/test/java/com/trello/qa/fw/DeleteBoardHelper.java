package com.trello.qa.fw;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DeleteBoardHelper extends HelperBase {
    public DeleteBoardHelper(WebDriver wd) {
        super(wd);
    }

 public int getCountBoard() {
     try {
         pause(5000);
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
     int size = wd.findElements(By
            .cssSelector(".boards-page-board-section-list li a")).size();
    System.out.println(size);
    return size;

}
    public void CleanAll() throws InterruptedException {
      while(wd.findElements(By.cssSelector(".boards-page-board-section-list li a")).size() > 2){

          wd.findElements(By.cssSelector(".boards-page-board-section-list li a")).get(0).click();
        pause(4000);
            //click(By.cssSelector("[class='boards-page-board-section-list-item']"));
            clickByXpath("//li[contains(.,'More')]");
            click(By.cssSelector("[class='board-menu-navigation-item-link js-close-board']"));
            clickByXpath("//input[@type='submit' and @value='Close']");
            click(By.cssSelector("[class='nch-icon _2_Q6rrYCFblD3M _3Dk1GPoKnJxuep _1iYprMLTeGpyW9']"));
      }


        //click(By.cssSelector("[class='boards-page-board-section-list-item']"));
        //pause(2000);
        //clickByXpath("//a[@title='Go back.']");

        //clickByXpath("//li[contains(.,'More')]");
        //click(By.cssSelector("[class='board-menu-navigation-item-link js-close-board']"));
        //clickByXpath("//input[@type='submit' and @value='Close']");


        //pause(4000);
        //clickByXpath("//a[.='Permanently Delete Board…']");
        //click(By.xpath("//input[@value='Delete']"));
        //pause(4000);

        //click(By.cssSelector("[class='nch-icon _2_Q6rrYCFblD3M _3Dk1GPoKnJxuep _1iYprMLTeGpyW9']"));


        //pause(4000);
        //app.delBoard().closeBoard();
        //[class='js-confirm full nch-button nch-button--danger']
        //app.delBoard().ByClose();
        //[class='quiet js-delete']
        //app.delBoard().PermDeleteBoard();
        //[class='js-confirm full nch-button nch-button--danger']
        //app.delBoard().Delete();
        //[class='nch-icon _2_Q6rrYCFblD3M _3Dk1GPoKnJxuep _1iYprMLTeGpyW9']
        //app.delBoard().HomeButton();


    }

}
