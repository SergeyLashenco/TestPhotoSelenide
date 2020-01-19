package org.example.test;

import org.example.pages.PageCopyPhotoToBoard;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IstockphotoTest extends TestBase {

    String photoId;

    @Test(description = "Open site and login")
    public void validLogin() {
        openSiteIstockphoto();
        homePage.goToPageSignIn().login("sergeylashenco@gmail.com", "11111111s");
        Assert.assertTrue(homePage.account.isDisplayed());
    }

    @Test(priority = 1, description = "Create new Board")
    public void createBoard() {
        homePage
                .goToCreateBoard()
                .createBoard("Serge");
        Assert.assertTrue(miniPageBoard.isBoardExist("Serge"));
    }

    @Test(priority = 2, description = "Поиск фото и добавления выбранного фото на ранее созданный боард")
    public void searchAndCopyPhotoToBoard() throws InterruptedException {
        homePage
                .goToPageSearchPhoto()
                .searchPhotos("winter")
                .addPhotosToBoard(2);
        photoId = new PageCopyPhotoToBoard().getPhotoId(2);
        savePhotoToBoard.savePhotoToBoard("Serge");
        Assert.assertTrue(miniPageBoard.isPhotoAdd("Serge", photoId));
    }

    @Test(priority = 3, description = "Delete Photo")
    public void deletePhoto() {
        savePhotoToBoard
                .goToPageBoard()
                .deletePhoto(photoId);
        Assert.assertTrue(pageBoard.photoNotInBoard(photoId));
    }

    @Test(priority = 4, description = "Delete Board and SignOut")
    public void deleteBoard() {
        pageBoard
                .deleteBoard();
        homePage.signOut();
    }
}
