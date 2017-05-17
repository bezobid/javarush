package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();

    static
    {
        countries.put("Ukraine", "UA");
        countries.put("Russia", "RU");
        countries.put("Canada", "CA");
    }

        public static void main(String[] args) {
        Customer customer=new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Canada";
            }
        };
        Contact contact=new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };
        RowItem rowItem=new DataAdapter(customer, contact);
        System.out.println(rowItem.getCountryCode());
        System.out.println(rowItem.getCompany());
        System.out.println(rowItem.getContactFirstName());
        System.out.println(rowItem.getContactLastName());
        System.out.println(rowItem.getDialString());
    }

    public static class DataAdapter implements RowItem{

        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact)
        {
            this.customer = customer;
            this.contact = contact;
        }

       public String getCountryCode()
       {
           return countries.get(this.customer.getCountryName());
       }

        public String getCompany()
        {
            return this.customer.getCompanyName();
        }


            public String getContactFirstName()
        {
            String[] name = this.contact.getName().split(", ");
            return name[1];
        }

        public String getContactLastName()
        {
            String[] name = this.contact.getName().split(", ");
            return name[0];
        }

        public String getDialString()
        {
            StringBuilder sb = new StringBuilder("callto://+");
            char[] symbols = this.contact.getPhoneNumber().toCharArray();
            for(Character x : symbols){
                if (Character.isDigit(x))
                {
                    sb.append(x);
                }
            }
            return sb.toString();
        }
    }

    public interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}