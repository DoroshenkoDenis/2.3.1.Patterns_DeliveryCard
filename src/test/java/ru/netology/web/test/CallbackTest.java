package ru.netology.web.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.manager.CardDeliveryManager;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class CallbackTest {
    private CardDeliveryManager manager = new CardDeliveryManager();
    String notificationMessage = "Встреча успешно запланирована на ";

    @BeforeEach
    void setUp() {
        Configuration.headless = true;
        open("http://localhost:9999");
    }

    @Test
    public void shouldSentNewDate() {
        manager.createMeeting();
        manager.changeMeetingDate();
        manager.getNotification().shouldHave(exactText(notificationMessage + manager.getNewDeliveryDate()));
    }

}

