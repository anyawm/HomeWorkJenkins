package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import pages.components.CalendarComponent;
import pages.components.PictureComponent;
import pages.components.RegistrationResultsModal;
import pages.components.StateChoose;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    Faker faker = new Faker(new Locale("fr"));
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    StateChoose stateChoose = new StateChoose();
    PictureComponent pictureComponent = new PictureComponent();
    private final String titlepage = "Student Registration Form";
    private SelenideElement
            lastNameInput = $("#lastName"), //чтобы менять только в одном месте, если изменится написание элемента на странице
            firstNameInput = $("#firstName"),
            emailInput = $("#userEmail");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(titlepage));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage clearLastName() {
        lastNameInput.clear();

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click(); // todo move to Selenide elements

        return this;
    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage registrationResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResults(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage submitButton() {
        $("#submit").click();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setState(String value) {
        stateChoose.setState(value);

        return this;
    }

    public RegistrationPage setCity(String value) {
        stateChoose.setCity(value);

        return this;
    }

    public RegistrationPage setPhoto(String picture) {
        pictureComponent.loadPhoto(picture);

        return this;
    }
}


