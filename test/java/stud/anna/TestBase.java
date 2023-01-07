package stud.anna;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

/*    public static String userName = "Alex",
            userSurname = "Egorov",
            userEmail = "alex@egorov.com";*/
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }
}
