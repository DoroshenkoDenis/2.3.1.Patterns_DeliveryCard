//package ru.netology.web.test;
//
//import com.codeborne.selenide.Configuration;
//import com.codeborne.selenide.SelenideElement;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.Keys;
//import ru.netology.web.data.DataGenerator;
//import ru.netology.web.data.UserData;
//
//import java.time.Duration;
//
//import static com.codeborne.selenide.Condition.visible;
//import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.open;
//
//public class CallbackTest {
//    private UserData newUserRegistration;
//    SelenideElement cityField = $("[data-test-id=city] .input__control");
//    SelenideElement dateField = $("[data-test-id=date] .input__control");
//    SelenideElement nameField = $("[data-test-id=name] .input__control");
//    SelenideElement phoneField = $("[data-test-id=phone] .input__control");
//    SelenideElement checkboxField = $("[data-test-id=agreement] .checkbox__box");
//    SelenideElement buttonSentField = $(".button__text");
//    SelenideElement notification = $(".notification__title");
//    SelenideElement inputError = $((".input_invalid"));
//
//    @BeforeEach
//    void setUp() {
//        Configuration.headless = true;
//        open("http://localhost:9999");
//        newUserRegistration = DataGenerator.Registration.userDataGenerate("ru");
//        //----- Clear date field -------------------------------
//        dateField.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
//    }
//
//    @Test
//    public void shouldSent() {
//        System.out.println(newUserRegistration.getFullName());
//        cityField.setValue(newUserRegistration.getCity());
//        dateField.setValue(DataGenerator.Registration.generateFirstDate());
//        nameField.setValue(newUserRegistration.getFullName());
//        phoneField.setValue(newUserRegistration.getPhoneNumber());
//        checkboxField.click();
//        buttonSentField.click();
//        notification.shouldBe(visible, Duration.ofSeconds(5));
//        dateField.setValue(DataGenerator.Registration.generateSecondDate());
//        while (DataGenerator.Registration.generateSecondDate()
//                .equals(DataGenerator.Registration.generateFirstDate())) {
//            dateField.setValue(DataGenerator.Registration.generateSecondDate());
//        }
//        buttonSentField.click();
//        notification.shouldBe(visible, Duration.ofSeconds(5));
//
//    }
//
//}
//
