package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import java.util.*;

/**
 * Created by bezobid on 01.06.2016.
 */
public class AdvertisementManager{


    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    private ArrayList<Combination> combinations = new ArrayList<>();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    private static class Combination{
        ArrayList<Advertisement> combination;
        int totalPrice;
        int totalTime;
        int length;

        public Combination(ArrayList<Advertisement> combination) {
            this.combination = combination;
            length = combination.size();
            for (Advertisement ad : combination){
                totalPrice += ad.getAmountPerOneDisplaying();
                totalTime += ad.getDuration();
            }
        }
    }

    public void processVideos() throws NoVideoAvailableException {


        List<Advertisement> ads = new ArrayList<>();
        for (Advertisement ad : storage.list()) {
            if (ad.getDuration() <= timeSeconds) ads.add(ad);
        }

        Advertisement[] adArray = new Advertisement[ads.size()];
        for (int x = 0; x < ads.size(); x++){
            adArray[x] = ads.get(x);
        }

        for(int numberOfElements = 1; numberOfElements <= ads.size(); numberOfElements++){
            combine(adArray, numberOfElements, 0, new Advertisement[numberOfElements]);
        }

        Collections.sort(combinations, new Comparator<Combination>() {
            @Override
            public int compare(Combination o1, Combination o2) {

                if (o1.totalPrice == o2.totalPrice) {
                    if (o1.totalTime == o2.totalTime){
                        return o1.length - o2.length;
                    }
                    return o2.totalTime - o1.totalTime;
                }
                return o2.totalPrice - o1.totalPrice;
            }
        });

/*

        System.out.println("-------------------------------------");
        for(Combination combination : combinations)
        {
            System.out.print("[Cost: " + combination.totalPrice + "\tTime: " + combination.totalTime + "]\t");

            for (Advertisement ad : combination.combination){
                System.out.print(ad.getName() + "  ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------");

*/

        List<Advertisement> adsList = combinations.get(0).combination;
        if (adsList.size() == 0) throw new NoVideoAvailableException();

        Collections.sort(adsList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                long diff = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();

                return (int) diff;
            }
        });

        Collections.sort(adsList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                    if (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying() != 0) return 0;

                        int pricePerSec1 = (int)((o1.getAmountPerOneDisplaying()*1.0 / o1.getDuration()) *1000);
                        int pricePerSec2 = (int)((o2.getAmountPerOneDisplaying()*1.0 / o2.getDuration()) *1000);
                        return pricePerSec1 - pricePerSec2;
            }
        });

        for (Advertisement ad : adsList){
            int pricePerSec = (int)((ad.getAmountPerOneDisplaying()*1.0 / ad.getDuration()) *1000);
            ConsoleHelper.writeMessage(ad.getName() + " is is displaying... "
                    + ad.getAmountPerOneDisplaying() + ", "
                    + pricePerSec);
            ad.revalidate();
        }
    }

    void combine(Advertisement[] arr, int len, int startPosition, Advertisement[] result){
        if (len == 0){
            Combination c = new Combination(new ArrayList<>(Arrays.asList(result)));

            if (c.totalTime <= timeSeconds){
                combinations.add(c);
            }
            return;
        }
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combine(arr, len-1, i+1, result);
        }
    }
}
