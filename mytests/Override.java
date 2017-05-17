package com.javarush.test.mytests;

/**
 * Created by bezobid on 11.04.2016.
 */
public class Override {
    static class A {
        void go() {
            System.out.println("class A");
        }
    }

    void go2() {
        System.out.println("class A go2");
    }

    static class B extends A {
        void go() {
            System.out.println("class B");
        }

        void go2() {
            System.out.println("class B go2");
        }
    }

    static class C extends B {
        void go() {
            System.out.println("class C");
        }

        void go2() {
            System.out.println("class C go2");
        }
    }

    public static void main(String[] args) {

        A a = new B();
        a.go();


        B c = new C();
        c.go();
        c.go2();


    }
}
