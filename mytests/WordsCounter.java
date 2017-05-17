package com.javarush.test.mytests;


import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * Created by bezobid on 12.10.2016.
 */
public class WordsCounter {
    public static void main(String[] args) throws IOException {
        countWords("c:/text.txt");
    }


    static void countWords(String fileName) throws IOException {
        Map<String, Integer> words = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int maxLength = 0;


        while(reader.ready()){
            String line = reader.readLine().toLowerCase();
            String[] lineSplits = line.split(" ");


            for (String word : lineSplits) {
                word = word.replaceAll("\\W", "");
                if (word.length() > maxLength) maxLength = word.length();
                if (word.matches("^.*\\d.*$") || word.length() == 0) break;
                words.put(word, words.containsKey(word) ? words.get(word)+1 : 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>( words.entrySet() );
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return ( o2.getValue() ).compareTo( o1.getValue() );
            }
        } );

        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list)
        {
            result.put( entry.getKey(), entry.getValue() );
        }

        int count = 1;
        String pattern = "%1$" + (String.valueOf(result.size()).length()) + "s   %2$-" + (maxLength) + "s %3$s";
        for (String s : result.keySet()) {
            System.out.println(String.format(pattern, count, s, words.get(s)));
            count++;
            if (count > 100) break;
        }







    }

    static String getFileName(){
        String file = null;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            file = reader.readLine();

        } catch (IOException e){
            e.printStackTrace();
        }

        return file;
    }
}
