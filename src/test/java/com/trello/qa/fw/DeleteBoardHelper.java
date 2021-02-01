package com.trello.qa.fw;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteBoardHelper extends HelperBase {
    public DeleteBoardHelper(WebDriver wd) {
        super(wd);
    }


    public void CleanAll() throws InterruptedException {

    public void clickByBoard() {
        click(By.cssSelector("[class='boards-page-board-section-list-item']"));
    }

    public void clickByShowMenu() {
        click(By.cssSelector("[class='board-header-btn mod-show-menu js-show-sidebar']"));
    }

    public void clickByMore() {
        clickByXpath("//*[@id=\"content\"]/div/div[2]/div/div/div[2]/div/ul[1]/li[5]/a");
        //click(By.cssSelector("[class='board-menu-navigation-item-link js-open-more']"));
    }

    public void closeBoard() {
        click(By.cssSelector("[class='board-menu-navigation-item-link js-close-board']"));
    }

    public void ByClose() {
        click(By.cssSelector("[class='js-confirm full nch-button nch-button--danger']"));
    }

    public void PermDeleteBoard() {
        click(By.cssSelector("[class='quiet js-delete']"));

    }

    public void Delete() {
        click(By.cssSelector("[class='js-confirm full nch-button nch-button--danger']"));
    }

    public void HomeButton() {
        click(By.cssSelector("[class='nch-icon _2_Q6rrYCFblD3M _3Dk1GPoKnJxuep _1iYprMLTeGpyW9']"));
    }

    public int getCountBoard() {
        int size = wd.findElements(By.xpath("//ul[@class='boards-page-board-section-list']/li/a")).size();
        System.out.println(size);
        return size;

    }


    public void DelWhile() throws InterruptedException {
        while (wd.findElements(By.xpath("//ul[@class='boards-page-board-section-list']/li/a")).size() > 0) {

           /// for (int i = 0; i < el.size() - 1; i++) {
                wd.findElements(By.xpath("//ul[@class='boards-page-board-section-list']/li/a")).get(0).click();
                pause(4000);
            }
        }


    }
}
