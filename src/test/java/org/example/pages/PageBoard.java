package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class PageBoard {

    List<SelenideElement> photosInBoard = $$(By.xpath("//div[@class='board-item-content' and @ng-class]"));
    SelenideElement buttonDeletePhotos = $("span.remove");
    SelenideElement buttonDeleteBoard = $(By.xpath(".//a[@class='delete-board ng-scope']"));

    @Step
    public SelenideElement searchPhoto(String idPhoto) {
        for (SelenideElement photo : photosInBoard
        ) {
            photo.findElement(By.xpath(".//span[@class='asset-id ng-binding']")).getText().equals(idPhoto);
            return photo;
        }
        return null;
    }

    @Step
    public void deletePhoto(String id) {
        SelenideElement deletePhotos = searchPhoto(id);
        deletePhotos.hover();
        buttonDeletePhotos.click();
        deletePhotos.shouldBe(Condition.not(Condition.exist));
    }

    @Step
    public boolean photoNotInBoard(String idPhoto) {
        return searchPhoto(idPhoto) == null;
    }

    @Step
    public PageBoard deleteBoard() {
        buttonDeleteBoard.click();
        switchTo().alert().accept();
        return this;
    }
}