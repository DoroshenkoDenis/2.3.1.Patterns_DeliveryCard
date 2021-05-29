package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Locale;

import static java.time.format.DateTimeFormatter.ofPattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class DataGenerator {

    public static class Registration {
        private Registration() {
        }

        public static UserData userDataGenerate(String locale) {
            Faker faker = new Faker(new Locale("ru"));
            return new UserData(
                    faker.address().cityName(),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber()
            );

        }

        public static String generateFirstDate() {
            int Step1 = (int) (1 + Math.random() * 30);
            return LocalDate.now().plusDays(Step1).format(ofPattern("dd.MM.yyyy"));
        }

        public static String generateSecondDate() {
            int Step2 = (int) (1 + Math.random() * 30);
            return LocalDate.now().plusDays(Step2).format(ofPattern("dd.MM.yyyy"));
        }

    }

}

