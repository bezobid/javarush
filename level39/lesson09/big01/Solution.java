package com.javarush.test.level39.lesson09.big01;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get(
                "D:\\Java\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level39\\lesson09\\big01\\logs"));


        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date after = format.parse("03.01.2002 03:45:24");
        Date before = format.parse("14.11.2023 07:08:01");

        //System.out.println(logParser.getNumberOfUniqueIPs(null, before));

        /*for (String ip : logParser.getUniqueIPs(after, before)){
            System.out.println(ip);
        }*/

        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));

/*        for (String ip : logParser.getIPsForUser("Vasya Pupkin", null, null)){
            System.out.println(ip);
        }*/


/*        for (String ip : logParser.getIPsForEvent(Event.WRITE_MESSAGE, null, null)){
            System.out.println(ip);
        }*/


        /*for (String ip : logParser.getIPsForStatus(Status.OK, after, before)){
            System.out.println(ip);
        }*/
    }
}
