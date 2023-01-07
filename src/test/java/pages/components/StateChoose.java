package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateChoose {

    public void setState (String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
    }

    public void setCity (String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
    }
}
