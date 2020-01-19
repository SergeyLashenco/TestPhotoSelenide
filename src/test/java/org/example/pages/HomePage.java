package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {


    SelenideElement signIn = $(By.xpath(".//a[@class='account' and @data-nav='nav=nav_SignIn' ]"));
    SelenideElement goToPhotos = $(By.xpath(".//a[@data-nav = 'nav=nav_Photos' and @title='Photos']"));
    SelenideElement signOut = $("#hypSignOut");
    public SelenideElement account = $(By.xpath(".//li[@class = 'wide-header right-off-canvas-toggle-menu' and text()='Account']"));
    SelenideElement bord = $(By.xpath(".//a[@class='modalClose close-reveal-modal' and @href='#close']"));
    SelenideElement openBoard = $("#open_board");


    @Step
    public PageSignIn goToPageSignIn() {
        if (bord.exists()) {
            bord.click();
        }
        signIn.click();
        return new PageSignIn();
    }

    @Step
    public MiniPageBoard goToCreateBoard() {
        openBoard.hover();
        return new MiniPageBoard();
    }

    @Step
    public PageSearchPhoto goToPageSearchPhoto() {
        goToPhotos.click();
        return new PageSearchPhoto();
    }

    @Step
    public void signOut() {
        account.click();
        signOut.click();
    }

}
