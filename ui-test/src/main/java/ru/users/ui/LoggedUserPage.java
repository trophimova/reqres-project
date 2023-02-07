package ru.users.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoggedUserPage {

    public SelenideElement logoutBtn() {
        return $(".dropdown-menu > .newlink:nth-child(3) > a");
    }

    public SelenideElement menu() {
        return $(".dropdown-toggle");
    }

    public SelenideElement userName() {
        return $("h2");
    }
}
