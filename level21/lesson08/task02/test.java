package com.javarush.test.level21.lesson08.task02;

/**
 * Created by bezobid on 22.02.2016.
 */
public class test {
    public static void main(String[] args) throws CloneNotSupportedException{
        Solution.Tree one = new Solution.Tree("name1", null);
        Solution.Tree clone = one.clone();

        System.out.println(one.getName());
        System.out.println(clone.getName());

        if (one.getBranches() != null) {
            for (String s : one.getBranches()) {
                System.out.println(s);
            }
        }

        if (clone.getBranches() != null) {
            for (String s : clone.getBranches()) {
                System.out.println(s);
            }
        }



    }
}
