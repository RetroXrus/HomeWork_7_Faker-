package com.demoqa.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomUtils.generateRandomMonth;
import static java.lang.String.format;

public class RegistrationFormWithFakerTests extends TestBase {

    Faker faker = new Faker();

    @AfterAll
    static void finitaLaCommedia() {
        System.out.println("That's all, Folks!");
    }
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = "Other",
            userNumber = faker.phoneNumber().subscriberNumber(10),
            day = String.format("%02d", faker.number().numberBetween(1, 28)),
            month = generateRandomMonth(),
            year = faker.number().numberBetween(1980, 2000) + "",
            hobbie1 = "Sports",
            hobbie2 = "Reading",
            hobbie3 = "Music",
            picture = "img/testFile.jpg",
            address = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Lucknow",
            resultTableLabel0 = "Label",
            resultTableValue0 = "Values",
            resultTableLabel1 = "Student Name",
            resultTableLabel2 = "Student Email",
            resultTableLabel3 = "Gender",
            resultTableLabel4 = "Mobile",
            resultTableLabel5 = "Date of Birth",
            resultTableLabel6 = "Subjects",
            resultTableLabel7 = "Hobbies",
            resultTableLabel8 = "Picture",
            resultTableLabel9 = "Address",
            resultTableLabel10 = "State and City",
            expectedFullName = format("%s %s", firstName, lastName), //То же самое, что и firstName + " " + lastName
            expectedDateOfBirth = format("%s %s,%s", day, month, year),
            expectedSubjects = "Arts, Maths, Accounting, Social Studies, Hindi, English, Computer Science, Commerce, Chemistry, Economics, History, Physics, Biology, Civics",
            expectedHobbies = format("%s, %s, %s", hobbie1, hobbie2, hobbie3),
            expectedFile = "testFile.jpg",
            expectedStateAndCity = format("%s %s", state, city);

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                //Заполняем данными страницу и отправляем
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjects()
                .setHobbies(hobbie1, hobbie2, hobbie3)
                .uploadPicture(picture)
                .currentAddress(address)
                .state(state)
                .city(city)
                .submit()

                //Проверяем результаты построчно
                .checkResultsTableVisible()
                .checkResult(resultTableLabel0, resultTableValue0)
                .checkResult(resultTableLabel1, expectedFullName)
                .checkResult(resultTableLabel2, userEmail)
                .checkResult(resultTableLabel3, gender)
                .checkResult(resultTableLabel4, userNumber)
                .checkResult(resultTableLabel5, expectedDateOfBirth)
                .checkResult(resultTableLabel6, expectedSubjects)
                .checkResult(resultTableLabel7, expectedHobbies)
                .checkResult(resultTableLabel8, expectedFile)
                .checkResult(resultTableLabel9, address)
                .checkResult(resultTableLabel10, expectedStateAndCity)
                .closeResult();
    }


}
