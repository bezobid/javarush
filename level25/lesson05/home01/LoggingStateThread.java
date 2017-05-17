package com.javarush.test.level25.lesson05.home01;

/**
 * Created by bezobid on 18.04.2016.
 */
public class LoggingStateThread extends Thread{
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        Thread.State lastState = thread.getState();
        System.out.println(lastState);
        while (lastState != State.TERMINATED) {
            Thread.State currentState = thread.getState();
            if (currentState != lastState) {
                lastState = currentState;
                System.out.println(thread.getState().toString());
            }
        }

    }
}
