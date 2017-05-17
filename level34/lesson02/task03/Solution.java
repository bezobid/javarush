package com.javarush.test.level34.lesson02.task03;

import java.util.Arrays;

/* Разложение на множители с помощью рекурсии
Разложить целое число n > 1 на простые множители.
Вывести в консоль через пробел все множители в порядке возрастания.
Написать рекуррентный метод для вычисления простых множителей.
Не создавайте статические переменные и поля класса.
Пример:
132
Вывод на консоль:
2 2 3 11
*/
public class Solution {
    public void recursion(int n) {

        for (int x = 2; x <= n; x++) {
            if (isPrime(x) && n % x == 0) {
                System.out.print(x + " ");
                recursion(n/x);
                break;
            }
        }
    }

    public boolean isPrime(int n) {
        if (n == 2) return true;
        if (n == 1 || n % 2 == 0) return false;


        for (int d = 3; d * d < n; d++) {

            if (n % d == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.recursion(132);
    }
}
