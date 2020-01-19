package org.example.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MiniPageBoard {

    public SelenideElement openBoard = $(By.xpath(".//span[@class='carrot-container']"));//"#open_board"
    SelenideElement creatBoard = $(By.xpath(".//a[@class ='board-link create-board-link']"));
    SelenideElement inputBoardName = $(By.xpath("//div[contains(@ng-class, 'for-first-board')]//input[@name='boardname']"));
    SelenideElement buttonCreate = $(By.xpath(".//a[@class='button' and @type='submit']"));
    By createdBoards = By.xpath(".//div[@class='boards-menu-container']//li//a[@class='board-item-link']");


    @Step
    public HomePage createBoard(String nameBoard) {
        openBoard.click();
        creatBoard.click();
        inputBoardName.sendKeys(nameBoard);
        buttonCreate.click();
        return new HomePage();
    }

    @Step
    public boolean isBoardExist(String createdBoard) {
        openBoard.hover().click();
        try {
            List<SelenideElement> listCreatedBoard = $$(this.createdBoards).shouldBe(CollectionCondition.sizeGreaterThan(0));
            for (SelenideElement exist : listCreatedBoard
            ) {
                String boardName = exist.findElement(By.tagName("span")).getAttribute("textContent");
                if (boardName.equals(createdBoard)) {
                    return true;
                }
            }
        } catch (Throwable t) {
            return false;
        }
        return false;
    }

    @Step
    public boolean isPhotoAdd(String nameBoard, String idPhoto) {
        openBoard.hover().click();
        List<SelenideElement> listCreatedBoard = $$(this.createdBoards).shouldBe(CollectionCondition.sizeGreaterThan(0));
        if (isBoardExist(nameBoard)) {
            listCreatedBoard.stream().filter(board -> board.getText().equals(nameBoard)).findFirst().orElse( new SavePhotoToBoard().hoverNameBoard).click();
        }
        List<SelenideElement> boardPhotoId = $$(By.xpath(".//span[@ng-controller]"));
        for (WebElement photoid : boardPhotoId
        ) {
            String id = photoid.findElement(By.xpath(".//ul/li[@carousel-loaded]")).getAttribute("data-asset-id");
            if (idPhoto.equals(id)) return true;
        }
        return false;
    }
}
