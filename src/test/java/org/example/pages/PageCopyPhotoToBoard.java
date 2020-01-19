package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageCopyPhotoToBoard {

    SelenideElement toolbox = $("div.action-toolbox");
    By hoverPlus = By.xpath(".//article[@class = 'gallery-mosaic-asset__boards add-to-board action']");

    List<SelenideElement> resultPhotos = $$(By.xpath(".//gi-asset[@class='gallery-mosaic-asset']"));
    By idPhoto = By.xpath(".//a");

    public SavePhotoToBoard addPhotosToBoard(int slotPhoto) {
        SelenideElement photo = resultPhotos.get(slotPhoto - 1);
        photo.hover()
                .$(hoverPlus)
                .hover();
        toolbox.click();
        return new SavePhotoToBoard();
    }

    public String getPhotoId(int slotPhoto){
    return  resultPhotos.get(slotPhoto -1 )
            .$(idPhoto)
            .getAttribute("data-asset-id");

    }
}

