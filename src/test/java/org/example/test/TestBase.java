package org.example.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.example.pages.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    @BeforeTest
    public void setUp() {
        Configuration.browser = "chrome"; //firefox
        System.setProperty("selenide.browser", "chrome");
    }

    @Step
    public void openSiteIstockphoto() {
        Selenide.open("https://www.istockphoto.com/");
    }


    HomePage homePage = new HomePage();
    MiniPageBoard miniPageBoard = new MiniPageBoard();
    PageBoard pageBoard = new PageBoard();
    SavePhotoToBoard savePhotoToBoard = new SavePhotoToBoard();

    @AfterTest
    public void tearDown() {
        Selenide.closeWindow();
    }
}
