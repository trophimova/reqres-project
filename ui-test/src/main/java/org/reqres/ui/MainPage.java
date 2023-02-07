package org.reqres.ui;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public static MainPage open() {
        Selenide.open("http://users.bugred.ru/user/login/index.html");
        return new MainPage();
    }

    public void loginAs(String email, String password) {
        //$("#login > a").click();
        $("form:nth-child(3) tr:nth-child(1) input").setValue(email);
        $("form:nth-child(3) tr:nth-child(2) input").setValue(password);
        $("tr:nth-child(3) .btn").click();
    }
}
