package com.demoga.utils;

import com.github.javafaker.Faker;
import java.util.Random;

public class TestData {
    static Faker faker = new Faker();
    static Random random = new Random();

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            phone = faker.phoneNumber().subscriberNumber(10),
            day = String.format("%02d", faker.number().numberBetween(1, 28)),
            month = getRandomMonth(),
            year = String.valueOf(faker.number().numberBetween(1975, 2008)),
            subject = getRandomSubject(),
            hobbies = getRandomHobby(),
            picture = "img/1.png",
            address = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";

    public static String getRandomMonth() {
        String[] month = {"January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"};
        int randomIndex = random.nextInt(month.length);
        return month[randomIndex];
    }

    public static String getRandomSubject() {
        String[] subject = {"Maths", "Chemistry", "Computer Science",
                "Commerce", "Economics"};
        int randomIndex = random.nextInt(subject.length);
        return subject[randomIndex];
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        int randomIndex = random.nextInt(hobbies.length);
        return hobbies[randomIndex];
    }


}
