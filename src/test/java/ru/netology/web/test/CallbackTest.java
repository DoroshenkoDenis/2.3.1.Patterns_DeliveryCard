package ru.netology.web.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.pages.CardDeliveryPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class CallbackTest {
    String notificationMessage = "Встреча успешно запланирована на ";

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
// ЗАПУСКАЕМ
// gradlew clean test allureReport
// gradlew allureServe
    }

    @Test
    public void shouldSentNewDate() {
        CardDeliveryPage page = new CardDeliveryPage();
        page.getCityField().setValue(page.getCity());
        page.clearField(page.getDateField());
        page.getDateField().setValue(page.getDeliveryDate());
        page.getNameField().setValue(page.getName());
        page.getPhoneField().setValue(page.getTel());
        page.getCheckboxField().click();
        page.getPlanButtonField().click();
        page.getNotification().shouldHave(exactText(notificationMessage + page.getDeliveryDate()));
        page.clearField(page.getDateField());
        page.getDateField().setValue(page.getNewDeliveryDate());
        page.getPlanButtonField().click();
        page.getRePlanButtonField().click();
        page.getNotification().shouldHave(exactText(notificationMessage + page.getNewDeliveryDate()));
    }
}

