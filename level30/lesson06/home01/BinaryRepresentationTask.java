package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by bezobid on 15.06.2016.
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int i;

    public BinaryRepresentationTask(int i) {
        this.i = i;
    }

    @Override
    protected String compute() {

        int x = i % 2;
        int y = i / 2;
        String result = String.valueOf(x);

        if (y > 0){
            BinaryRepresentationTask task = new BinaryRepresentationTask(y);
            task.fork();
            return task.join() + result;
        }
        return result;
    }
}
