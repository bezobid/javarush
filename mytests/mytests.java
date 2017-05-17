package com.javarush.test.mytests;
import java.util.Scanner;
public class mytests {
    public static void main(String[] args) {
       String s1 = "firefox";
        System.out.println(s1.toUpperCase());
        String s2 = s1.replace('f', 'F');
        System.out.println(s2);
        System.out.println(s2.length());
        int i;
        i = s1.length();
       // i = s1.isEmpty();
        System.out.println(i);
        boolean e;
        String e1 = "blahblah";
        String e2 = "blahblahblah";
        e = e1.equals(e2);
        if (e)
            System.out.println("Strings are equal");
        else
            System.out.println("Strings are NOT equal");
      // System.out.println(e);
        //Scanner sc = new Scanner(System.in);
        //double  x = sc.nextDouble();
        //System.out.println(x/3);

        int index = e1.lastIndexOf('h');
        System.out.println(index);
        char ch = s1.charAt(3);
        System.out.println(ch);

        //Scanner sc = new Scanner(System.in);
        //double scan=1;
        //System.out.println("Input number");
        //if(sc.hasNextDouble())
        //{
        //scan =sc.nextDouble();
        //System.out.println(scan * 3 + " Thank you");
        //}
        //else System.out.println("Non double");

        Scanner scan = new Scanner(System.in);
        System.out.println("Input integer");
        int res;
        if (scan.hasNextInt())
        {res = scan.nextInt();
            if (res%2 != 0 )
                System.out.println("Нечетное число");
            else System.out.print("Четное число");
        }
        else System.out.println("Не целое число!");




    }
}
