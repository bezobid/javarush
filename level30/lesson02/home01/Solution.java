package com.javarush.test.level30.lesson02.home01;

import java.math.BigDecimal;
import java.math.BigInteger;

/* Конвертер систем счислений
Реализуйте логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit()
из одной системы счисления(numerationSystem) в другую (expectedNumerationSystem)
бросьте NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2
Валидация для - number.getDigit() - целое не отрицательное
Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._2, "010100100101010011110101001010001010100101010010101010010010100100010100010111101010100100");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._10);
        System.out.println(result);    //expected 110

        Number number1 = new Number(NumerationSystemType._2, "110");
        Number result1 = convertNumberToOtherNumerationSystem(number1, NumerationSystemType._10);
        System.out.println(result1);    //expected 110


    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {

        String num = number.getDigit();

        BigInteger bi = new BigInteger(num, number.getNumerationSystem().getNumerationSystemIntValue());

        String result = bi.toString(expectedNumerationSystem.getNumerationSystemIntValue());

        return new Number(expectedNumerationSystem, result);
    }
}
