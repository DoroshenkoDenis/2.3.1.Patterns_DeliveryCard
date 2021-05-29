package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataGenerator;
import ru.netology.web.data.UserData;

class CallbackTest1 {
        private UserData newUserRegistration;

        @BeforeEach
        void setUp() {
            newUserRegistration = DataGenerator.Registration.userDataGenerate("ru");
        }

        @Test
        public void shouldSent() {
            System.out.println(newUserRegistration.getFullName());
        }

    }
