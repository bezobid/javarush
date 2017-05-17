package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by bezobid on 15.06.2016.
 */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int x = 1; x < 10; x++){
            String name = "ShareItem-" + x;
            System.out.format("Элемент '%s' добавлен\n", name);
            queue.offer(new ShareItem(name, x));

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            if (queue.hasWaitingConsumer()) System.out.println("Consumer в ожидании!");
        }

    }
}
