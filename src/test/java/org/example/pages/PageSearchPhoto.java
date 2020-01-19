package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PageSearchPhoto {

    SelenideElement searchPhoto = $(By.xpath(".//input[@class='non-default phrase']"));

    @Step
    public PageCopyPhotoToBoard searchPhotos(String necessaryPhoto) {
        searchPhoto.click();
        searchPhoto.val(necessaryPhoto).pressEnter();
        return new PageCopyPhotoToBoard();
    }

}
