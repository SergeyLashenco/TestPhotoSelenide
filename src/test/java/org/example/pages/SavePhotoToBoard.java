package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SavePhotoToBoard {

    SelenideElement chooseBoard = $("a.choose-board");
    List<SelenideElement> boardsName = $$(By.xpath(".//ul/li[@class='board-item ng-scope']"));
    public SelenideElement hoverNameBoard = $(By.xpath(".//li[@class='board-item ng-scope']"));
    SelenideElement buttonGoToPageBoard = $(By.xpath(".//a[@class='button open-board']"));

    @Step
    public PageCopyPhotoToBoard savePhotoToBoard(String boardName) {
        if (chooseBoard.isDisplayed()) {
            chooseBoard.click();
        }
        boardsName.stream().filter(board -> board.getText().equals(boardName)).findFirst().orElse(hoverNameBoard).click();

        return new PageCopyPhotoToBoard();
    }

    @Step
    public PageBoard goToPageBoard() {
        buttonGoToPageBoard.click();
        return new PageBoard();
    }
}
