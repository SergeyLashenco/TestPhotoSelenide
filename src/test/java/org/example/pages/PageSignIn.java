package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class PageSignIn {

    SelenideElement inputEmailOrName = $("#new_session_username");
    SelenideElement inputPass = $("#new_session_password");
    SelenideElement buttonSignIn = $("#sign_in");

    @Step
    public HomePage login(String emailOrName, String password) {
        inputEmailOrName.setValue(emailOrName);
        inputPass.setValue(password);
        buttonSignIn.click();

        return new HomePage();
    }

}
