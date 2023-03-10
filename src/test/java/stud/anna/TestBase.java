package stud.anna;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    String userName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String currentAddress = faker.lebowski().quote();

    @BeforeAll
    static void beforeAll() {
        //Configuration.baseUrl = "https://demoqa.com";
        Configuration.baseUrl = System.getProperty("base_url", "https://demoqa.com");
        //Configuration.browserSize = "1920x1080";
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
        Configuration.browserVersion = System.getProperty("browser_version", "100.0");
        Configuration.remote = System.getProperty("remote_browser", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.browser = System.getProperty("browser", "chrome");


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }


}
