package com.javarush.test.mytests;

/**
 * Created by bezobid on 15.06.2016.
 */
public class CodeBlock {
    public static void main(String[] args) {
        new CodeBlock();
    }

    public CodeBlock(){
        System.out.println("constructor");
    }

    {
        System.out.println("ok");
    }

    static{
        System.out.println("static ok");
    }
}
