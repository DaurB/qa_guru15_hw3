package com.demoga;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void beforeSettings() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void practiceFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue("Dauren");
        $("#lastName").setValue("Bibol");
        $("#userEmail").setValue("Dauren@g.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("7019444308");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--027:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Address, Street, Building");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();


        $(".modal-dialog").shouldHave(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Dauren Bibol"),
                text("Dauren@g.com"),
                text("Male"),
                text("7019444308"),
                text("27 October,1998"),
                text("History"),
                text("Reading"),
                text("1.png"),
                text("Address, Street, Building"),
                text("NCR Delhi"));

                ////рудщщ






    }
}
