package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    Thread task;

    public void run() {
        try {
            while (!task.isInterrupted()) {
                Thread.sleep(0);
                System.out.println(task.getName());

                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
        }
    }


    @Override
    public void start(String threadName) {
        task = new Thread(this);
        task.setName(threadName);
        task.start();
    }

    @Override
    public void stop() {
        task.interrupt();
    }
}
