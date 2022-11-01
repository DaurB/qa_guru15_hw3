package com.demoga.tests;

import com.codeborne.selenide.Configuration;
import com.demoga.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTestWithPageObject {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @BeforeAll
    static void beforeSettings() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void practiceFormTest() {
        practiceFormPage.openPage()
                .setFirstName("Dauren")
                .setLastName("Bibol")
                .setEmail("Dauren@g.com")
                .setGender("Male")
                .setNumber("7019444308")
                .setBirthDate("27", "October", "1998")
                .setSubject("History")
                .setHobbies("Reading")
                .setPicture("img/1.png")
                .setAddress("Address, Street, Building")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();


        practiceFormPage.checkResultModalVisible()
                        .checkResult("Date of Birth", "27 October,1998")
                        .checkResult("Student Email","Dauren@g.com")
                        .checkResult("Gender","Male")
                        .checkResult("Mobile","7019444308")
                        .checkResult("Date of Birth","27 October,1998")
                        .checkResult("Subjects","History")
                        .checkResult("Hobbies","Reading")
                        .checkResult("Picture","1.png")
                        .checkResult("Address","Address, Street, Building")
                        .checkResult("State and City","NCR Delhi");

    }
}
