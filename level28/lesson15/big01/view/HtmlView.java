package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

/**
 * Created by bezobid on 07.06.2016.
 */
public class HtmlView implements View {
    Controller controller;
    private final String filePath = "./src/"
            + this.getClass().getPackage().toString().substring(8).replace('.', '/')
            + "/vacancies.html";
    @Override
    public void update(List<Vacancy> vacancies) {
        //System.out.println(vacancies.size());
        try{
            updateFile(getUpdatedFileContent(vacancies));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies){

        Document page = null;
        try {
            page = getDocument();

        Elements elements = page.getElementsByAttributeValueContaining("class", "template");
        Element templateElement = elements.first();
        Element template = templateElement.clone();
        template.removeAttr("style");
        template.removeClass("template");


        for(Element e : page.select("tr.vacancy")){
            if (!e.hasClass("template")) e.remove();
        }

        for (Vacancy vacancy : vacancies){
            Element templateCopy = template.clone();
            templateCopy.select("td.city").first().text(vacancy.getCity());
            templateCopy.select("td.companyName").first().text(vacancy.getCompanyName());
            templateCopy.select("td.salary").first().text(vacancy.getSalary());
            templateCopy.select("td.title a").first().attr("href", vacancy.getUrl());
            templateCopy.select("td.title a").first().text(vacancy.getTitle());

            page.select("tr.template").first().before(templateCopy.outerHtml());
        }
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }

        return page.html();
    }

    private void updateFile(String s){

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }    finally
            {
                try
                {
                    if ( writer != null)
                        writer.close( );
                }
                catch ( IOException e)
                {
                }
            }
                }

    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
