package com.demoqa.utils;

import java.time.format.TextStyle;
import java.util.OptionalInt;
import java.util.Locale;
import java.time.Month;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }

    /*
        public static String getRandomString1(int length) {
            return RandomStringUtils.randomAlphabetic(length);
        }
    */
    public static String getRandomEmail() {
        return getRandomString(10) + "@qa.guru";
    }

    public static Long getRandomLong(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static String getRandomPhone() {
        return getRandomLong(1111111111L, 9999999999L).toString();
        //return "+382" + getRandomLong(1111111111L, 9999999999L).toString();   //номер телефона с префиксом
    }

    public static String generateRandomMonth() {
        Random random = new Random();
        OptionalInt randomNumberMonth = random.ints(0, 12).findFirst();
        return Month.of(randomNumberMonth.getAsInt()).getDisplayName(TextStyle.FULL, Locale.US);
    }
}
