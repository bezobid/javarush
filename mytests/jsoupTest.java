package com.javarush.test.mytests;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by bezobid on 06.06.2016.
 */
public class jsoupTest {
    public static void main(String[] args) throws IOException {
        Document google = Jsoup.connect("https://hh.ua/search/vacancy?text=java&enable_snippets=true&clusters=true&currency_code=UAH&area=115&page=1").get();

        String title = google.title();
        System.out.println(title);
    }
}
