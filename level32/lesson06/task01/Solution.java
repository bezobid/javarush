package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        Random random = new Random();
        ByteArrayOutputStream baot;

        while (true) {
            StringBuilder sb = new StringBuilder();

            boolean hasDigits = false;
            boolean hasUpperCase = false;
            boolean hasLowerCase = false;

            while (sb.length() < 8) {
                char x = ((char) random.nextInt('z'));
                if (Character.isLetterOrDigit(x)) {
                    sb.append(x);

                    if (Character.isDigit(x)) hasDigits = true;
                    else if (Character.isLowerCase(x)) hasLowerCase = true;
                    else if (Character.isUpperCase(x)) hasUpperCase = true;

                    if (sb.length() == 8 && hasDigits && hasUpperCase && hasLowerCase) {
                        baot = new ByteArrayOutputStream();
                        try {
                            baot.write(sb.toString().getBytes());
                            baot.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return baot;
                    }
                }
            }
        }
    }
}
