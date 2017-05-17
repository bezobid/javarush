package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bezobid on 01.06.2016.
 */
class AdvertisementStorage {
    private final List<Advertisement> videos = new ArrayList<>();
    private static AdvertisementStorage ourInstance = new AdvertisementStorage();

    public static AdvertisementStorage getInstance() {
        return ourInstance;
    }

    private AdvertisementStorage() {
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "Video_1", 5000, 80, 3 * 60));
        videos.add(new Advertisement(someContent, "Video_2", 3750, 10, 6 * 60));
        videos.add(new Advertisement(someContent, "Video_3", 1100, 12, 2 * 60));
        videos.add(new Advertisement(someContent, "Video_4", 3000, 10, 4 * 60));
        videos.add(new Advertisement(someContent, "Video_5", 3600, 70, 7 * 60));
        videos.add(new Advertisement(someContent, "Video_6", 2100, 10, 5 * 60));
        videos.add(new Advertisement(someContent, "Video_7", 1800, 50, 8 * 60));
        videos.add(new Advertisement(someContent, "Video_8", 2800, 60, 5 * 60));
        videos.add(new Advertisement(someContent, "Video_9", 4500, 90, 9 * 60));
    }


    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }
}
