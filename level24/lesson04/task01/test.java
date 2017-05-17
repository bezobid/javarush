package com.javarush.test.level24.lesson04.task01;

import java.math.BigDecimal;

/**
 * Created by bezobid on 30.03.2016.
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
        Solution.Building b = s.new Building();
        Solution.Building.Hall h = b.new Hall(new BigDecimal(1));

        Solution.Apt3Bedroom apt = s.new Apt3Bedroom(b);
    }
}
