package ru.netology.web.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;

import static java.time.format.DateTimeFormatter.ofPattern;


public class DataGenerator {

    private DataGenerator() {
    }

    public static class Registration {

        private Registration() {
        }

        public static UserData userDataGenerate(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new UserData(
                    faker.address().cityName(),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber());
        }

        public static String generateDeliveryDate(int nearestDateStep, int lastDateStep) {
            int Step1 = (int) (nearestDateStep + Math.random() * lastDateStep);
            return LocalDate.now().plusDays(Step1).format(ofPattern("dd.MM.yyyy"));
        }

    }

}


