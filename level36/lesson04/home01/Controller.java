package com.javarush.test.level36.lesson04.home01;

import java.util.List;

/**
 * Created by bezobid on 15.08.2016.
 */
public class Controller {
    Model model = new Model();

    public List<String> onDataListShow() {
        return model.getStringDataList();
    }

}
