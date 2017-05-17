package com.javarush.test.level19.lesson03.task03;

/**
 * Created by bezobid on 11.01.2016.
 */
public class Test implements Solution.IncomeData{
    public String getCountryCode() {
        return "CA";
    }

    public String getCompany() {
        return "JavaRush Ltd.";
    }

    public String getContactFirstName() {
        return "Ivan";
    }

    public String getContactLastName() {
        return "Ivanov";
    }

    public int getCountryPhoneCode() {
        return 7;
    }

    public int getPhoneNumber() {
        return 50123456;
    }

    public static void main(String[] args) {
        Solution.IncomeDataAdapter test = new Solution.IncomeDataAdapter(new Test());
        System.out.println(test.getName());
        System.out.println(test.getCompanyName());
        System.out.println(test.getCountryName());
        System.out.println(test.getPhoneNumber());

    }
}
