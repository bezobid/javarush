package com.javarush.test.mytests;

/**
 * Created by bezobid on 18.08.2016.
 */
public class Compress {
    public static void main(String[] args) {

        System.out.println(compress("hjjddooessssddlcvvrrrr1"));
    }

    static String compress(String source){
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;

        for (int i = 0; i < source.length(); i++){
            if (i+1 < source.length() && source.charAt(i) == source.charAt(i+1)){
                count++;
            }
            else{
                if (count > 1) stringBuilder.append(count);
                stringBuilder.append(source.charAt(i));
                count = 1;
            }
        }

        return stringBuilder.toString();
    }
}
