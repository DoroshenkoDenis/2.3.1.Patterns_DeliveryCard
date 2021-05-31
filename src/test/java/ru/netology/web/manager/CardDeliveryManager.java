package ru.netology.web.manager;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.openqa.selenium.Keys;
import ru.netology.web.data.DataGenerator;
import ru.netology.web.data.UserData;

import static com.codeborne.selenide.Selenide.*;

@NoArgsConstructor
@Data
public class CardDeliveryManager {

    SelenideElement cityField = $("[data-test-id=city] .input__control");
    SelenideElement dateField = $("[data-test-id=date] .input__control");
    SelenideElement nameField = $("[data-test-id=name] .input__control");
    SelenideElement phoneField = $("[data-test-id=phone] .input__control");
    SelenideElement checkboxField = $("[data-test-id=agreement] .checkbox__box");
    SelenideElement planButtonField = $(".button__text");
    SelenideElement notification = $(".notification__content");
    SelenideElement replanButtonField = $("[data-test-id=replan-notification] .button__text");
    SelenideElement inputError = $((".input_invalid"));

    UserData userData = DataGenerator.Registration.userDataGenerate("ru");
    String deliveryDate = DataGenerator.Registration.generateDeliveryDate(3, 100);
    String newDeliveryDate = DataGenerator.Registration.generateDeliveryDate(3, 100);
    String name = userData.getFullName().replace("ё", "е");
    String tel = userData.getPhoneNumber();
    String city = userData.getCity();

    public void clearField(SelenideElement field) {
        field.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
    }

    public void createMeeting() {
        cityField.setValue(city);
        clearField(dateField);
        dateField.setValue(deliveryDate);
        nameField.setValue(name);
        phoneField.setValue(tel);
        checkboxField.click();
        planButtonField.click();
        while (inputError.exists()) {
            clearField(cityField);
            cityField.setValue(city);
            planButtonField.click();
        }
    }

    public void changeMeetingDate() {
        clearField(dateField);
        dateField.setValue(newDeliveryDate);
        planButtonField.click();
        replanButtonField.click();
    }

}
