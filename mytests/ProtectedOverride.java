package com.javarush.test.mytests;

/**
 * Created by bezobid on 13.04.2016.
 */
public class ProtectedOverride {
    public static void main(String[] args) {
        new B().go();
    }

}

class A{
    protected static String doA2(){
        return "a2";
    }
}

class B extends A{
    public static String doA2(){
        return "b2";
    }

    void go(){
        A myA = new B();
        System.out.println(myA.doA2());
    }
}


