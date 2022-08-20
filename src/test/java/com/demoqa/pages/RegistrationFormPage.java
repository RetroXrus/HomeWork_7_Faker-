package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    //Elements
    private final static String TITLE_TEXT = "Student Registration Form";
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final ResultsTableComponent resultsModal = new ResultsTableComponent();
    private final SelenideElement
            pageNameInput = $(".practice-form-wrapper");
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderInput = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement birthDateInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesInput = $("#hobbiesWrapper");
    private final SelenideElement pictureInput = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement stateInput = $("#react-select-3-input");
    private final SelenideElement cityInput = $("#react-select-4-input");
    private final SelenideElement submitInput = $("#submit");

    private String subject_1 = "Arts",
            subject_2 = "Maths",
            subject_3 = "Accounting",
            subject_4 = "Social Studies",
            subject_5 = "Hindi",
            subject_6 = "English",
            subject_7 = "Computer Science",
            subject_8 = "Commerce",
            subject_9 = "Chemistry",
            subject_10 = "Economics",
            subject_11 = "History",
            subject_12 = "Physics",
            subject_13 = "Biology",
            subject_14 = "Civics";

    // Actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        pageNameInput.shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubjects() {
        subjectsInput.setValue(subject_1).pressEnter();
        subjectsInput.setValue(subject_2).pressEnter();
        subjectsInput.setValue(subject_3).pressEnter();
        subjectsInput.setValue(subject_4).pressEnter();
        subjectsInput.setValue(subject_5).pressEnter();
        subjectsInput.setValue(subject_6).pressEnter();
        subjectsInput.setValue(subject_7).pressEnter();
        subjectsInput.setValue(subject_8).pressEnter();
        subjectsInput.setValue(subject_9).pressEnter();
        subjectsInput.setValue(subject_10).pressEnter();
        subjectsInput.setValue(subject_11).pressEnter();
        subjectsInput.setValue(subject_12).pressEnter();
        subjectsInput.setValue(subject_13).pressEnter();
        subjectsInput.setValue(subject_14).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies(String one, String two, String three) {
        hobbiesInput.$(byText(one)).click();
        hobbiesInput.$(byText(two)).click();
        hobbiesInput.$(byText(three)).click();
        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage currentAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage state(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage city(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage submit() {
        submitInput.click();
        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();
        return this;
    }

    public ResultsTableComponent checkResult(String key, String value) {
        resultsModal.checkResult(key, value);
        return resultsModal;
    }
}
