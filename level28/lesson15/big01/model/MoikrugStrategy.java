package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bezobid on 08.06.2016.
 */
public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    //private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data2.html";


    @Override
    public List<Vacancy> getVacancies(String searchString){
        ArrayList<Vacancy> vacancies = new ArrayList<>();

        for (int x = 0; ;x++) {
            Document page = null;
            Elements elementsByAttribute = null;
            try {
                page = getDocument(searchString, x);
                elementsByAttribute = page.getElementsByAttributeValue("class", "job  ");
                elementsByAttribute.addAll(page.getElementsByAttributeValue("class", "job marked"));
            } catch (Exception e) {}

            if (elementsByAttribute == null || elementsByAttribute.size() == 0) break;

            else{
                for (Element element : elementsByAttribute) {
                    Vacancy vacancy = new Vacancy();

                    vacancy.setTitle(element.getElementsByAttributeValue("class", "title").text());
                    vacancy.setUrl("https://moikrug.ru" + element.getElementsByTag("a").attr("href"));
                    vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").select("a").text());
                    vacancy.setCity(element.getElementsByAttributeValue("class", "location").text());
                    vacancy.setSalary(element.getElementsByAttributeValue("class", "salary").text());
                    try {
                        vacancy.setSiteName(new URL(URL_FORMAT).getHost());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                    if (vacancies.contains(vacancy)) return vacancies;

                    vacancies.add(vacancy);
                }
            }
        }

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36")
                .referrer("javarush.ru")
                .get();
    }
}
