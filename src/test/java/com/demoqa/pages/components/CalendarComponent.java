package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final SelenideElement birthDateInput = $("#dateOfBirthInput");
    private final SelenideElement yearInput = $(".react-datepicker__year-select");
    private final SelenideElement monthInput = $(".react-datepicker__month-select");

    public CalendarComponent setDate(String day, String month, String year) {
        birthDateInput.click();
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }
}
