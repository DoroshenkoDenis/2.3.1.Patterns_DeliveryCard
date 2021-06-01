package ru.netology.web.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

import static java.time.format.DateTimeFormatter.ofPattern;


public class DataGenerator {

    private DataGenerator() {
    }

    public static class Registration {

        private Registration() {
        }

        public static String getRandomCity() {
            List<String> list = Arrays.asList("Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Белгород", "Биробиджан",
                    "Благовещенск", "Брянск", "Великий Новгород", "Владивосток", "Владикавказ", "Владимир", "Волгоград", "Вологда", "Воронеж",
                    "Горно-Алтайск", "Грозный", "Екатеринбург", "Иваново", "Ижевск", "Иркутск", "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Кемерово",
                    "Киров", "Кострома", "Краснодар", "Красноярск", "Курган", "Курск", "Кызыл", "Липецк", "Магадан", "Магас", "Майкоп",
                    "Махачкала", "Москва", "Мурманск", "Нальчик", "Нарьян-Мар", "Нижний Новгород", "Новосибирск", "Омск", "Орёл", "Оренбург",
                    "Пенза", "Пермь", "Петрозаводск", "Петропавловск-Камчатский", "Псков", "Ростов-на-Дону", "Рязань", "Салехард", "Самара",
                    "Санкт-Петербург", "Саранск", "Саратов", "Севастополь", "Симферополь", "Смоленск", "Ставрополь", "Сыктывкар",
                    "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Улан-Удэ", "Ульяновск", "Уфа", "Хабаровск", "Ханты-Мансийск", "Чебоксары",
                    "Челябинск", "Черкесск", "Чита", "Элиста", "Южно-Сахалинск", "Якутск", "Ярославль");
            Random random = new Random();
            return list.get(random.nextInt(list.size()));
        }

        public static UserData userDataGenerate(String locale, String city) {
            Faker faker = new Faker(new Locale(locale));
            return new UserData(
                    city,
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber());
        }

        public static String generateDeliveryDate(int nearestDateStep, int lastDateStep) {
            int Step1 = (int) (nearestDateStep + Math.random() * lastDateStep);
            return LocalDate.now().plusDays(Step1).format(ofPattern("dd.MM.yyyy"));
        }


    }

}


