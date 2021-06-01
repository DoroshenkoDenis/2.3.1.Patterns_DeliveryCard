package ru.netology.web.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.openqa.selenium.Keys;
import ru.netology.web.data.DataGenerator;
import ru.netology.web.data.UserData;

import static com.codeborne.selenide.Selenide.*;

@NoArgsConstructor
@Data
public class CardDeliveryPage {
    SelenideElement cityField = $("[data-test-id=city] .input__control");
    SelenideElement dateField = $("[data-test-id=date] .input__control");
    SelenideElement nameField = $("[data-test-id=name] .input__control");
    SelenideElement phoneField = $("[data-test-id=phone] .input__control");
    SelenideElement checkboxField = $("[data-test-id=agreement] .checkbox__box");
    SelenideElement planButtonField = $(".button__text");
    SelenideElement notification = $(".notification__content");
    SelenideElement rePlanButtonField = $("[data-test-id=replan-notification] .button__text");
    SelenideElement inputError = $((".input_invalid"));

    UserData userData = DataGenerator.Registration.userDataGenerate("ru", DataGenerator.Registration.getRandomCity());

    String deliveryDate = DataGenerator.Registration.generateDeliveryDate(3, 100);
    String newDeliveryDate = DataGenerator.Registration.generateDeliveryDate(3, 100);
    String name = userData.getFullName().replace("ё", "е");
    String tel = userData.getPhoneNumber();
    String city = userData.getCity();

    public void clearField(SelenideElement field) {
        field.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
    }

}
