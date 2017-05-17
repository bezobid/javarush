package com.javarush.test.level25.lesson05.task01;

/**
 * Created by bezobid on 15.04.2016.
 */
public class Threadz implements Runnable{
    @Override
    public void run() {
        while(true){}
    }
}

class Test{
    public static void main(String[] args) {
        Thread thread = new Thread(new Threadz(), "t1");
        thread.start();

        switch (thread.getState()){
            case NEW:
                System.out.println(thread.getName() + " : NEW");

                //thread.start();

            case WAITING:
                System.out.println(thread.getName() + " : WAITING");
                //thread.interrupt();

            case TIMED_WAITING:
                System.out.println(thread.getName() + " : TIMED WAITING");
                //thread.interrupt();

            case RUNNABLE:
                System.out.println(thread.getName() + " : RUNNABLE");
                //thread.isInterrupted();

            case TERMINATED:
                System.out.println(thread.getName() + " : TERMINATED");
                //System.out.println(thread.getPriority());

            default:
                break;

        }

    }
}
